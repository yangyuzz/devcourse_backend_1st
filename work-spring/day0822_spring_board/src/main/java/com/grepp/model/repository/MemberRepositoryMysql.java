package com.grepp.model.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

//@Component
@Repository
public class MemberRepositoryMysql implements MemberRepository{
//    private MemberRepositoryMysql(){}
//    private static MemberRepositoryMysql instance = new MemberRepositoryMysql();
//    public static MemberRepositoryMysql getInstance() {
//        return instance;
//    }
///////////////////////////////////////////////////////////////////////
    @Override
    public String selectOne(String userid, String userpw) throws SQLException {
        // 원래는 여기서 디비작업 해야겠죠?!?!?!?! 지금은 약식으로 테스트만 !
        if("programmers".equals(userid) && "1234".equals(userpw))
            return userid;
        return null;
    }
}
