import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    static boolean isPalindrome(String str) {
        Deque<Character> deque = new ArrayDeque<>();

        // Insert all characters into the deque
        for (int i = 0; i < str.length(); i++) {
            deque.addLast(str.charAt(i));
        }

        // Compare front and rear elements
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String word = "madam";

        if (isPalindrome(word)) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is not a Palindrome");
        }
    }
}