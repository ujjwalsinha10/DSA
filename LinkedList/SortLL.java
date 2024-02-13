package LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortLL {
    public static void main(String[] args) {
        SortingNode head = new SortingNode(1, null);
        head.next = new SortingNode(0, null);
        head.next.next = new SortingNode(4, null);
        head.next.next.next = new SortingNode(3, null);
        head.next.next.next.next = new SortingNode(5, null);

        head=bruteForceApproach(head);
        print(head);
    }

    private static void print(SortingNode head) {
        SortingNode temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    // TC: O(N+ NlogN+N)  SC:O(N)
    private static SortingNode bruteForceApproach(SortingNode head) {
        SortingNode temp=head;
        List<Integer> list= new ArrayList<>();
        while(temp!=null){
            list.add(temp.data);
            temp=temp.next;
        }

        Collections.sort(list);
        int i=0;
        temp=head;
        while(temp!=null && i<list.size()){
            temp.data=list.get(i);
            i+=1;
            temp=temp.next;
        }

        return head;
    }
    
}
