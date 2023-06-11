package com.ssmstudy;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.ssmstudy.entity.Book;
import com.ssmstudy.jpaDemo.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/spring-context.xml"})
public class JpaTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testDto() throws Exception {
//        List<Book> bookList = bookRepository.findByBookName("Spring源码深度解析");
//        if (CollectionUtils.isNotEmpty(bookList)) {
//            System.out.println(bookList.size());
//        }

    }
}
