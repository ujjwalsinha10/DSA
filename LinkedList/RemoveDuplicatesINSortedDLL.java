package LinkedList;

public class RemoveDuplicatesINSortedDLL {
    public static void main(String[] args) {
        DLLNode head = addNode(1);
        addNode(1);
        addNode(1);
        addNode(2);
        addNode(3);
        addNode(3);
        addNode(4);

        print(head);
        head=removeDuplicate(head);
        print(head);
    }

    // TC: O(N) SC: O(1)
    private static DLLNode removeDuplicate(DLLNode head) {
        DLLNode temp=head;
        while(temp!=null && temp.next!=null){
            DLLNode nextNode= temp.next;
            while(nextNode!=null && nextNode.data==temp.data){
                nextNode=nextNode.next;
            }
            temp.next=nextNode;
            if(nextNode!=null){
                nextNode.prev=temp;
            }
            temp=temp.next;
        }
        return head;
    }

    private static void print(DLLNode head) {
        DLLNode temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    static DLLNode headNode = null;
    static DLLNode tailNode = null;

    private static DLLNode addNode(int data) {
        DLLNode newNode = new DLLNode(data, null, null);
        if (headNode == null) {
            headNode = tailNode = newNode;
            tailNode.next = null;
        } else {
            tailNode.next = newNode;
            newNode.prev = tailNode;
            tailNode = newNode;
            tailNode.next = null;

        }
        return headNode;
    }
}
