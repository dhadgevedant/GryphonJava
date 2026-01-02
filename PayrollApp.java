//use concepts like exceptions, file handling, collections
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;  


public class PayrollApp {

    private List<Employee> employees = new ArrayList<>();

    public void loadEmployeesFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 3) {
                    String name = data[0];
                    String id = data[1];
                    double salary = Double.parseDouble(data[2]);
                    employees.add(new Employee(name, id, salary));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing salary: " + e.getMessage());
        }
    }

    public void savePayrollToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Employee emp : employees) {
                writer.write(emp.getName() + "," + emp.getId() + "," + emp.getSalary() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
       
        //menu driven and cases for user interaction
        PayrollApp app = new PayrollApp();
        app.loadEmployeesFromFile("employees.txt");
        app.savePayrollToFile("payroll.txt");   

        System.out.println("Payroll application started.");

    }
}