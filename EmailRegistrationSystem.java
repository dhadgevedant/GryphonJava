public class EmailRegistrationSystem {
    private java.util.HashSet<String> registeredEmails;

    public EmailRegistrationSystem() {
        registeredEmails = new java.util.HashSet<>();
    }

    // Method to register a new email
    public boolean registerEmail(String email) {
        if (registeredEmails.contains(email)) {
            System.out.println("Email already registered: " + email);
            return false;
        } else {
            registeredEmails.add(email);
            System.out.println("Email successfully registered: " + email);
            return true;
        }
    }

    // Method to unregister an email
    public boolean unregisterEmail(String email) {
        if (registeredEmails.contains(email)) {
            registeredEmails.remove(email);
            System.out.println("Email successfully unregistered: " + email);
            return true;
        } else {
            System.out.println("Email not found: " + email);
            return false;
        }
    }

    // Method to display all registered emails
    public void displayRegisteredEmails() {
        System.out.println("Registered Emails:");
        for (String email : registeredEmails) {
            System.out.println(email);
        }
    }

    // Main method to test the Email Registration System
    public static void main(String[] args) {
        
        // Menue using switch case for user to interact with the system
        EmailRegistrationSystem emailSystem = new EmailRegistrationSystem();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice; 
        do {

            //clear console
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("\nEmail Registration System Menu:");
            System.out.println("1. Register Email");
            System.out.println("2. Unregister Email");
            System.out.println("3. Display Registered Emails");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter email to register: ");
                    String emailToRegister = scanner.nextLine();
                    emailSystem.registerEmail(emailToRegister);
                    break;
                case 2:
                    System.out.print("Enter email to unregister: ");
                    String emailToUnregister = scanner.nextLine();
                    emailSystem.unregisterEmail(emailToUnregister);
                    break;
                case 3:
                    emailSystem.displayRegisteredEmails();
                    break;
                case 4:
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

        } while (choice != 4);

        

        scanner.close();

        
        
    }
}