package LinkedList;

import java.util.ArrayList;
import java.util.List;

/*
 * Given: 2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7.
 * Output: 2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4
 */
public class OddEvenLL {
    public static void main(String[] args) {
        int arr[]={2,1,3,5,6,4,7};
        Node head=convert2LL(arr);
        print(head);

        bruteForceApproach(head);
        System.out.println("\nBy BruteForce Solution: ");
        print(head);

        head=optimalSolution(head);
        System.out.println("\nBy Optiized Solution: ");
        print(head);
    }

    // TC:O(N)  SC: O(1)
    private static Node optimalSolution(Node head) {
        Node oddHead=head;
        Node evenHead=head.next;
        Node even=evenHead;

        while(evenHead!=null && evenHead.next!=null){
            oddHead.next=oddHead.next.next;
            evenHead.next=evenHead.next.next;
            oddHead=oddHead.next;
            evenHead=evenHead.next;
        }
        oddHead.next=even;
        return head;
    }

    // TC:O(2N)  SC: O(N)
    private static void bruteForceApproach(Node head) {
        List<Integer> arrList= new ArrayList<>();
        Node temp=head;
        while(temp!=null && temp.next!=null){
            arrList.add(temp.data);
            temp=temp.next.next;
        }
        if(temp!=null){
            arrList.add(temp.data);
        }

        temp=head.next;
        while(temp!=null && temp.next!=null){
            arrList.add(temp.data);
            temp=temp.next.next;
        }
        if(temp!=null){
            arrList.add(temp.data);
        }
        replace(head, arrList);
    }

    private static void replace(Node head, List<Integer> arrList) {
        Node temp=head;
        int i=0;
        while(temp!=null){
            temp.data=arrList.get(i);
            temp=temp.next;
            i++;
        }
    }

    private static void print(Node head) {
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }

    private static Node convert2LL(int[] arr) {
        Node head= new Node(arr[0],null);
        Node mover=head;
        for(int i=1;i<arr.length;i++){
            Node temp=new Node(arr[i],null);
            mover.next=temp;
            mover=temp;
        }
        return head;
    }
    
}
class Node{
    int data;
    Node next;
    Node(){

    }
    Node(Integer data, Node next){
        this.data=data;
        this.next=next;
    }
}
