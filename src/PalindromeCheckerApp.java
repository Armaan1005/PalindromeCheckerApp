/**
 * -----------------------------------------------------------
 * MAIN CLASS - PalindromeCheckerApp
 * -----------------------------------------------------------
 *
 * Use Case 1: Application Entry & Welcome Message
 * Use Case 2: Hardcoded Palindrome Validation
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1 - Welcome Message
        System.out.println("======================================");
        System.out.println(" Welcome to the Palindrome Checker ");
        System.out.println("======================================");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully.");
        System.out.println();

        // UC2 - Hardcoded Palindrome Check
        String input = "madam";   // Hardcoded string
        boolean isPalindrome = true;

        for (int i = 0; i < input.length() / 2; i++) {

            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }

        }

        if (isPalindrome) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is NOT a Palindrome");
        }

    }
}