package Stacks_Queues;

import java.util.Stack;

/**
 * Input Format:["MinStack", "push", "push", "push", "getMin", "pop", "top",
 * "getMin"]
 * [
 * [ ], [-2], [0], [-3], [ ], [ ], [ ], [ ]
 * ]
 * Result: [null, null, null, null, -3, null, 0, -2]
 */
public class MinStack {
    Stack<Pair> st;

    // Normal Approach
    // TC: O(1) SC:O(2N)
    public static void main(String[] args) {
        MinStack ms= new MinStack();
        ms.init();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println("getMin() returned is: "+ms.getMin());
        ms.pop();
        System.out.println("top() returned is: "+ms.top());
        System.out.println("getMin() returned is: "+ms.getMin());
    }

    public void init(){
        st= new Stack<>();
    }
    public void push(int x) {
        int min;
        if (st.isEmpty()) {
            min = x;
        } else {
            min = Math.min(st.peek().y, x);
        }
        st.push(new Pair(x, min));
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().x;
    }

    public int getMin(){
       return st.peek().y;
    }
}

class Pair {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}