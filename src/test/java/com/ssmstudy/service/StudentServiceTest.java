package com.ssmstudy.service;

import com.ssmstudy.entity.StudentDTO;
import com.ssmstudy.mapper.StudentExtMapper;
import com.ssmstudy.service.impl.StudentServiceImpl;
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
 * Unit tests for StudentService
 */
public class StudentServiceTest {

    @Mock
    private StudentExtMapper studentExtMapper;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSelectAll() {
        // Arrange
        StudentDTO student1 = new StudentDTO();
        student1.setId(1);
        student1.setName("John Doe");
        student1.setCode("STU001");

        StudentDTO student2 = new StudentDTO();
        student2.setId(2);
        student2.setName("Jane Smith");
        student2.setCode("STU002");

        List<StudentDTO> expectedStudents = Arrays.asList(student1, student2);
        when(studentExtMapper.selectAll()).thenReturn(expectedStudents);

        // Act
        List<StudentDTO> actualStudents = studentService.selectAll();

        // Assert
        assertNotNull(actualStudents);
        assertEquals(2, actualStudents.size());
        assertEquals("John Doe", actualStudents.get(0).getName());
        assertEquals("STU001", actualStudents.get(0).getCode());
        verify(studentExtMapper, times(1)).selectAll();
    }

    @Test
    public void testFindStudentById() {
        // Arrange
        Integer studentId = 1;
        StudentDTO expectedStudent = new StudentDTO();
        expectedStudent.setId(studentId);
        expectedStudent.setName("John Doe");
        expectedStudent.setCode("STU001");

        when(studentExtMapper.findStudentById(studentId)).thenReturn(expectedStudent);

        // Act
        StudentDTO actualStudent = studentService.findStudentById(studentId);

        // Assert
        assertNotNull(actualStudent);
        assertEquals(studentId, actualStudent.getId());
        assertEquals("John Doe", actualStudent.getName());
        assertEquals("STU001", actualStudent.getCode());
        verify(studentExtMapper, times(1)).findStudentById(studentId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindStudentByIdWithNullId() {
        // Act
        studentService.findStudentById(null);
    }
}
