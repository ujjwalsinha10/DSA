package LinkedList;

public class MiddleOfLL {
    public static void main(String[] args) {
        Node head = new Node(1, null);
        head.next = new Node(2, null);
        head.next.next = new Node(3, null);
        head.next.next.next = new Node(4, null);
        head.next.next.next.next = new Node(5, null);

        print(head);

        Node bruteNode = bruteforceApproach(head);
        System.out.println(bruteNode.data);

        Node optiApp=optimizedTortoiseHare(head);
        System.out.println(optiApp.data);
    }

    // TC: O(N/2)  SC: O(1)
    private static Node optimizedTortoiseHare(Node head) {
        // start 2 pointers slow & fast pointing to head
        Node slow=head;
        Node fast=head;
        // for even length: fast will be in last node,
        // for odd length: fast will be in scond last node, so checks are added
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        // once fast reaches to last node or null, slow will point to the middle
        return slow;
    }

    // TC: O(N+N/2) SC: O(1)
    private static Node bruteforceApproach(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        int n = (count / 2) + 1;
        temp = head;
        while (temp!=null) {
            n--;
            if(n==0) break;
            temp = temp.next;
        }
        return temp;
    }


    private static void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
