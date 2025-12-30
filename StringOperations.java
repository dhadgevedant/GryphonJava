public class StringOperations {
    public static void main(String[] args) {
        String str1 = "Hello, ";
        String str2 = "World!";
        
        // Concatenation
        String concatenated = str1 + str2;
        System.out.println("Concatenated String: " + concatenated);
        
        // Length
        int length = concatenated.length();
        System.out.println("Length of Concatenated String: " + length);
        
        // Substring
        String substring = concatenated.substring(7, 12);
        System.out.println("Substring (7 to 12): " + substring);
        
        // Uppercase
        String upperCase = concatenated.toUpperCase();
        System.out.println("Uppercase String: " + upperCase);
        
        // Lowercase
        String lowerCase = concatenated.toLowerCase();
        System.out.println("Lowercase String: " + lowerCase);

        // Replace
        String replacedString = concatenated.replace("World", "Java");
        System.out.println("Replaced String: " + replacedString);

        //chatAt
        char charAtIndex5 = concatenated.charAt(7);
        System.out.println("Character at index 5: " + charAtIndex5);


    }
}

