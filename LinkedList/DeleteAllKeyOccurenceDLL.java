package LinkedList;

public class DeleteAllKeyOccurenceDLL {
    public static void main(String[] args) {
        DLLNode head=addNode(1);
        addNode(2);
        addNode(3);
        addNode(1);
        addNode(1);
        print(head);

        int key=1;
        head=removeOccurrenceOfKey(head, key);
        print(head);
    }

    // TC: O(N)  SC: O(1)
    private static DLLNode removeOccurrenceOfKey(DLLNode head, int key) {
        if(head==null) return null;

        DLLNode current=head;
        DLLNode next=null;
        while(current!=null){
            // if node is found with the key
            if(current.data==key){
                //store the next value
                next=current.next;
                // delete the node
                head=deleteNode(head, current);
                // update the current
                current=next;
            }
            else{
                // simply traverse to the next node
                current=current.next;
            }
        }
        return head;
    }

    private static DLLNode deleteNode(DLLNode head2, DLLNode current) {
        if(head2==null || current==null) return null;

        // if head has the key, then delete the head and point it to next
        if(head2==current) {
            head2=current.next;
            return head2;
        }
        if(current.next!=null){
            current.next.prev=current.prev;
        }
        if(current.prev!=null){
            current.prev.next=current.next;
        }
        current=null;
        return head2;
    }

    private static void print(DLLNode head) {
        DLLNode temp= head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    static DLLNode headNode= null;
    static DLLNode tail=null; 
    private static DLLNode addNode(int data) {
        DLLNode newNode= new DLLNode(data, null,null);
        if(headNode==null){
            headNode=tail=newNode;
        } else{
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
            tail.next=null;
        }
        return headNode;
    }
}
class DLLNode{
    int data;
    DLLNode prev;
    DLLNode next;

    DLLNode(){

    }
    DLLNode(int data, DLLNode next, DLLNode prev){
        this.data=data;
        this.next=next;
        this.prev=prev;
    }
}
