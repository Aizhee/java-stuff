package OOP;

import java.nio.charset.Charset;

public class StringManipulation {
    public static void main(String[] args) {
        // Original phrase
        String originalPhrase = "I hate you";

        // Example 1: Replacing "hate" with "love"
        String modifiedPhrase1 = replaceText(originalPhrase, "hate", "love");
        printResult("Example 1: Replacing 'hate' with 'love'", modifiedPhrase1);

        // Example 2: Converting to uppercase
        String modifiedPhrase2 = toUpperCase(originalPhrase);
        printResult("Example 2: Converting to uppercase", modifiedPhrase2);

        // Example 3: Checking if the phrase contains "love"
        boolean containsLove = containsSubstring(originalPhrase, "love");
        printResult("Example 3: Checking if the phrase contains 'love'", containsLove);

        // Example 4: Getting the length of the phrase
        int phraseLength = getLength(originalPhrase);
        printResult("Example 4: Getting the length of the phrase", phraseLength);

        // Example 5: Encoding string to bytes using default charset
        byte[] bytes = encodeToBytes(originalPhrase);
        System.out.println("Example 5: Encoded bytes using default charset: " + bytes);

        // Example 6: Building a string using StringBuilder
        String builtString = buildString();
        System.out.println("Example 6: Built String using StringBuilder: " + builtString);
    }

    // Method to replace text within a string
    public static String replaceText(String original, String oldText, String newText) {
        return original.replace(oldText, newText);
    }

    // Method to convert a string to uppercase
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    // Method to check if a string contains a substring
    public static boolean containsSubstring(String str, String substr) {
        return str.contains(substr);
    }

    // Method to get the length of a string
    public static int getLength(String str) {
        return str.length();
    }

    // Method to encode string to bytes using default charset
    public static byte[] encodeToBytes(String str) {
        return str.getBytes(Charset.defaultCharset());
    }

    // Method to build a string using StringBuilder
    public static String buildString() {
        StringBuilder sb = new StringBuilder();
        sb.append("This");
        sb.append(" is");
        sb.append(" a");
        sb.append(" built");
        sb.append(" string");
        return sb.toString();
    }

    // Method to print the result
    public static void printResult(String description, Object result) {
        System.out.println(description + ": " + result);
    }
}


