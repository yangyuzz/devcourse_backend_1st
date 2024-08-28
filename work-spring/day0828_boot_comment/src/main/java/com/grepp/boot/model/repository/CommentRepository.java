package com.grepp.boot.model.repository;


import com.grepp.boot.model.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentRepository {
    int insert(CommentDTO comment);
    List<CommentDTO> selectList(int bno);
}
