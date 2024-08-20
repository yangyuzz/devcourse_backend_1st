package com.grepp.model.service;

import com.grepp.model.repository.MemberRepository;
import com.grepp.model.repository.MemberRepositoryMysql;

import java.sql.SQLException;

public class MemberService {
    private MemberService(){}
    private static MemberService instance = new MemberService();
    public static MemberService getInstance() {
        return instance;
    }

    private MemberRepository repo = MemberRepositoryMysql.getInstance();

    public String login(String userid, String userpw) throws SQLException {
        return repo.selectOne(userid,userpw);
    }
}
