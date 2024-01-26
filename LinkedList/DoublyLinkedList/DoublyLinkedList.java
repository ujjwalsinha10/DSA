package LinkedList.DoublyLinkedList;

public class DoublyLinkedList {
    public static void main(String[] args) {
        int arr[] = { 12, 5, 8, 7 };
        Node head = convert2DLL(arr);
        traverseDLL(head);

        // Node headAfterDel = deleteHead(head);
        // System.out.println("\nAfter deleting Head: ");
        // traverseDLL(headAfterDel);

        // headAfterDel = deleteTail(headAfterDel);
        // System.out.println("\nAfter deleting Tail: ");
        // traverseDLL(headAfterDel);

        head = removeKthElement(head, 1);
        System.out.println("\nAfter deleting Kth element: ");
        traverseDLL(head);

        deleteNode(head.next);
        System.out.println("\nAfter deleting specific Node: ");
        traverseDLL(head);
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

    public static void traverseDLL(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node deleteHead(Node head) {
        if (head == null || head.next == null){
            return head;
        }
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;
        return head;
    }

    public static Node deleteTail(Node head) {
        if (head == null || head.next == null)
            return null;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node prev = tail.back;
        prev.next = null;
        tail.back = null;
        return head;
    }

    public static Node removeKthElement(Node head, int k) {
        if (head == null){
            return null;
        }
        int count = 0;
        Node kNode = head;
        while (kNode != null) {
            count++;
            if (count == k){
                break;
            }
            kNode = kNode.next;
        }
        Node prev = kNode.back;
        Node front = kNode.next;

        // DLL has single element
        if (prev == null && front == null) {
            return null;
        } else if (prev == null) { // it is the haed element
           return deleteHead(head);
        } else if (front == null) { // it is the tail element
            return deleteTail(head);
        }
        prev.next = front;
        front.back = prev;
        kNode.next = null;
        kNode.back = null;

        return head;
    }

    private static void deleteNode(Node temp){
        Node prev=temp.back;
        Node front= temp.next;
        if(front==null){
            prev.next=null;
            temp.back=null;
            return;
        }
        prev.next=front;
        front.back=prev;
    }
}
