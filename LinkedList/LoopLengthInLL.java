package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LoopLengthInLL {
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

        System.out.println(bruteforceApproach(head));
        System.out.println(optimizedApproach(head));
    }

    // TC: O(N) SC: O(1)
    private static int optimizedApproach(Node head) {
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                return findLength(slow, fast);
            }
        }
        return 0;
    }

    private static int findLength(Node slow, Node fast) {
        int count=1;
        fast=fast.next;
        while(slow!=fast){
            count++;
            fast=fast.next;
        }
        return count;
    }

    // TC: O(N)  SC: O(N)
    private static int bruteforceApproach(Node head) {
        Node temp= head;
        int count=0;
        Map<Node, Integer> hashMap= new HashMap<>();
        while (temp.next!=null) {
            if(hashMap.containsKey(temp)){
                int loopLength=count-hashMap.get(temp);
                return loopLength;
            }
            hashMap.put(temp, count);
            temp=temp.next;
            count++;
        }
        return -1;
    }
}
