import java.util.Scanner;

public class RecursivePalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();
        
        // Clean the string: remove non-alphanumeric and convert to lowercase
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        if (isPalindrome(cleanedInput, 0, cleanedInput.length() - 1)) {
            System.out.println("Result: '" + input + "' is a palindrome.");
        } else {
            System.out.println("Result: '" + input + "' is NOT a palindrome.");
        }
        
        scanner.close();
    }

    /**
     * Recursive method to check if a string is a palindrome.
     * @param str The string to check
     * @param start The current starting index
     * @param end The current ending index
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String str, int start, int end) {
        // --- Base Conditions ---
        
        // If pointers cross or meet, all characters matched
        if (start >= end) {
            return true;
        }

        // If characters at current positions don't match, it's not a palindrome
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // --- Recursive Step ---
        // Move inward: increment start and decrement end
        return isPalindrome(str, start + 1, end - 1);
    }
}