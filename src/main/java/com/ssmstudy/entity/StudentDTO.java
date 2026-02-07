package com.ssmstudy.entity;

public class StudentDTO extends Student {
    private String code;

    public StudentDTO() {
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "code='" + code + '\'' +
                ", " + super.toString() +
                '}';
    }
}