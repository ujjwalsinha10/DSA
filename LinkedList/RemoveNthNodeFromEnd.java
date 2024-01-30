package LinkedList;

public class RemoveNthNodeFromEnd {
    public static void main(String[] args) {
        Node head=new Node(1, null);
        head.next=new Node(2,null);
        head.next.next= new Node(3,null);
        head.next.next.next= new Node(4,null);
        head.next.next.next.next= new Node(5,null);

        print(head);

        Node bruteNode=bruteForceApproach(head,3);
        System.out.println("\nBruteForce: After removing Nth Node from end: ");
        print(bruteNode);

        // TWO POINTER APPROACH
        Node optiNode=optimalApproach(head,3);
        System.out.println("\nOptimized: After removing Nth Node from end: ");
        print(optiNode);

    }

    // TC: O(len)  SC: O(1)
    private static Node optimalApproach(Node head, int n) {
        Node fast=head;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        if(fast==null){
            return head.next;
        }
        Node slow=head;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        Node delNode=slow.next;
        slow.next=delNode.next;
        delNode=null;
        return head;
    }

    private static void print(Node head) {
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }

    // TC: O(len)+O(len-n) -> len is size of LLn n is position
    // SC: 0(1)
    private static Node bruteForceApproach(Node head, int n) {
        Node temp=head;
        int count=0;
        // Count the number of nodes in the linked list
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        // If N equals the total number of nodes, delete the head
        if(count==n){
            Node newHead= head.next;
            head=null;
            return newHead;
        }

        // Calculate the position of the node to delete (res)
        int result= count-n;
        temp=head;

        // Traverse to the node just before the one to delete
        while(temp!=null){
            result--;
            if(result==0){
                break;
            }
            temp=temp.next;
        }
        // Delete the Nth node from the end
        temp.next=temp.next.next;
        return head;
    }
}
