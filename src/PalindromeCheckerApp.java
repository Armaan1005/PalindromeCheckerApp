public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // UC1 - Welcome Message
        System.out.println("======================================");
        System.out.println(" Welcome to the Palindrome Checker ");
        System.out.println("======================================");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully.\n");


        // UC2 - Hardcoded Palindrome Check
        String input1 = "madam";
        boolean isPalindrome = true;

        for (int i = 0; i < input1.length() / 2; i++) {

            if (input1.charAt(i) != input1.charAt(input1.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(input1 + " is a Palindrome\n");
        } else {
            System.out.println(input1 + " is NOT a Palindrome\n");
        }


        // UC3 - Reverse String Based Palindrome Check
        String input2 = "racecar";
        String reversed = "";

        for (int i = input2.length() - 1; i >= 0; i--) {
            reversed = reversed + input2.charAt(i);
        }

        if (input2.equals(reversed)) {
            System.out.println(input2 + " is a Palindrome (Reverse Method)");
        } else {
            System.out.println(input2 + " is NOT a Palindrome (Reverse Method)");
        }

    }
}