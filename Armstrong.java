public class Armstrong {
   
    public static boolean isArmstrong(int number) {
        int originalNumber = number;
        int sum = 0;
        int digits = String.valueOf(number).length();

        while (number != 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }

        return sum == originalNumber;
    }

    public static void main(String[] args) {
        int testNumber = 153; // Example number
        if (isArmstrong(testNumber)) {
            System.out.println(testNumber + " is an Armstrong number.");
        } else {
            System.out.println(testNumber + " is not an Armstrong number.");
        }
    }
}
