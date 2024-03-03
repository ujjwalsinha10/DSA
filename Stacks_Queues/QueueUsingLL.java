package Stacks_Queues;

public class QueueUsingLL {
    public static void main(String[] args) {
        Queue1 q= new Queue1();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        q.dequeue();
        System.out.println("size of the Queue is: "+q.size);
        System.out.println("the peek element is: "+q.peek());
    }

}

class QueueNode {
    int val;
    QueueNode next;

    public QueueNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Queue1 {
    QueueNode front = null;
    QueueNode rear = null;
    int size = 0;

    boolean empty() {
        return front == null;
    }

    int peek() {
        if (empty()) {
            System.out.println("Queue is empty.");
            return -1;
        } else
            return front.val;
    }

    void enqueue(int value){
        QueueNode temp= new QueueNode(value);
        if(temp==null){
            System.out.println("Queue is full");
        }else{
            if(front==null){
                front=temp;
                rear=temp;
            }else{
                rear.next=temp;
                rear=temp;
            }
            System.out.println("Inserted in queue");
            size++;
        }
    }

    void dequeue(){
        if(front==null){
            System.out.println("Queue is empty");
        }else{
            System.out.println(front.val+" is removed from Queue");
            QueueNode temp= front;
            front=front.next;
            size--;
        }
    }
}
