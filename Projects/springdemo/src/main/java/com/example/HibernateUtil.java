package com.example;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.Student;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            try {

                Properties properties = new Properties();

                properties.put("hibernate.connection.driver_class",
                        "com.mysql.cj.jdbc.Driver");

                properties.put("hibernate.connection.url",
                        "jdbc:mysql://localhost:3306/studentdb");

                properties.put("hibernate.connection.username",
                        "root");

                properties.put("hibernate.connection.password",
                        "sasuekzzz");

                properties.put("hibernate.dialect",
                        "org.hibernate.dialect.MySQL8Dialect");

                properties.put("hibernate.hbm2ddl.auto",
                        "update");

                properties.put("hibernate.show_sql",
                        "true");

                properties.put("hibernate.format_sql",
                        "true");

                Configuration configuration = new Configuration();

                configuration.setProperties(properties);

                configuration.addAnnotatedClass(Student.class);

                sessionFactory = configuration.buildSessionFactory();

            } catch (Exception e) {

                e.printStackTrace();
                throw new RuntimeException("SessionFactory creation failed");

            }
        }

        return sessionFactory;
    }

    // TODO: The compilation errors (e.g., "package org.hibernate does not exist", "cannot find symbol SessionFactory")
    // indicate that the necessary Hibernate and JPA dependencies are missing from the project's classpath.
    // To resolve these errors, please ensure that the project's build configuration (e.g., pom.xml for Maven,
    // build.gradle for Gradle) includes the required Hibernate Core, Hibernate JPA API, and MySQL Connector/J libraries.
    // If compiling and running manually without a build tool, these JAR files must be explicitly added to the classpath.

    public static void closeFactory() {

        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}