package com.epam.mjc;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class StudentManagerTest {
    StudentManager manager = new StudentManager();

    @Test(expected = IllegalArgumentException.class)
    public void findNotValid() throws StudentNotFoundException {
        try {
            manager.find(1000);
        } catch (StudentNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Test
    public void findValidStudent() {
        try {
            assertNotNull(manager.find(1));
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testExceptionMessage()  {
        try {
            assertNotNull(manager.find(1000));
        } catch (StudentNotFoundException e) {
            assertEquals("Could not find student with ID 1000", e.getMessage());
        }
    }

    @Test
    public void testIDsNotChangedV1() {
        try {
            assertNull("Student enum should be have only 10 values.", manager.find(11));
        } catch (StudentNotFoundException e) {

        }
    }

    @Test
    public void testIDsNotChangedV2() {
        try {
            assertEquals(Student.ARTUR, manager.find(Arrays.stream(Student.values()).map(Student::getId).max(Long::compare).get()));
        } catch (StudentNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}