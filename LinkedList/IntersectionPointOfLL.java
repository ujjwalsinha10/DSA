package LinkedList;

import java.util.HashMap;
import java.util.Map;

/*
 * 1st 3->6->9->15->30
 * 2nd 10->15->30
 * 15 is the intersection point
 */

public class IntersectionPointOfLL {
    public static void main(String[] args) {
        Node head1, head2;

        head1 = new Node(10, null);
        head2 = new Node(3,null);
 
        Node newNode = new Node(6,null);
        head2.next = newNode;
 
        newNode = new Node(9, null);
        head2.next.next = newNode;
 
        newNode = new Node(15, null);
        head1.next = newNode;
        head2.next.next.next = newNode;
 
        newNode = new Node(30,null);
        head1.next.next = newNode;
 
        head1.next.next.next = null;


        print(head1);
        print(head2);

        System.out.println("Intersection Point: "+getIntersectionPoint(head1, head2));
        Node optimizedSolution = optimizedSolution(head1, head2);
        System.out.println("Optimized Solution: "+optimizedSolution.data);
    }

    // TC: O(2*Max(LL))  SC: O(1)
    private static Node optimizedSolution(Node head1, Node head2) {
        Node temp1=head1;
        Node temp2=head2;
        while(temp1!=temp2){
            temp1=temp1.next;
            temp2=temp2.next;

            if(temp1==null){
                temp1=head2;
            }
            if(temp2==null){
                temp2=head1;
            }
            
            if(temp1==temp2)
            return temp1;

        }
        return null;
    }

    // TC: O(M*N) -> M: size of LL1, N-> size of LL2
    // SC: O(M)
    private static int getIntersectionPoint(Node head1, Node head2) {
        Node temp1=head1;
        Node temp2=head2;
        Map<Node, Integer> hashMap=new HashMap<>();
        while(temp1.next!=null){
            hashMap.put(temp1, 1);
            temp1=temp1.next;
        }

        while(temp2.next!=null){
            if(hashMap.containsKey(temp2))
            return temp2.data;

            temp2=temp2.next;
        }
        return -1;
    }

    private static void print(Node temp) {
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}
