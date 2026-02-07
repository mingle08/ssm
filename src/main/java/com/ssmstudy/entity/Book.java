package com.ssmstudy.entity;

public class Book {
    private Integer id;
    private String bookName;
    private Float price;

    public Book() {
    }

    public Book(Integer id, String bookName, Float price) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                '}';
    }
}
