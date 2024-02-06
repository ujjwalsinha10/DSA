package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class DetectLoopInLL {
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

        System.out.println(bruteforceApproach(head)!=null?"Loop is present":"No Loop");
        System.out.println(optimizedByTortoiseHare(head)!=false?"Loop is present":"No Loop");
    }

    // TC: O(N)  SC: O(1)
    private static boolean optimizedByTortoiseHare(Node head) {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    // TC:O(N * 2 * log(N))   SC:O(N)
    private static Node bruteforceApproach(Node head) {
        Node temp=head;
        Map<Node, Integer> hashMap= new HashMap<>();
        while (temp!=null) {
            if(hashMap.containsKey(temp)){
                return temp;
            }
            hashMap.put(temp,1);
            temp=temp.next;
        }
        return temp;
    }
}
