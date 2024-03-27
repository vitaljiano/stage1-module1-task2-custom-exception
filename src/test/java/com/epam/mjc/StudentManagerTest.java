package com.epam.mjc;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class StudentManagerTest {
    StudentManager manager = new StudentManager();

    @Test(expected = IllegalArgumentException.class)
    public void findNotValid() throws IllegalArgumentException {

        try {
            manager.find(1000);
        } catch (StudentNotFoundException e) {
            throw new IllegalArgumentException(e);
        }

    }

    @Test
    public void findValidStudent() throws StudentNotFoundException {
        try {
            assertNotNull(manager.find(1));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testExceptionMessage() throws StudentNotFoundException {
        try {
            assertNotNull(manager.find(1000));
        } catch (StudentNotFoundException e) {
            assertEquals("Could not find student with ID 1000", e.getMessage());
        }
    }

    @Test
    public void testIDsNotChangedV1() throws StudentNotFoundException {
        try {
            assertNull("Student enum should be have only 10 values.", manager.find(11));
        } catch (StudentNotFoundException e) {
            new StudentNotFoundException("Student enum should be have only 10 values.");
        }
    }

    @Test
    public void testIDsNotChangedV2() throws StudentNotFoundException {
        assertEquals(Student.ARTUR, manager.find(Arrays.stream(Student.values()).map(Student::getId).max(Long::compare).get()));

    }

}