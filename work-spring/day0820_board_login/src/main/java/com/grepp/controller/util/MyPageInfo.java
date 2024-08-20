package com.grepp.controller.util;

public class MyPageInfo {
    private boolean isForward;
    private String path;

    public MyPageInfo(boolean isForward, String path) {
        this.isForward = isForward;
        this.path = path;
    }

    public boolean isForward() {
        return isForward;
    }

    public void setForward(boolean forward) {
        isForward = forward;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "MyPageInfo{" +
                "isForward=" + isForward +
                ", path='" + path + '\'' +
                '}';
    }
}
