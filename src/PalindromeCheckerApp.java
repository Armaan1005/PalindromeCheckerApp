import java.util.Stack;

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


        // UC3 - Reverse String Method
        String input2 = "racecar";
        String reversed = "";

        for (int i = input2.length() - 1; i >= 0; i--) {
            reversed = reversed + input2.charAt(i);
        }

        if (input2.equals(reversed)) {
            System.out.println(input2 + " is a Palindrome (Reverse Method)\n");
        } else {
            System.out.println(input2 + " is NOT a Palindrome (Reverse Method)\n");
        }


        // UC4 - Character Array Method
        String input3 = "radar";

        char[] chars = input3.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        boolean isPalindromeArray = true;

        while (start < end) {

            if (chars[start] != chars[end]) {
                isPalindromeArray = false;
                break;
            }

            start++;
            end--;
        }

        System.out.println("Input : " + input3);
        System.out.println("Is Palindrome? : " + isPalindromeArray + "\n");


        // UC5 - Stack Based Palindrome Check
        String input4 = "noon";

        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (char c : input4.toCharArray()) {
            stack.push(c);
        }

        boolean isPalindromeStack = true;

        // Pop and compare
        for (char c : input4.toCharArray()) {

            if (c != stack.pop()) {
                isPalindromeStack = false;
                break;
            }
        }

        System.out.println("Input : " + input4);
        System.out.println("Is Palindrome (Stack)? : " + isPalindromeStack);

    }
}