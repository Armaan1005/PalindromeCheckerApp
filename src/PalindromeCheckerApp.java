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
 * UC12 - Strategy Pattern for Palindrome Algorithms
 * UC13 - Performance Comparison
 */

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        // ===============================
        // UC1 - Welcome Message
        // ===============================
        System.out.println("======================================");
        System.out.println(" Welcome to the Palindrome Checker ");
        System.out.println("======================================");
        System.out.println("Version : 1.0\n");


        // ===============================
        // UC2 - Hardcoded Palindrome
        // ===============================
        String input1 = "madam";
        boolean isPalindrome = true;

        for (int i = 0; i < input1.length() / 2; i++) {
            if (input1.charAt(i) != input1.charAt(input1.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("UC2 Result: " + isPalindrome + "\n");


        // ===============================
        // UC3 - Reverse String Method
        // ===============================
        String input2 = "racecar";
        String reversed = "";

        for (int i = input2.length() - 1; i >= 0; i--) {
            reversed += input2.charAt(i);
        }

        System.out.println("UC3 Result: " + input2.equals(reversed) + "\n");


        // ===============================
        // UC4 - Character Array Method
        // ===============================
        String input3 = "radar";

        char[] chars = input3.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        boolean result4 = true;

        while (start < end) {

            if (chars[start] != chars[end]) {
                result4 = false;
                break;
            }

            start++;
            end--;
        }

        System.out.println("UC4 Result: " + result4 + "\n");


        // ===============================
        // UC5 - Stack Based
        // ===============================
        String input4 = "noon";

        Stack<Character> stack = new Stack<>();

        for (char c : input4.toCharArray())
            stack.push(c);

        boolean result5 = true;

        for (char c : input4.toCharArray()) {

            if (c != stack.pop()) {
                result5 = false;
                break;
            }
        }

        System.out.println("UC5 Result: " + result5 + "\n");


        // ===============================
        // UC6 - Queue + Stack
        // ===============================
        String input5 = "civic";

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack2 = new Stack<>();

        for (char c : input5.toCharArray()) {
            queue.add(c);
            stack2.push(c);
        }

        boolean result6 = true;

        while (!queue.isEmpty()) {

            if (!queue.remove().equals(stack2.pop())) {
                result6 = false;
                break;
            }
        }

        System.out.println("UC6 Result: " + result6 + "\n");


        // ===============================
        // UC7 - Deque
        // ===============================
        String input6 = "refer";

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input6.toCharArray())
            deque.add(c);

        boolean result7 = true;

        while (deque.size() > 1) {

            if (deque.removeFirst() != deque.removeLast()) {
                result7 = false;
                break;
            }
        }

        System.out.println("UC7 Result: " + result7 + "\n");


        // ===============================
        // UC8 - LinkedList
        // ===============================
        String input7 = "level";

        LinkedList<Character> list = new LinkedList<>();

        for (char c : input7.toCharArray())
            list.add(c);

        boolean result8 = true;

        while (list.size() > 1) {

            if (!list.removeFirst().equals(list.removeLast())) {
                result8 = false;
                break;
            }
        }

        System.out.println("UC8 Result: " + result8 + "\n");


        // ===============================
        // UC9 - Recursive
        // ===============================
        String input8 = "madam";

        System.out.println("UC9 Result: "
                + recursiveCheck(input8, 0, input8.length() - 1) + "\n");


        // ===============================
        // UC10 - Ignore Spaces / Case
        // ===============================
        String input9 = "A man a plan a canal Panama";

        String normalized =
                input9.replaceAll("[^a-zA-Z0-9]", "")
                        .toLowerCase();

        boolean result10 = true;

        for (int i = 0; i < normalized.length() / 2; i++) {

            if (normalized.charAt(i)
                    != normalized.charAt(normalized.length() - 1 - i)) {

                result10 = false;
                break;
            }
        }

        System.out.println("UC10 Result: " + result10 + "\n");


        // ===============================
        // UC11 - Service Class
        // ===============================
        PalindromeService service = new PalindromeService();

        System.out.println("UC11 Result: "
                + service.checkPalindrome("radar") + "\n");


        // ===============================
        // UC12 - Strategy Pattern
        // ===============================
        PalindromeStrategy strategy = new StackStrategy();

        System.out.println("UC12 Result: "
                + strategy.check("level") + "\n");


        // ===============================
        // UC13 - Performance Comparison
        // ===============================
        String test = "level";

        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy dequeStrategy = new DequeStrategy();

        long startStack = System.nanoTime();
        boolean stackResult = stackStrategy.check(test);
        long endStack = System.nanoTime();

        long startDeque = System.nanoTime();
        boolean dequeResult = dequeStrategy.check(test);
        long endDeque = System.nanoTime();

        System.out.println("UC13 Performance Comparison");
        System.out.println("Stack Result: " + stackResult);
        System.out.println("Stack Time: " + (endStack - startStack) + " ns");

        System.out.println("Deque Result: " + dequeResult);
        System.out.println("Deque Time: " + (endDeque - startDeque) + " ns");

    }


    // Recursive helper method
    private static boolean recursiveCheck(String s, int start, int end) {

        if (start >= end)
            return true;

        if (s.charAt(start) != s.charAt(end))
            return false;

        return recursiveCheck(s, start + 1, end - 1);
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


// ===============================
// UC12 Strategy Interface
// ===============================
interface PalindromeStrategy {

    boolean check(String input);

}


// ===============================
// Stack Strategy
// ===============================
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray())
            stack.push(c);

        for (char c : input.toCharArray()) {

            if (c != stack.pop())
                return false;
        }

        return true;
    }
}


// ===============================
// Deque Strategy
// ===============================
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray())
            deque.add(c);

        while (deque.size() > 1) {

            if (deque.removeFirst() != deque.removeLast())
                return false;
        }

        return true;
    }
}