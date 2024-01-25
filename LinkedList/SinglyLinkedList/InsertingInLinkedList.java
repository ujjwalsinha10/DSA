package LinkedList.SinglyLinkedList;

public class InsertingInLinkedList {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5,6,7};
        Node headFormed = convert2LL(arr);
        traverseLL(headFormed);

        Node insertedHead = insertAtHead(headFormed, 8);
        System.out.println("\nAfter inserting node at Head: ");
        traverseLL(insertedHead);

        insertAtLast(headFormed, 8);
        System.out.println("\nAfter inserting node at Last: ");
        traverseLL(headFormed);

        insertAtKthPosition(headFormed, 10, 3);
        System.out.println("\nAfter inserting node at Kth position: ");
        traverseLL(headFormed);

        insertBeforeValueK(headFormed, 11, 5);
        System.out.println("\nAfter inserting node at Kth position: ");
        traverseLL(headFormed);

    }
    public static Node convert2LL(int [] arr){
        Node head= new Node(arr[0], null);
        Node mover=head;
        for(int i=1;i<arr.length;i++){
            Node temp=new Node(arr[i], null);
            mover.next=temp;
            mover=temp;
        }
        return head;
    }
    public static Node traverseLL(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        return head;
    }
    public static Node insertAtHead(Node head, int val){
        Node insertingNode= new Node(val, null);
        if(head==null) return insertingNode;
        insertingNode.next=head;
        return insertingNode;
    }
    public static Node insertAtLast(Node head, int val){
        Node nodeToBeInserted= new Node(val,null);
        if(head==null) return nodeToBeInserted;
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=nodeToBeInserted;
        return head;
    }

    public static Node insertAtKthPosition(Node head,int val, int k){
        if(head==null) {
            if(k==1)return new Node(val, null);
            else return head;
        }
        
        if(k==1) return new Node(val, head);
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            if(count==k-1){
                Node newlyFormed=new Node(val,temp.next);
                temp.next=newlyFormed;
                break;
            }
            temp=temp.next;
        }
        return head;
    }

    public static Node insertBeforeValueK(Node head, int val, int k){
        if(head==null) {
            return new Node(k, null);
        }
        if(head.data==k) return new Node(val, head);
        Node temp=head;
        while(temp!=null){
            if(temp.next.data==k){
                Node newlyFormed= new Node(val,temp.next);
                temp.next=newlyFormed;
                break;
            }
            temp=temp.next;
        }
        return head;
    }
}
