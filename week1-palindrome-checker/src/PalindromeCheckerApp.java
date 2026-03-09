class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeChecker {

    // Main method to test the logic
    public static void main(String[] args) {
        String input = "radar";
        boolean isPal = isPalindrome(input);
        System.out.println("Is '" + input + "' a palindrome? " + isPal);
    }

    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) return true;

        // 1. Convert string to Singly Linked List
        Node head = createLinkedList(str);

        // 2. Find the middle using Fast and Slow pointers
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 3. Reverse the second half of the list
        Node secondHalfHead = reverseList(slow);
        Node firstHalfHead = head;

        // 4. Compare both halves
        Node tempSecond = secondHalfHead;
        while (tempSecond != null) {
            if (firstHalfHead.data != tempSecond.data) {
                return false;
            }
            firstHalfHead = firstHalfHead.next;
            tempSecond = tempSecond.next;
        }

        return true;
    }

    // Helper: Create list from String
    private static Node createLinkedList(String s) {
        Node dummy = new Node(' ');
        Node current = dummy;
        for (char c : s.toCharArray()) {
            current.next = new Node(c);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper: In-place Reversal
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}