package com.grepp.model.repository;

import com.grepp.model.dto.BoardDTO;

import java.sql.SQLException;
import java.util.List;

// IBookManager
public interface BoardRepository {
    int insert(BoardDTO board) throws SQLException;
//    int update(BoardDTO board, String category) throws SQLException;
    int update(BoardDTO board) throws SQLException;
    int delete(BoardDTO board)throws SQLException;
    List<BoardDTO> selectAll()throws SQLException;
    BoardDTO selectOne(int id)throws SQLException;
}
