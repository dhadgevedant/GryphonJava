package com.demo;

import java.util.Scanner;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.Level;

public class App 
{
    public static void main( String[] args )
    {       
        // Suppress JBoss Logging / Hibernate verbose console output
        System.setProperty("org.jboss.logging.provider", "jdk");
        LogManager.getLogManager().reset();
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Logger.getLogger("org.jboss.logging").setLevel(Level.OFF);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Student Email: ");
        String email = sc.nextLine();

        StudentDao studentDao = new StudentDao();
        Student student = new Student(name, email);
        studentDao.saveStudent(student);

        System.out.println("Student saved successfully!");
        System.out.println(student.getName() + " " + student.getEmail());
        System.out.println();

        // Retrieve all students and print in a clean table format
        List<Student> students = studentDao.getAllStudents();
        printStudentTable(students);

        sc.close();
        
        // Gracefully shutdown SessionFactory to exit application
        HibernateUtil.shutdown();
    }

    private static void printStudentTable(List<Student> students) {
        int idWidth = 6;     // min for "ID"
        int nameWidth = 6;   // min for "Name"
        int emailWidth = 7;  // min for "Email"

        for (Student s : students) {
            idWidth = Math.max(idWidth, String.valueOf(s.getId()).length() + 2);
            nameWidth = Math.max(nameWidth, (s.getName() != null ? s.getName().length() : 4) + 2);
            emailWidth = Math.max(emailWidth, (s.getEmail() != null ? s.getEmail().length() : 5) + 2);
        }

        String rowFormat = "| %-" + (idWidth - 2) + "s | %-" + (nameWidth - 2) + "s | %-" + (emailWidth - 2) + "s |\n";

        StringBuilder borderBuilder = new StringBuilder();
        borderBuilder.append("+");
        for (int i = 0; i < idWidth; i++) borderBuilder.append("-");
        borderBuilder.append("+");
        for (int i = 0; i < nameWidth; i++) borderBuilder.append("-");
        borderBuilder.append("+");
        for (int i = 0; i < emailWidth; i++) borderBuilder.append("-");
        borderBuilder.append("+");
        String border = borderBuilder.toString();

        System.out.println(border);
        System.out.printf(rowFormat, "ID", "Name", "Email");
        System.out.println(border);
        for (Student s : students) {
            System.out.printf(rowFormat, 
                String.valueOf(s.getId()), 
                s.getName() != null ? s.getName() : "null", 
                s.getEmail() != null ? s.getEmail() : "null"
            );
        }
        System.out.println(border);
    }
}
