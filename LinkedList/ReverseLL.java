package LinkedList;

/**
 * ReverseLL
 */
public class ReverseLL {

    public static void main(String[] args) {
        Node head = new Node(1, null);
        head.next = new Node(2, null);
        head.next.next = new Node(3, null);
        head.next.next.next = new Node(4, null);
        head.next.next.next.next = new Node(5, null);

        print(head);

        // Node bruteHead = normalApproach(head);
        // print(bruteHead);

        Node recurHead = recursiveApproach(head);
        print(recurHead);
    }

    // TC: O(N) SC:O(N) -> uses N stack space for recursion
    private static Node recursiveApproach(Node head) {
        if(head==null || head.next==null) {
            return head;
        }
        Node newHead=recursiveApproach(head.next);
        Node front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }

    private static void print(Node temp) {
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // TC: O(N) SC:O(1)
    private static Node normalApproach(Node head) {
        Node temp = head;
        Node prev = null;
        Node front = null;
        while (temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}