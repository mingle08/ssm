package com.ssmstudy.entity;

public class StudentIdCard {
    private Integer id;
    private String code;

    public StudentIdCard() {
    }

    public StudentIdCard(Integer id, String code) {
        this.id = id;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "StudentIdCard{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}