package com.grepp.model.service;

import com.grepp.model.repository.MemberRepository;
import com.grepp.model.repository.MemberRepositoryMysql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class MemberService {
//    private MemberService(){}
//    private static MemberService instance = new MemberService();
//    public static MemberService getInstance() {
//        return instance;
//    }
    @Autowired
    private MemberRepository repo;// = MemberRepositoryMysql.getInstance();

    public String login(String userid, String userpw) throws SQLException {
        return repo.selectOne(userid,userpw);
    }
}
