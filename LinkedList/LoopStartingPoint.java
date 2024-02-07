package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LoopStartingPoint {
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
        // Create a loop
        fifth.next = third;

        // head=bruteforceApproach(head);
        // System.out.println(head.data);

        head=optimizedApproach(head);
        System.out.println(head.data);
    }

    //  TC: O(N) SC: O(1)
    private static Node optimizedApproach(Node head) {
        if(head==null || head.next==null) return null;
        Node fast=head;
        Node slow=head;
        // detect a cycle
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                // if cycle detected, place slow to head & move both by 1
                slow=head;
                while(fast!=null){
                    slow=slow.next;
                    fast=fast.next;
                    if(slow==fast){
                        return slow;
                    }
                }
            }
        }
        return null;
    }

    // TC:O(N)  SC:O(N)
    private static Node bruteforceApproach(Node head) {
        if(head==null || head.next==null) return null;
        Node temp=head;
        Map<Node, Integer> hashMap= new HashMap<>();
        while(temp!=null){
            if(hashMap.containsKey(temp)){
                return temp;
            }
            hashMap.put(temp, 1);
            temp=temp.next;
        }
        return null;
    }
}
