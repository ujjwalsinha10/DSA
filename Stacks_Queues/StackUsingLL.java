package Stacks_Queues;

public class StackUsingLL {
    public static void main(String[] args) {
        stack1 s = new stack1();
        s.stackPush(10);
        s.stackPush(20);
        s.printStack();
        System.out.println("Element popped " + s.stackPop());
        System.out.println("Stack size: " + s.stackSize());
        System.out.println("Stack is empty or not: " + s.isStackEmpty());
    }
}

class stack1 {
    stackNode top;
    int size;

    stack1() {
        this.top = null;
        this.size = 0;
    }

    public void stackPush(int x) {
        stackNode element = new stackNode(x);
        element.next = top;
        top = element;
        System.out.println("Element pushed");
        size++;
    }

    public int stackPop() {
        if (top == null) {
            return -1;
        }
        int topData = top.data;
        stackNode temp = top;
        top = top.next;
        return topData;
    }

    public int stackSize() {
        return size;
    }

    public boolean isStackEmpty() {
        return top == null;
    }

    public void printStack() {
        stackNode current = top;
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class stackNode {
    int data;
    stackNode next;

    stackNode(int data) {
        this.data = data;
        this.next = null;
    }
}
