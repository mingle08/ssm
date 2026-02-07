package com.ssmstudy.service;

import com.ssmstudy.entity.Emp;
import com.ssmstudy.mapper.EmpExtMapper;
import com.ssmstudy.service.impl.EmpServiceImpl;
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
 * Unit tests for EmpService
 */
public class EmpServiceTest {

    @Mock
    private EmpExtMapper empMapper;

    @InjectMocks
    private EmpServiceImpl empService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSelectAll() {
        // Arrange
        Emp emp1 = new Emp();
        emp1.setId(1);
        emp1.setName("Alice Johnson");
        emp1.setEmail("alice@example.com");

        Emp emp2 = new Emp();
        emp2.setId(2);
        emp2.setName("Bob Williams");
        emp2.setEmail("bob@example.com");

        List<Emp> expectedEmps = Arrays.asList(emp1, emp2);
        when(empMapper.selectAll()).thenReturn(expectedEmps);

        // Act
        List<Emp> actualEmps = empService.selectAll();

        // Assert
        assertNotNull(actualEmps);
        assertEquals(2, actualEmps.size());
        assertEquals("Alice Johnson", actualEmps.get(0).getName());
        assertEquals("alice@example.com", actualEmps.get(0).getEmail());
        verify(empMapper, times(1)).selectAll();
    }

    @Test
    public void testInsert() {
        // Arrange
        Emp newEmp = new Emp();
        newEmp.setName("Charlie Brown");
        newEmp.setEmail("charlie@example.com");
        newEmp.setAge(25);

        // Act
        empService.insert(newEmp);

        // Assert
        verify(empMapper, times(1)).insert(newEmp);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsertWithNullEmployee() {
        // Act
        empService.insert(null);
    }
}
