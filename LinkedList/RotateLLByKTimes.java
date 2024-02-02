package LinkedList;

public class RotateLLByKTimes {
    public static void main(String[] args) {
        ListNode head = null;
        head = insertNode(head, 1);
        insertNode(head, 2);
        insertNode(head, 3);
        insertNode(head, 4);
        insertNode(head, 5);

        System.out.println("Orignial Linked List: ");
        print(head);
        int k = 2;
        head= basicApproach(head,k);
        System.out.println("Rotation using Basic Approach: ");
        print(head);
        head = optimizedApproach(head, k);
        System.out.println("Rotation using Optimized Approach: ");
        print(head);
    }

    private static ListNode basicApproach(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        for(int i=0;i<k;i++){
            ListNode temp=head;
            while(temp.next.next!=null){
                temp=temp.next;
            }
            ListNode end= temp.next;
            temp.next=null;
            end.next=head;
            head=end;
        }
        return head;
    }

    private static ListNode insertNode(ListNode head, int data) {
        ListNode newNode = new ListNode(data, null);
        if (head == null) {
            head = newNode;
            return head;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    private static ListNode optimizedApproach(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            ++length;
            temp = temp.next;
        }

        // make the list circular
        temp.next = head;
        k = k % length;
        int end = length - k;
        while (end-- != 0) {
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
    }

    private static void print(ListNode head) {
        ListNode temp = head;
        while (temp.next != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println(temp.val);
    }
}
