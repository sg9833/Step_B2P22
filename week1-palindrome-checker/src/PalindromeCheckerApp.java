import java.util.Scanner;

public class EnhancedPalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- UC10: Palindrome Checker (Advanced) ---");
        System.out.print("Enter text: ");
        String originalInput = scanner.nextLine();

        // 1. Preprocessing / Normalization
        String processedInput = preprocess(originalInput);

        // 2. Validation
        boolean result = isPalindrome(processedInput);

        // 3. Output
        System.out.println("\nOriginal: " + originalInput);
        System.out.println("Processed: " + processedInput);
        System.out.println("Is Palindrome: " + result);

        scanner.close();
    }

    /**
     * Normalizes the string using Regular Expressions (Regex).
     * UC10 Key Concept: String Preprocessing
     */
    private static String preprocess(String input) {
        if (input == null) return "";

        // [^a-zA-Z0-9] means "anything that is NOT a letter or a number"
        // .replaceAll replaces those matches with an empty string (removes them)
        // .toLowerCase() ensures 'A' == 'a'
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    /**
     * Standard Two-Pointer approach to validate the cleaned string.
     */
    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}