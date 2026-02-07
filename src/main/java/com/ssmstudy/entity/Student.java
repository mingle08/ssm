package com.ssmstudy.entity;

public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Integer cardId;

    public Student() {
    }

    public Student(Integer id, String name, String sex, Integer cardId) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.cardId = cardId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", cardId=" + cardId +
                '}';
    }
}