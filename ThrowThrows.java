public class ThrowThrows {
    // Method that throws an exception
    public static void riskyMethod() throws Exception {
        throw new Exception("An error occurred in riskyMethod");
    }

    // Method that calls the risky method and handles the exception
    public static void safeMethod() {
        try {
            riskyMethod();
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        safeMethod();
    }
}
