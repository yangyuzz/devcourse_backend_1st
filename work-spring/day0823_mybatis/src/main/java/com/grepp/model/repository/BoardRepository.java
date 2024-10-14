package com.grepp.model.repository;

import com.grepp.model.dto.BoardDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;


public interface BoardRepository {
    @Insert("INSERT INTO BOARD_TB(TITLE,WRITER,CONTENT,REG_DATE) VALUES(#{title},#{writer},#{content},NOW())")
    int insert(BoardDTO board) throws SQLException;
//    int update(BoardDTO board, String category) throws SQLException;
//    int update(BoardDTO board) throws SQLException;
//    int delete(BoardDTO board)throws SQLException;
    List<BoardDTO> selectList(@Param("sr")int startRow, @Param("cnt")int count);
    int selectCount();
    List<BoardDTO> selectAll()throws SQLException;
    BoardDTO selectOne(int id)throws SQLException;

}
