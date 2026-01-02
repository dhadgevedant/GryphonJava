// employee (id, name, salary, department) management System using hash map
// add, delete, update, display employees

import java.util.HashMap;
import java.util.Map;

public class HashMp {

    private Map<Integer, Employee> employeeMap;

    public HashMp() {
        employeeMap = new HashMap<>();
    }

    // Employee class to hold employee details
    static class Employee {
        int id;
        String name;
        double salary;
        String department;

        Employee(int id, String name, double salary, String department) {
            this.id = id;
            this.name = name;
            this.salary = salary;
            this.department = department;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Salary: " + salary + ", Department: " + department;
        }
    }

    // Method to add an employee
    public void addEmployee(int id, String name, double salary, String department) {
        Employee emp = new Employee(id, name, salary, department);
        employeeMap.put(id, emp);
        System.out.println("Employee added: " + emp);
    }

    // Method to update an employee
    public void updateEmployee(int id, String name, double salary, String department) {
        Employee emp = employeeMap.get(id);
        if (emp != null) {
            emp.name = name;
            emp.salary = salary;
            emp.department = department;
            System.out.println("Employee updated: " + emp);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    // Method to delete an employee by ID
    public void deleteEmployee(int id) {
        Employee removedEmp = employeeMap.remove(id);
        if (removedEmp != null) {
            System.out.println("Employee deleted: " + removedEmp);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    // Method to display all employees
    public void displayEmployees() {
        System.out.println("Employee List:");
        for (Employee emp : employeeMap.values()) {
            System.out.println(emp);
        }
    }

    // Main method to test the Employee Management System
    public static void main(String[] args) {
        HashMp empSystem = new HashMp();
        
        empSystem.addEmployee(1, "Alice", 60000, "HR");
        empSystem.addEmployee(2, "Bob", 75000, "IT");
        empSystem.addEmployee(3, "Charlie", 50000, "Finance");
        
        // user menu to interact with the system
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice; 
        do {
            //clear console
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Display Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter employee department: ");
                    String department = scanner.nextLine();
                    empSystem.addEmployee(id, name, salary, department);
                    break;
                
                case 2:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    empSystem.deleteEmployee(deleteId);
                    break;
                
                    case 3:
                    System.out.print("Enter employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new employee name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new employee salary: ");
                    double newSalary = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new employee department: ");
                    String newDepartment = scanner.nextLine();
                    empSystem.updateEmployee(updateId, newName, newSalary, newDepartment);
                    break;

                case 4:
                    empSystem.displayEmployees();
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            //press enter to continue
            System.out.println("Press Enter to continue...");   
            try {
                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } while (choice != 5);

        scanner.close();

    }
}