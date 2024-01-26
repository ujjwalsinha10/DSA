package LinkedList.DoublyLinkedList;

public class InsertingInDoublyLinkedList {
    public static void main(String[] args) {
        int[] arr = { 12, 5, 8, 7 };

        Node head = convert2DLL(arr);
        traverse(head);

        Node insertedNode=insertBeforeHead(head, 10);
        System.out.println("\nInserting before Head: ");
        traverse(insertedNode);

        insertedNode=insertBeforeTail(insertedNode, 9);
        System.out.println("\nInserting before Tail: ");
        traverse(insertedNode);

        Node insertedKNode=insertBeforeKthNode(insertedNode, 100, 3);
        System.out.println("\nInserting before Kth Node: ");
        traverse(insertedKNode);

        Node insertedKthVal=insertBeforeKthValue(insertedNode, 99, 5);
        System.out.println("\nInserting before Kth Value: ");
        traverse(insertedKthVal);

        Node insertedAfterKthNode=insertAfterKthNode(insertedNode, 101, 6);
        System.out.println("\nInserting after Kth Node: ");
        traverse(insertedAfterKthNode);

        insertBeforeGivenNode(insertedAfterKthNode.next.next.next,69);
        System.out.println("\nInserting before Given Node: ");
        traverse(insertedAfterKthNode);

    }

    private static Node convert2DLL(int[] arr) {
        Node head = new Node(arr[0], null, null);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    private static void traverse(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
    }

    private static Node insertBeforeHead(Node head, int val) {
        if(head==null) return null;
        Node insertedNode=new Node(val, head, null);
        head.back=insertedNode;
        return insertedNode;
    }

    private static Node insertBeforeTail(Node head, int val){
        if(head.next==null) return insertBeforeHead(head, val);
        Node tail=head;
        while(tail.next!=null){
           tail=tail.next; 
        }
        Node prev=tail.back;
        Node newlyFormed= new Node(val, tail, prev);
        prev.next=newlyFormed;
        tail.back=newlyFormed;
        return head;
    }

    private static Node insertBeforeKthNode(Node head, int val, int k){
        if(k==1) return insertBeforeHead(head, val);
        Node temp=head;
        int count=0;
        while(temp.next!=null){
            count++;
            if(count==k){
                break;
            }
            temp=temp.next;
        }
        Node prev=temp.back;
        Node newlyFormed=new Node(val, temp, prev);
        prev.next=newlyFormed;
        temp.back=newlyFormed;
        return head;
    }

    private static Node insertBeforeKthValue(Node head, int val, int k){
        if(k==1) return insertBeforeHead(head, val);

        Node temp=head;
        while(temp.next!=null){
            if(temp.data==k){
                break;
            }
            temp=temp.next;
        }
        Node prev=temp.back;
        Node newlyFormed= new Node(val,temp,prev);
        prev.next=newlyFormed;
        temp.back=newlyFormed;
        
        return head;
    }

    private static Node insertAfterKthNode(Node head, int val, int k){
        Node temp=head;
        int count=0;
        while(temp.next!=null){
            count++;
            if(count==k+1){
                break;
            }
            temp=temp.next;
        }
        Node prev=temp.back;
        Node newlyFormed= new Node(val, temp, prev);
        prev.next=newlyFormed;
        temp.back=newlyFormed;
        return head;
    }

    // 1 <-> 2 <-> |6 |<-> 3 <-> 4
    private static void insertBeforeGivenNode(Node node, int val){
        Node prev= node.back;
        Node newlyFormed=new Node(val,node,prev);
        prev.next=newlyFormed;
        node.back=newlyFormed;
    }
}
