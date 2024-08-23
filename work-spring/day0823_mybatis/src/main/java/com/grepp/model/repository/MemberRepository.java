package com.grepp.model.repository;

import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;

public interface MemberRepository {
    String selectOne(@Param("uuu") String userid,@Param("ppp") String userpw) throws SQLException;
}
