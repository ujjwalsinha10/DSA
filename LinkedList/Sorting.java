package LinkedList;

public class Sorting {
    public static void main(String[] args) {
        SortingNode head = new SortingNode(1, null);
        head.next = new SortingNode(0, null);
        head.next.next = new SortingNode(2, null);
        head.next.next.next = new SortingNode(1, null);
        head.next.next.next.next = new SortingNode(2, null);

        print(head);

        SortingNode bruteFrceHead = bruteForceApproach(head);
        System.out.println();
        print(bruteFrceHead);

        SortingNode optimizedApproach = optimizedApproach(head);
        System.out.println();
        print(optimizedApproach);
    }

    //  TC: O(N)  SC: O(1)
    private static SortingNode optimizedApproach(SortingNode head) {
        SortingNode temp = head;
        SortingNode zeroHead=new SortingNode(-1,null);
        SortingNode zero=zeroHead;
        SortingNode oneHead=new SortingNode(-1,null);;
        SortingNode one=oneHead;
        SortingNode twoHead=new SortingNode(-1,null);;
        SortingNode two=twoHead;

        while(temp!=null /*&& temp.next!=null*/){
            if(temp.data==0){
                zero.next=temp;
                zero=temp;
            }
            if(temp.data==1){
                one.next=temp;
                one=temp;
            }
            if(temp.data==2){
                two.next=temp;
                two=temp;
            }
            temp=temp.next;
        }

        zero.next=(oneHead.next!=null)?oneHead.next:twoHead.next;
        one.next=twoHead.next;
        return head;
    }

    // TC: O(2N) SC: O(1)
    private static SortingNode bruteForceApproach(SortingNode head) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        SortingNode temp = head;
        while (temp != null) {
            if (temp.data == 0)
                count0++;
            else if (temp.data == 1)
                count1++;
            else if (temp.data == 2)
                count2++;
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            while (count0 > 0) {
                temp.data = 0;
                temp = temp.next;
                count0--;
            }
            while (count1 > 0) {
                temp.data = 1;
                temp = temp.next;
                count1--;
            }
            while (count2 > 0) {
                temp.data = 2;
                temp = temp.next;
                count2--;
            }
        }
        return head;
    }

    private static void print(SortingNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}

class SortingNode {
    int data;
    SortingNode next;

    SortingNode() {

    }

    SortingNode(int data, SortingNode next) {
        this.data = data;
        this.next = next;
    }
}
