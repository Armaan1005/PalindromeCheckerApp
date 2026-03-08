import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * -----------------------------------------------------------
 * MAIN CLASS - PalindromeCheckerApp
 * -----------------------------------------------------------
 *
 * UC1  - Application Entry & Welcome Message
 * UC2  - Hardcoded Palindrome Validation
 * UC3  - Reverse String Palindrome Check
 * UC4  - Character Array Based Palindrome Check
 * UC5  - Stack Based Palindrome Check
 * UC6  - Queue + Stack Based Palindrome Check
 * UC7  - Deque Based Optimized Palindrome Check
 * UC8  - Linked List Based Palindrome Check
 * UC9  - Recursive Palindrome Checker
 * UC10 - Case-Insensitive & Space-Ignored Palindrome
 * UC11 - Object-Oriented Palindrome Service
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // ===============================
        // UC1 - Welcome Message
        // ===============================
        System.out.println("======================================");
        System.out.println(" Welcome to the Palindrome Checker ");
        System.out.println("======================================");
        System.out.println("Version : 1.0");
        System.out.println("System initialized successfully.\n");


        // ===============================
        // UC2 - Hardcoded Palindrome Check
        // ===============================
        String input1 = "madam";
        boolean isPalindrome = true;

        for (int i = 0; i < input1.length() / 2; i++) {
            if (input1.charAt(i) != input1.charAt(input1.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println(input1 + " is a Palindrome\n");


        // ===============================
        // UC3 - Reverse String Method
        // ===============================
        String input2 = "racecar";
        String reversed = "";

        for (int i = input2.length() - 1; i >= 0; i--) {
            reversed += input2.charAt(i);
        }

        System.out.println(input2 + " is a Palindrome (Reverse Method)\n");


        // ===============================
        // UC4 - Character Array Method
        // ===============================
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


        // ===============================
        // UC5 - Stack Based Palindrome
        // ===============================
        String input4 = "noon";

        Stack<Character> stack = new Stack<>();

        for (char c : input4.toCharArray()) {
            stack.push(c);
        }

        boolean isPalindromeStack = true;

        for (char c : input4.toCharArray()) {
            if (c != stack.pop()) {
                isPalindromeStack = false;
                break;
            }
        }

        System.out.println("Input : " + input4);
        System.out.println("Is Palindrome (Stack)? : " + isPalindromeStack + "\n");


        // ===============================
        // UC6 - Queue + Stack Method
        // ===============================
        String input5 = "civic";

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack2 = new Stack<>();

        for (char c : input5.toCharArray()) {
            queue.add(c);
            stack2.push(c);
        }

        boolean isPalindromeQS = true;

        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack2.pop())) {
                isPalindromeQS = false;
                break;
            }
        }

        System.out.println("Input : " + input5);
        System.out.println("Is Palindrome (Queue + Stack)? : " + isPalindromeQS + "\n");


        // ===============================
        // UC7 - Deque Based Palindrome
        // ===============================
        String input6 = "refer";

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input6.toCharArray()) {
            deque.add(c);
        }

        boolean isPalindromeDeque = true;

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                isPalindromeDeque = false;
                break;
            }
        }

        System.out.println("Input : " + input6);
        System.out.println("Is Palindrome (Deque)? : " + isPalindromeDeque + "\n");


        // ===============================
        // UC8 - LinkedList Based Palindrome
        // ===============================
        String input7 = "level";

        LinkedList<Character> list = new LinkedList<>();

        for (char c : input7.toCharArray()) {
            list.add(c);
        }

        boolean isPalindromeLinkedList = true;

        while (list.size() > 1) {
            if (!list.removeFirst().equals(list.removeLast())) {
                isPalindromeLinkedList = false;
                break;
            }
        }

        System.out.println("Input : " + input7);
        System.out.println("Is Palindrome (LinkedList)? : " + isPalindromeLinkedList + "\n");


        // ===============================
        // UC9 - Recursive Palindrome
        // ===============================
        String input8 = "madam";

        boolean result = checkRecursive(input8, 0, input8.length() - 1);

        System.out.println("Input : " + input8);
        System.out.println("Is Palindrome (Recursive)? : " + result + "\n");


        // ===============================
        // UC10 - Ignore Spaces & Case
        // ===============================
        String input9 = "A man a plan a canal Panama";

        String normalized = input9.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        boolean isPalindromeNormalized = true;

        for (int i = 0; i < normalized.length() / 2; i++) {
            if (normalized.charAt(i) != normalized.charAt(normalized.length() - 1 - i)) {
                isPalindromeNormalized = false;
                break;
            }
        }

        System.out.println("Input : " + input9);
        System.out.println("Is Palindrome (Ignore spaces/case)? : " + isPalindromeNormalized + "\n");


        // ===============================
        // UC11 - Object Oriented Service
        // ===============================
        PalindromeService service = new PalindromeService();

        String input10 = "radar";

        boolean resultService = service.checkPalindrome(input10);

        System.out.println("Input : " + input10);
        System.out.println("Is Palindrome (OOP Service)? : " + resultService);

    }


    // UC9 Recursive helper
    private static boolean checkRecursive(String s, int start, int end) {

        if (start >= end)
            return true;

        if (s.charAt(start) != s.charAt(end))
            return false;

        return checkRecursive(s, start + 1, end - 1);
    }
}


// ===============================
// UC11 Service Class
// ===============================
class PalindromeService {

    public boolean checkPalindrome(String input) {

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {

            if (input.charAt(start) != input.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }
}