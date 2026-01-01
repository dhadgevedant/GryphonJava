public class AgeCheckException extends Exception {
    public AgeCheckException(String message) {
        super(message);
    }

    public static void main(String[] args) {
        Voter voter1 = new Voter("John", 20);
        Voter voter2 = new Voter("Jane", 16);

        try {
            voter1.checkEligibility();
            voter2.checkEligibility();
        } catch (AgeCheckException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}

class Voter {
    private String name;
    private int age;

    public Voter(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void checkEligibility() throws AgeCheckException {
        if (age < 18) {
            throw new AgeCheckException("Voter " + name + " is not eligible to vote. Age: " + age);
        } else {
            System.out.println("Voter " + name + " is eligible to vote.");
        }
    }
}
