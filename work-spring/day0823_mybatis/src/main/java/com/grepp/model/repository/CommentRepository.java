package com.grepp.model.repository;

import com.grepp.model.dto.CommentDTO;

import java.util.List;

public interface CommentRepository {
    int insert(CommentDTO comment);
    List<CommentDTO> selectList(int bno);
}
