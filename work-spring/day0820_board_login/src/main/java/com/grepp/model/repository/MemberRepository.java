package com.grepp.model.repository;

import java.sql.SQLException;

public interface MemberRepository {
    String selectOne(String userid, String userpw) throws SQLException;
}
