package LinkedList;

public class ReverseLLInGrp {
    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(2);

        print(head);
        head=kThReverse(head, 4);
        print(head);

    }

    // TC: O(2N) SC: O(1) 
    private static ListNode kThReverse(ListNode head, int k) {
        // Initialize a temporary
        // node to traverse the list
        ListNode temp = head;
        // Initialize a pointer to track the
        // last node of the previous group
        ListNode prevlast = null;
        // Traverse through the linked list
        while (temp != null) {
            // Get the Kth node of the current group
            ListNode kthNode = getKthNode(temp, k);
            // If the Kth node is NULL
            // (not a complete group)
            if (kthNode == null) {
                // If there was a previous group,
                // link the last node to the current node
                if (prevlast != null) {
                    prevlast.next = temp;
                }
                // Exit the loop
                break;
            }

            // Store the next node
            // after the Kth node
            ListNode nextNode=kthNode.next;
            // Disconnect the Kth node
            // to prepare for reversal
            kthNode.next=null;

            // Reverse the nodes from
            // temp to the Kth node
            reverseLinkedList(temp);

            // Adjust the head if the reversal
            // starts from the head
            if(temp==head){
                head=kthNode;
            }else{
                // Link the last node of the previous
                // group to the reversed group
                prevlast.next=kthNode;
            }
            // Update the pointer to the
            // last node of the previous group
            prevlast=temp;
            // Move to the next group
            temp=nextNode;
        }
        return head;
    }

    private static ListNode reverseLinkedList(ListNode head) {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }

    private static ListNode getKthNode(ListNode temp, int k) {
        // Decrement K as we already
        // start from the 1st node
        k-=1;
         // Decrement K until it reaches
        // the desired position
        while(temp!=null && k>0){
            // Decrement k as temp progresses
            k--;
            // Move to the next node
            temp=temp.next;
        }
        return temp;
    }

    private static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
