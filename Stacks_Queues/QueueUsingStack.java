package Stacks_Queues;

import java.util.Stack;

public class QueueUsingStack {
    public static void main(String[] args) {
        customQueue1 c1= new customQueue1();
        c1.push(3);
        c1.push(4);
        System.out.println("The element poped is " + c1.pop());
        c1.push(5);
        System.out.println("The top element is " + c1.peek());
        System.out.println("The size of the queue is " + c1.size());

        System.out.println("Approach 2");
        customQueue2 c2= new customQueue2();
        c2.push(3);
        c2.push(4);
        System.out.println("The element poped is " + c2.pop());
        c2.push(5);
        System.out.println("The top element is " + c2.peek());
        System.out.println("The size of the queue is " + c2.size());
    }
}
// using two stacks where push operation is O(N)
class customQueue1 {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public customQueue1() {

    }

    public void push(int x) {
        while (input.isEmpty() == false) {
            output.push(input.peek());
            input.pop();
        }
        System.out.println("Element pushed is: " + x);
        input.push(x);
        while (output.empty() == false) {
            input.push(output.peek());
            output.pop();
        }
    }

    public int pop() {
        if (input.empty()) {
            System.out.println("Stack is empty");
        }
        int val = input.peek();
        input.pop();
        return val;
    }

    public int peek() {
        if (input.empty()) {
            System.out.println("Stack is emoty");
        }
        return input.peek();
    }

    public int size(){
        return input.size();
    }
}

// using two stacks where push operation is O(1)
class customQueue2{
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public customQueue2() {

    }

    public void push(int x){
        System.out.println("The element pushed is: "+x);
        input.push(x);
    }
    public int pop(){
        if(output.empty()){
            while(input.empty()==false){
                output.push(input.peek());
                input.pop();
            }
        }
        int x=output.peek();
        output.pop();
        return x;
    }
    public int peek(){
        if(output.empty()){
            while(input.empty()==false){
                output.push(input.peek());
                input.pop();
            }
        }
        return output.peek();
    }

    public int size(){
        return input.size()+output.size();
    }
}
