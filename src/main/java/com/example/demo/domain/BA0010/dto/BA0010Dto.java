package com.example.demo.domain.BA0010.dto;

public class BA0010Dto {
    private int pseq;
    private String name;

    public int getPseq() {
        return pseq;
    }

    public void setPseq(int pseq) {
        this.pseq = pseq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BA0010Dto{" +
                "pseq=" + pseq +
                ", name='" + name + '\'' +
                '}';
    }
}
