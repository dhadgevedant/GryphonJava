public class IsPrime {
    //java program to check if a number is prime or not
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;   
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; 
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int numToCheck = 29; // Example number
        if (isPrime(numToCheck)) {
            System.out.println(numToCheck + " is a prime number.");
        } else {
            System.out.println(numToCheck + " is not a prime number.");
        }
    }
}
