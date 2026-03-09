import java.util.Stack;
import java.util.Scanner;

/**
 * UC11: PalindromeService Class
 * Encapsulates the logic and internal data structures.
 */
class PalindromeService {

    /**
     * The core logic method using a Stack data structure.
     * This demonstrates Encapsulation—the user doesn't need to 
     * know a Stack is being used internally.
     */
    public boolean checkPalindrome(String input) {
        if (input == null) return false;

        // Preprocessing (Reusing UC10 concepts)
        String cleanStr = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Internal Data Structure: Stack
        Stack<Character> stack = new Stack<>();

        // Push all characters onto the stack
        for (char c : cleanStr.toCharArray()) {
            stack.push(c);
        }

        // Pop and compare
        for (char c : cleanStr.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

/**
 * Main Application Class
 */
public class PalindromeApp {
    public static void main(String[] args) {
        // Instantiate the service (Object Orientation)
        PalindromeService service = new PalindromeService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== OO Palindrome Checker App ===");
        System.out.print("Enter text to validate: ");
        String userInput = scanner.nextLine();

        // Using the service
        boolean isPalindrome = service.checkPalindrome(userInput);

        if (isPalindrome) {
            System.out.println("Status: VALID Palindrome");
        } else {
            System.out.println("Status: INVALID Palindrome");
        }

        scanner.close();
    }
}