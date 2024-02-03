package LinkedList;

public class AddOneInLL {
    public static void main(String[] args) {
        Node head = new Node(9, null);
        head.next = new Node(9, null);
        head.next.next = new Node(9, null);

        Node ret=optimizeUsingRecursion(head);
        print(ret);
    }

    private static void print(Node ret) {
        while(ret!=null){
            System.out.print(ret.data+" ");
            ret=ret.next;
        }
    }

    // TC:O()  SC:O(N), as it is getting stored in recursive stack space
    private static Node optimizeUsingRecursion(Node head) {
        int carry= helper(head);
        if(carry==1){
            // creating new Node as carry is 1, points next as head
            Node newNode= new Node(1,head);
            return newNode;
        }
        else{
            return head;
        }
    }

    private static int helper(Node temp) {
        if(temp==null){
            return 1;
        }
        // normally traversing through recursion
        int carry=helper(temp.next);
        // adding carry
        temp.data=temp.data+carry;

        // returns 0 as carry will be 0, number is <10
        if(temp.data<10){
            return 0;
        }else{
            // make the data as 0, return carry as 1
            temp.data=0;
            return 1;
        }
    }
}
