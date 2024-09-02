package com.grepp.jpa.model.dto;

import java.util.List;

// DB 테이블이랑 상관 없이 시스템에서 활용하는 데이터 뭉탱이 (테이블 구조와 정확히 일치하지 않음.)
public class BoardDTO {
    private int no;
    private String title;
    private String content;
    private String writer;
    private int readCount;
    private String regDate;
    private List<FileDTO> fileDTOList;

    public BoardDTO() {
    }

    public BoardDTO(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

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

    public List<FileDTO> getFileDTOList() {
        return fileDTOList;
    }

    public void setFileDTOList(List<FileDTO> fileDTOList) {
        this.fileDTOList = fileDTOList;
    }

    @Override
    public String toString() {
        return "BoardDTO{" +
                "no=" + no +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", readCount=" + readCount +
                ", regDate='" + regDate + '\'' +
                '}';
    }

}