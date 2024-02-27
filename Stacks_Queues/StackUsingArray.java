package Stacks_Queues;

public class StackUsingArray {
    public static void main(String[] args) {
        Stack1 stack= new Stack1();
        System.out.println(stack.isEmpty());
        stack.push(2);
        stack.push(3);
        System.out.println("Peek: "+stack.peek());
        System.out.println("Size: "+stack.size());
        System.out.println("Pop: "+stack.pop());
        System.out.println(stack.isEmpty());
    }
}
class Stack1{
    int size=1000;
    int arr[]=new int[size];
    int top=-1;
    void push(int x){
        top++;
        arr[top]=x;
    }
    int pop(){
        int x=arr[top];
        top--;
        return x;
    }
    int size(){
        return top+1;
    }
    boolean isEmpty(){
        return (top==-1);
    }
    int peek(){
        return arr[top];
    }
}
