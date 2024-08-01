package model;

import java.sql.SQLException;
import java.util.List;

public class BoardRepositoryOracle implements BoardRepository{

    @Override
    public int insert(BoardDTO board) {
        return 0;
    }

    @Override
    public int update(BoardDTO board) throws SQLException {
        return 0;
    }

//    @Override
//    public int update(BoardDTO board, String category) {
//        return 0;
//    }

    @Override
    public int delete(BoardDTO board) {
        return 0;
    }

    @Override
    public List<BoardDTO> selectAll() {
        return List.of();
    }

    @Override
    public BoardDTO selectOne(int id) {
        return null;
    }
}
