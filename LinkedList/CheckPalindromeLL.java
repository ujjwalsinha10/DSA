package LinkedList;

import java.util.Stack;

public class CheckPalindromeLL {
    public static void main(String[] args) {
        Node head = new Node(1, null);
        head.next = new Node(2, null);
        head.next.next = new Node(3, null);
        head.next.next.next = new Node(2, null);
        head.next.next.next.next = new Node(1, null);

        System.out.println(usingStackApproach(head));
        System.out.println(optimalApproach(head));
    }

    // TC: O(2N) SC: O(1)
    private static boolean optimalApproach(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        // Initialize two pointers, slow and fast,
        // to find the middle of the linked list
        Node slow = head;
        Node fast = head;

        // Traverse the linked list to find the
        // middle using slow and fast pointers
        while (fast.next != null && fast.next.next != null) {
            // Move slow pointer one step at a time
            slow = slow.next;
            // Move fast pointer two steps at a time
            fast = fast.next.next;
        }
        // Reverse the second half of the 
        // linked list starting from the middle
        Node newHead = reverseLinkedList(slow.next);
        // Pointer to the first half
        Node first = head;
        // Pointer to the reversed second half
        Node second = newHead;
        while (second != null) {
            // Compare data values of
            // nodes from both halves
    
            // If values do not match, the
            // list is not a palindrome
            if(first.data!=second.data){
                reverseLinkedList(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverseLinkedList(newHead);
        return true;
    }

    private static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverseLinkedList(head.next);
        Node front = head.next;
        // Update the 'next' pointer of 'front' to
        // point to the current head, effectively
        // reversing the link direction
        front.next = head;
        // Set the 'next' pointer of the
        // current head to 'null' to
        // break the original link
        head.next = null;
        return newHead;
    }

    // TC: O(2N) SC: O(N)
    private static boolean usingStackApproach(Node head) {
        Node temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            if (stack.peek() != temp.data) {
                return false;
            }
            stack.pop();
            temp = temp.next;
        }
        return false;
    }

}
