//demonstrate inhertiance using eimployee,developer, manager, intern classes
public class CompanyApp {
    public static void main(String[] args) {    
        Developer dev = new Developer("Alice", 101, "Java");
        Manager mgr = new Manager("Bob", 102, 5);
        Intern intern = new Intern("Charlie", 103, "XYZ University");

        dev.displayInfo();
        dev.work();

        mgr.displayInfo();
        mgr.work();

        intern.displayInfo();
        intern.work();
    }

}

class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Employee(String name2, String id2, double salary) {
        //TODO Auto-generated constructor stub
    }

    void displayInfo() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
    }

    void work() {
        System.out.println(name + " is working.");
    }

    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    public String getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    public String getSalary() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSalary'");
    }
}
class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, String programmingLanguage) {
        super(name, id);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    void work() {
        System.out.println(name + " is coding in " + programmingLanguage + ".");
    }
}
class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, int teamSize) {
        super(name, id);
        this.teamSize = teamSize;
    }

    @Override
    void work() {
        System.out.println(name + " is managing a team of " + teamSize + " members.");
    }
}
class Intern extends Employee {
    String university;
    Intern(String name, int id, String university) {
        super(name, id);
        this.university = university;
    }
    @Override
    void work() {
        System.out.println(name + " is interning from " + university + ".");
    }
}