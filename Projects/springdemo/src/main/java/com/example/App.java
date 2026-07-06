package com.example;


public class App 
{
    public static void main( String[] args )
    {
        StudentDao studentDao = new StudentDao();
        Student student = new Student(1, "John Doe", "john.doe@example.com");
        studentDao.saveStudent(student);

        System.out.println("Student saved successfully!");
        System.out.println(student.getName() + " " + student.getEmail());
    }
}