package com.epam.mjc;

public class StudentManager {

  private static final long[] IDs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};

  public Student find(long studentID) throws StudentNotFoundException{
    Student student;
    if (IDs.length>studentID) {
      student = Student.getValueOf(studentID);
    }else {
      throw new StudentNotFoundException("Could not find student with ID " + studentID);
    }
    return student;
  }

  public static void main(String[] args) throws StudentNotFoundException{
    StudentManager manager = new StudentManager();
    for (int i = 0; i < IDs.length-1; i++) {
        Student    student = manager.find(IDs[i]);

        System.out.println("Student name " + student.getName());
    }

  }
}