public class RemoveSpaces {
    public static void main(String[] args) {
        String stringWithSpaces = "  This is a string with spaces.  ";
        System.out.println("Original String: '" + stringWithSpaces + "'");

        // Remove leading and trailing spaces
        String trimmedString = stringWithSpaces.trim();
        System.out.println("Trimmed String: '" + trimmedString + "'");

        // Remove all spaces
        String stringWithoutSpaces = stringWithSpaces.replace(" ", "");
        System.out.println("String without spaces: '" + stringWithoutSpaces + "'");
    }
}
