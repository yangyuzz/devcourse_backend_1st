package com.grepp.boot.model.dto;

public class CommentDTO {
    private int cno;
    private int bno;
    private String cwriter;
    private String ccontent;

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getCwriter() {
        return cwriter;
    }

    public void setCwriter(String cwriter) {
        this.cwriter = cwriter;
    }

    public String getCcontent() {
        return ccontent;
    }

    public void setCcontent(String ccontent) {
        this.ccontent = ccontent;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "cno=" + cno +
                ", bno=" + bno +
                ", cwriter='" + cwriter + '\'' +
                ", ccontent='" + ccontent + '\'' +
                '}';
    }
}
