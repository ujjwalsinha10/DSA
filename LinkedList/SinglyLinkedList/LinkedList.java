package LinkedList.SinglyLinkedList;

public class LinkedList {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 ,5,6,7,8};
        Node node1 = new Node(arr[2], null);
        System.out.println(node1.data);

        Node head = convertArray2LL(arr);
        System.out.println(head.data);

        traverseLL(head);
        System.out.println("\nLength of LinkedList: "+lengthOfLL(head));

        System.out.println("Element if present: "+checkIfPresent(head, 2));

        Node newHead = removesHead(head);
        System.out.println("After removal of Head:");
        traverseLL(newHead);

        removeTail(head);
        System.out.println("\nAfter removal of Tail:");
        traverseLL(head);

        removeKthElement(head, 2);
        System.out.println("\nAfter reomval of Kth Element:");
        traverseLL(head);

        removeKthValueElement(head, 5);
        System.out.println("\nAfter reomval of the specific value element");
        traverseLL(head);

    }

    private static Node convertArray2LL(int[] arr) {
        Node head = new Node(arr[0], null);
        Node mover = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    private static void traverseLL(Node head){
        Node temp =head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    private static int lengthOfLL(Node head){
        int count=0;
        Node temp=head;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }

    private static boolean checkIfPresent(Node head, int value){
        Node temp= head;
        while(temp!=null){
            if(temp.data==value){
                return true;
            }else{
                temp=temp.next;
            }
        }
        return false;
    }

    private static Node removesHead(Node head){
        // check if the LL is Empty
        if(head==null) return head;

        head=head.next;
        return head;
    }

    private static Node removeTail(Node head){
        if(head==null || head.next==null) return null;
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next; 
        }
        temp.next=null;
        return head;
    }

    private static Node removeKthElement(Node head, int k){
        if(head==null) return head;
        if(k==1){
            return head;
        }

        Node temp=head;
        Node prev=null;
        int count=0;
        while(temp!=null){
            count++;

            if(count==k){
                prev.next=prev.next.next;
                temp=null;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }

    public static Node removeKthValueElement(Node head, int k){
        if(head==null) return head;
        if(head.data==k){
            return head;
        }
        Node temp=head;
        Node prev= null;
        while(temp.next!=null){
            if(temp.data==k){
                prev.next=prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
     }
}