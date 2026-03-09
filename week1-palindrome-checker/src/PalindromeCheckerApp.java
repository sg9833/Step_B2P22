import java.util.*;

// 1. The Strategy Interface
interface PalindromeStrategy {
    String getName();
    boolean isPalindrome(String text);
}

// 2. Stack Strategy: High overhead due to object creation
class StackStrategy implements PalindromeStrategy {
    public String getName() { return "Stack Strategy"; }
    @Override
    public boolean isPalindrome(String text) {
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char c : clean.toCharArray()) stack.push(c);
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());
        return clean.equals(reversed.toString());
    }
}

// 3. Deque Strategy: Double-ended comparison
class DequeStrategy implements PalindromeStrategy {
    public String getName() { return "Deque Strategy"; }
    @Override
    public boolean isPalindrome(String text) {
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : clean.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        }
        return true;
    }
}

// 4. Two-Pointer Strategy: The fastest (No extra data structures)
// 
class TwoPointerStrategy implements PalindromeStrategy {
    public String getName() { return "Two-Pointer (Optimal)"; }
    @Override
    public boolean isPalindrome(String text) {
        String clean = text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = clean.length() - 1;
        while (left < right) {
            if (clean.charAt(left++) != clean.charAt(right--)) return false;
        }
        return true;
    }
}

// 5. Main Performance App
public class PalindromePerformanceApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Setup strategies to compare
        List<PalindromeStrategy> strategies = Arrays.asList(
            new StackStrategy(),
            new DequeStrategy(),
            new TwoPointerStrategy()
        );

        System.out.println("=== UC13: Palindrome Performance Comparison ===");
        System.out.print("Enter a string to test: ");
        String input = scanner.nextLine();

        System.out.println("\nRunning tests...\n");
        System.out.printf("%-25s | %-12s | %-15s%n", "Algorithm", "Result", "Time (nanos)");
        System.out.println("------------------------------------------------------------------");

        for (PalindromeStrategy strategy : strategies) {
            // Capture Start Time
            long startTime = System.nanoTime();
            
            // Execute Algorithm
            boolean result = strategy.isPalindrome(input);
            
            // Capture End Time
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.printf("%-25s | %-12s | %-15d ns%n", 
                strategy.getName(), 
                (result ? "Palindrome" : "Not Palindrome"), 
                duration);
        }

        System.out.println("\nNote: Results may vary based on CPU load and JVM warm-up.");
        scanner.close();
    }
}