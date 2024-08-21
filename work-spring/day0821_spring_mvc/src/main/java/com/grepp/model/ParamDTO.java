package com.grepp.model;

public class ParamDTO {
    private String param1;
    private int param2;

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public int getParam2() {
        return param2;
    }

    public void setParam2(int param2) {
        this.param2 = param2;
    }

    @Override
    public String toString() {
        return "ParamDTO{" +
                "param1='" + param1 + '\'' +
                ", param2=" + param2 +
                '}';
    }
}
