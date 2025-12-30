public class PasswordValidation {
    public static void main(String[] args) {
        String password = "Passw0rd!";

        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowercase = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            } else if ("!@#$%^&*()-+".indexOf(ch) >= 0) {
                hasSpecialChar = true;
            }
        }

        if (password.length() >= 8 && hasUppercase && hasLowercase && hasDigit && hasSpecialChar) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is invalid.");
        }
    }
}
