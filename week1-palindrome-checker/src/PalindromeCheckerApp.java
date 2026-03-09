import java.util.*;

// 1. The Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String text);
}

// 2. Stack Strategy: Reverses the string using a Stack
// 
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char c : clean.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return clean.equals(reversed.toString());
    }
}

// 3. Deque Strategy: Compares front and back simultaneously
// 
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String text) {
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : clean.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}

// 4. The Context Class: Manages the current strategy
class PalindromeChecker {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String text) {
        if (strategy == null) {
            System.out.println("Error: No algorithm selected.");
            return false;
        }
        return strategy.isPalindrome(text);
    }
}

// 5. Main Application Class
public class PalindromeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println("--- Palindrome Checker (UC12) ---");
        System.out.print("Enter text to check: ");
        String input = scanner.nextLine();

        // Demonstrate Stack Strategy
        System.out.println("\nUsing Stack Strategy...");
        checker.setStrategy(new StackStrategy());
        displayResult(input, checker.validate(input));

        // Demonstrate Deque Strategy (Runtime Swap)
        System.out.println("Switching to Deque Strategy...");
        checker.setStrategy(new DequeStrategy());
        displayResult(input, checker.validate(input));

        scanner.close();
    }

    private static void displayResult(String text, boolean isPalindrome) {
        String status = isPalindrome ? "is a palindrome." : "is NOT a palindrome.";
        System.out.println("Result: '" + text + "' " + status + "\n");
    }
}