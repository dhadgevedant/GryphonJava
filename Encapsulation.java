public class Encapsulation {
    private String name;
    private int age;

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        if (age > 0) { // Simple validation
            this.age = age;
        } else {
            System.out.println("Please enter a valid age.");
        }
    }

    //main method to test encapsulation
    public static void main(String[] args) {
        Encapsulation person = new Encapsulation();
        person.setName("John Doe");
        person.setAge(25); 
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
    }
}
