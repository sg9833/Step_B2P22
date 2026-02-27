/**
 * Palindrome Checker Application
 * UC1: Application Entry & Welcome Message
 * This class demonstrates the entry point of a Java application
 * with welcome message and application details display
 */
public class PalindromeCheckerApp {

    // Application constants
    private static final String APP_NAME = "Palindrome Checker App";
    private static final String APP_VERSION = "1.0.0";
    private static final String SEPARATOR = "=====================================";

    /**
     * Main method - Entry point of the application
     * @param args Command line arguments (not used in this use case)
     */
    public static void main(String[] args) {
        // Display welcome message and application details
        displayWelcomeMessage();

        // Display application information
        displayApplicationInfo();

        // Indicate program continuation
        System.out.println("\nProgram initialized successfully!");
        System.out.println("Ready for palindrome checking...\n");
        System.out.println(SEPARATOR);
    }

    /**
     * Displays the welcome message to the user
     */
    private static void displayWelcomeMessage() {
        System.out.println(SEPARATOR);
        System.out.println("       WELCOME TO");
        System.out.println("   " + APP_NAME.toUpperCase());
        System.out.println(SEPARATOR);
    }

    /**
     * Displays application name and version information
     */
    private static void displayApplicationInfo() {
        System.out.println("\nApplication Details:");
        System.out.println("-------------------");
        System.out.println("Application Name: " + APP_NAME);
        System.out.println("Application Version: " + APP_VERSION);
        System.out.println("-------------------");
    }
}
