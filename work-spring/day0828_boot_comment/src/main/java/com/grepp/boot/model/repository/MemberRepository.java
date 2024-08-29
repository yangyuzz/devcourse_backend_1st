package com.grepp.boot.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
@Mapper
public interface MemberRepository {
    String selectOne(@Param("uuu") String userid,@Param("ppp") String userpw) throws SQLException;
}
