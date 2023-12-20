package com.ssmstudy.util;

import java.util.ArrayList;
import java.util.List;

import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.javers.core.diff.changetype.ValueChange;

import com.ssmstudy.entity.Book;
import com.ssmstudy.entity.BookCategory;
import com.ssmstudy.entity.Emp;

public class JaversDemo {

    public static void main(String[] args) {

        Javers javers = JaversBuilder.javers().build();
        
        Emp bfImg = new Emp();
        bfImg.setId(1);
        bfImg.setName("Rachel");
        bfImg.setSex("F");
        bfImg.setAge(26);
        bfImg.setAddress("Nanshan University Town");

        Emp afImg = new Emp();
        afImg.setId(1);
        afImg.setName("Monica");
        afImg.setSex("F");
        afImg.setAge(27);
        afImg.setAddress(null);
        afImg.setEmail("rachel@gmail.com");

        Diff diff = javers.compare(bfImg, afImg);
        List<ValueChange> changes = diff.getChangesByType(ValueChange.class);

        System.out.println(changes.size());

        for (ValueChange valueChange : changes) {
            System.out.print(valueChange.getLeft());
            System.out.print(" <- " + valueChange.getPropertyName() + " -> ");
            System.out.println(valueChange.getRight());
        }

        List<Book> list1 = new ArrayList<>();

        Book b1 = new Book();
        b1.setId(1);
        b1.setBookName("深入理解Java虚拟机");
        b1.setPrice(129.00F);

        Book b2 = new Book();
        b2.setId(2);
        b2.setBookName("java基础从入门到精通");
        b2.setPrice(98.00F);

        list1.add(b1);
        list1.add(b2);

        BookCategory javaBook = new BookCategory();
        javaBook.setId(12);
        javaBook.setCategoryName("java book");
        javaBook.setBookList(list1);

        List<Book> list2 = new ArrayList<>();

        Book b3 = new Book();
        b3.setId(2);
        b3.setBookName("深入理解oracel");
        b3.setPrice(143.00F);

        Book b4 = new Book();
        b4.setId(3);
        b4.setBookName("mysql从入门到精通");
        b4.setPrice(98.00F);

        list2.add(b3);
        list2.add(b4);

        BookCategory databaseBook = new BookCategory();
        databaseBook.setId(12);
        databaseBook.setCategoryName("database book");
        databaseBook.setBookList(list2);

        Diff diff2 = javers.compare(javaBook, databaseBook);
        
        System.out.println(diff2);

    }

    

}
