package LinkedList.DoublyLinkedList;

import java.util.Stack;

public class ReverseDLL {
    public static void main(String[] args) {
        addNode(4);
        addNode(2);
        addNode(3);
        addNode(1); 
        // print();
        bruteForceApproach();
        Node node1=optimizedSolution();
        System.out.println("\nOptimized Solution:");
        print(node1);
    }

    

    static Node head,tail=null;
    private static void addNode(int data){
        Node node= new Node(data, null, null);
        if(head==null){
            head=tail=node;
            head.back=null;
            tail.next=null;
        }else{
            tail.next=node;
            node.back=tail;
            tail=node;
            tail.next=null;
        }
    }
    private static void print(Node head1){
        Node current=head1;
        while(current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
    }

    // TC: O(N) SC: O(1)
    private static Node optimizedSolution() {
        Node current=head;
        Node temp=null;
        while(current!=null){
            temp=current.back;
            current.back=current.next;
            current.next=temp;
            current=current.back;
        }
       return temp.back;
    }

    // TC: O(2N) SC: O(N) -> because of stack Data structure
    public static void bruteForceApproach(){
        Node current= head;
        Stack<Integer> stack= new Stack<>();
        while(current!=null){
            stack.push(current.data);
            current=current.next;
        }
        Node temp=head;
        while(temp!=null){
            temp.data=stack.pop();
            temp=temp.next;
        }
        print(head);
    }
    

    
}
