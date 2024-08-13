package com.grepp.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardRepositoryMysql implements BoardRepository {
    private BoardRepositoryMysql(){}
    private static BoardRepository instance = new BoardRepositoryMysql();
    public static BoardRepository getInstance() {
        return instance;
    }
    //    private static final String INSERT_SQL = "INSERT INTO INTO BOARD_TB(TITLE,WRITER,CONTENT,REG_DATE) VALUES(?,?,?,NOW())";

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public int insert(BoardDTO board) throws SQLException {
        int result = 0;
        try {
            String sql = " INSERT INTO " +
                    " BOARD_TB(TITLE,WRITER,CONTENT,REG_DATE) VALUES(?,?,?,NOW()) ";
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, board.getTitle());
            ps.setString(2, board.getWriter());
            ps.setString(3, board.getContent());
            result = ps.executeUpdate();
        }catch (SQLException ex){
            System.out.println("insert error");
            throw ex;
        }finally {
            DBUtil.close(ps, conn);
        }
        return result;
    }

//    @Override
//    public int update(BoardDTO board, String category) throws SQLException {
//        int result = 0;
//
//        try {
//            String sql = "UPDATE BOARD_TB SET ";
//            if("title".equals(category)){
//                sql += "TITLE = " + board.getTitle(); // ' 없어도 문자열 잘 들어가려나.....
//            }else if("writer".equals(category)){
//                sql += "WRITER = " + board.getWriter();
//            }else if("content".equals(category)){
//                sql += "CONTENT = " + board.getContent();
//            }
//            sql += " WHERE NO = " + board.getNo();
//            conn = DBUtil.getConnection();
//            ps = conn.prepareStatement(sql);
//            result = ps.executeUpdate();
//        }catch (SQLException ex){
//            System.out.println("update error");
//            throw ex;
//        }finally {
//            DBUtil.close(ps, conn);
//        }
//
//        return result;
//    }


    @Override
    public int update(BoardDTO board) throws SQLException {
        // 위의 update 버전은 수정하고싶은게 뭔지 정확히 찝어서 그것만 수정하기였고
        // 이 update는 수정하고 싶은게 여러개 이면 한꺼번에 수정하도록 값의 유무 체크해서 진행하는 버전
        int result = 0;

        try {
            String sql = " UPDATE BOARD_TB SET ";

            if(board.getTitle()!=null && board.getTitle().length()>0){ // 제목에 변경하고자 값이 확실히 있는지 체크해서
                sql += " TITLE='"+board.getTitle()+"', ";
            }
            if(board.getWriter()!=null && board.getWriter().length()>0){
                sql += " WRITER='"+board.getWriter()+"', ";
            }
            if(board.getContent()!=null && board.getContent().length()>0){
                sql += " CONTENT='"+board.getContent()+"', ";
            }
            sql = sql.substring(0, sql.length()-2);

            sql += " WHERE NO = "+board.getNo();
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            result = ps.executeUpdate();
        }catch (SQLException ex){
            System.out.println("update error");
            throw ex;
        }finally {
            DBUtil.close(ps, conn);
        }

        return result;
    }

    @Override
    public int delete(BoardDTO board) throws SQLException {
        return 0;
    }

    @Override
    public List<BoardDTO> selectAll() throws SQLException {
        List<BoardDTO> list = new ArrayList<BoardDTO>();
        try {
            String sql = " SELECT NO,TITLE,WRITER,CONTENT,READ_COUNT,REG_DATE FROM BOARD_TB ";
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(makeBoardDTO(rs));
            }
        }catch (SQLException ex){
            System.out.println("update error");
            throw ex;
        }finally {
            DBUtil.close(rs, ps, conn);
        }
        return list;
    }

    @Override
    public BoardDTO selectOne(int no) throws SQLException {
        BoardDTO board = null;

        try {
            String sql = " SELECT NO,TITLE,WRITER,CONTENT,READ_COUNT,REG_DATE FROM BOARD_TB WHERE NO="+no;
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){ // 글번호 이상하면 없을수는 있음.
                board = makeBoardDTO(rs);
            }
        }catch (SQLException ex){
            System.out.println("update error");
            throw ex;
        }finally {
            DBUtil.close(rs, ps, conn);
        }

        return board;
    }

    private BoardDTO makeBoardDTO(ResultSet rs) throws SQLException {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setNo(rs.getInt("NO"));
        boardDTO.setTitle(rs.getString("TITLE"));
        boardDTO.setWriter(rs.getString("WRITER"));
        boardDTO.setContent(rs.getString("CONTENT"));
        boardDTO.setReadCount(rs.getInt("READ_COUNT"));
        boardDTO.setRegDate(rs.getString("REG_DATE"));
        return boardDTO;
    }
}
