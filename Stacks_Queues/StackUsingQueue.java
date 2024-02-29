package Stacks_Queues;

import java.util.Queue;

// TC: O(N) SC: O(N)
public class StackUsingQueue {
    public static void main(String[] args) {
        customStack s = new customStack();
        s.push(3);
        s.push(2);
        s.push(4);
        s.push(1);
        System.out.println("Top of the stack: " + s.top());
        System.out.println("Size of the stack before removing element: " + s.size());
        System.out.println("The deleted element is: " + s.pop());
        System.out.println("Top of the stack after removing element: " + s.top());
        System.out.println("Size of the stack after removing element: " + s.size());

    }
}

class customStack {
    Queue<Integer> q = new java.util.LinkedList<>();

    void push(int x) {
        q.add(x);
        // Use a for loop of size()-1, remove element from queue and again push back to
        // the queue, hence the most recent element becomes the most former element and
        // vice versa.
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
    }

    int pop() {
        return q.remove();
    }

    int top() {
        return q.peek();
    }

    int size() {
        return q.size();
    }
}
