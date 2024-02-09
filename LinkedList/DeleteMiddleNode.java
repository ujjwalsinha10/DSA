package LinkedList;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        Node head = new Node(1,null);
        Node second = new Node(2,null);
        Node third = new Node(3,null);
        Node fourth = new Node(4,null);
        Node fifth = new Node(5,null);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // head=bruteforceApproach(head);
        // print(head);

        head=optimizedSolution(head);
        print(head);
    }

    // TC:O(N/2) SC:O(1)
    private static Node optimizedSolution(Node head) {
        Node slow=head;
        Node fast=head;

        fast=head.next.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
    }

    private static void print(Node head) {
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    // TC:O(N+N/2) SC:O(1)
    private static Node bruteforceApproach(Node head) {
        if(head==null || head.next==null) return null;
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }

        temp=head;
        for(int i=1;i<count/2;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }
}
