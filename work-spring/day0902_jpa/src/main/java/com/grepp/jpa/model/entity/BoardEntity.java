package com.grepp.jpa.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

// 이 자바파일이 그대로 데이터베이스 테이블인거임! 즉 jpa 에서는 디비 테이블 안만들고 자바 클래스만 생성해도 자동으로 테이블이 되는거임!
@Entity(name="board_tb")
public class BoardEntity {
    @Id // pk로 설정할 칼럼한테 붙여주는
    @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY가 mysql에서 auto_increment 한다는 의미임.
    private int no;
    private String title;
    private String content;
    private String writer;
    private int readCount;
    @CreationTimestamp
//    @Column(name = "reg_date")
    private String regDate;
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "BoardEntity{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", readCount=" + readCount +
                ", regDate='" + regDate + '\'' +
                '}';
    }
}
