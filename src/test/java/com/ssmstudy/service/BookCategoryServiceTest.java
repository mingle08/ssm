package com.ssmstudy.service;

import com.ssmstudy.entity.Book;
import com.ssmstudy.entity.BookCategory;
import com.ssmstudy.mapper.BookCategoryMapper;
import com.ssmstudy.service.impl.BookCategoryServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for BookCategoryService
 */
public class BookCategoryServiceTest {

    @Mock
    private BookCategoryMapper bookCategoryMapper;

    @InjectMocks
    private BookCategoryServiceImpl bookCategoryService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSelectAll1() {
        // Arrange
        BookCategory category1 = new BookCategory();
        category1.setId(1);
        category1.setCategoryName("Fiction");

        BookCategory category2 = new BookCategory();
        category2.setId(2);
        category2.setCategoryName("Science");

        List<BookCategory> expectedCategories = Arrays.asList(category1, category2);
        when(bookCategoryMapper.selectAll1()).thenReturn(expectedCategories);

        // Act
        List<BookCategory> actualCategories = bookCategoryService.selectAll1();

        // Assert
        assertNotNull(actualCategories);
        assertEquals(2, actualCategories.size());
        assertEquals("Fiction", actualCategories.get(0).getCategoryName());
        verify(bookCategoryMapper, times(1)).selectAll1();
    }

    @Test
    public void testFindCategoryWithBook1() {
        // Arrange
        Integer categoryId = 1;
        BookCategory expectedCategory = new BookCategory();
        expectedCategory.setId(categoryId);
        expectedCategory.setCategoryName("Fiction");

        Book book = new Book();
        book.setId(1);
        book.setBookName("The Great Novel");
        expectedCategory.setBookList(Arrays.asList(book));

        when(bookCategoryMapper.findCategoryWithBook1(categoryId)).thenReturn(expectedCategory);

        // Act
        BookCategory actualCategory = bookCategoryService.findCategoryWithBook1(categoryId);

        // Assert
        assertNotNull(actualCategory);
        assertEquals(categoryId, actualCategory.getId());
        assertEquals("Fiction", actualCategory.getCategoryName());
        assertNotNull(actualCategory.getBookList());
        assertEquals(1, actualCategory.getBookList().size());
        verify(bookCategoryMapper, times(1)).findCategoryWithBook1(categoryId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindCategoryWithBook1WithNullId() {
        // Act
        bookCategoryService.findCategoryWithBook1(null);
    }

    @Test
    public void testSelectAll2() {
        // Arrange
        BookCategory category1 = new BookCategory();
        category1.setId(1);
        category1.setCategoryName("History");

        List<BookCategory> expectedCategories = Arrays.asList(category1);
        when(bookCategoryMapper.selectAll2()).thenReturn(expectedCategories);

        // Act
        List<BookCategory> actualCategories = bookCategoryService.selectAll2();

        // Assert
        assertNotNull(actualCategories);
        assertEquals(1, actualCategories.size());
        assertEquals("History", actualCategories.get(0).getCategoryName());
        verify(bookCategoryMapper, times(1)).selectAll2();
    }

    @Test
    public void testFindCategoryWithBook2() {
        // Arrange
        Integer categoryId = 2;
        BookCategory expectedCategory = new BookCategory();
        expectedCategory.setId(categoryId);
        expectedCategory.setCategoryName("Science");

        when(bookCategoryMapper.findCategoryWithBook2(categoryId)).thenReturn(expectedCategory);

        // Act
        BookCategory actualCategory = bookCategoryService.findCategoryWithBook2(categoryId);

        // Assert
        assertNotNull(actualCategory);
        assertEquals(categoryId, actualCategory.getId());
        assertEquals("Science", actualCategory.getCategoryName());
        verify(bookCategoryMapper, times(1)).findCategoryWithBook2(categoryId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindCategoryWithBook2WithNullId() {
        // Act
        bookCategoryService.findCategoryWithBook2(null);
    }
}
