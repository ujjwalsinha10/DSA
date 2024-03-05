package Stacks_Queues;

import java.util.Stack;

public class MinStack2 {
    Stack<Long> st;
    Long mini;

    // Optimised Approach
    // TC: O(1) SC: O(N)
    public static void main(String[] args) {
        MinStack2 ms = new MinStack2();
        ms.init();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println("getMin() returned is: " + ms.getMin());
        ms.pop();
        System.out.println("top() returned is: " + ms.top());
        System.out.println("getMin() returned is: " + ms.getMin());
    }

    public void init() {
        st = new Stack<>();
        mini = Long.MAX_VALUE;
    }

    public void push(int value) {
        Long val = Long.valueOf(value);
        if (st.isEmpty()) {
            mini = val;
            st.push(val);
        } else {
            if (val < mini) {
                st.push(2 * val - mini);
                mini = val;
            } else {
                st.push(val);
            }
        }
    }

    public void pop() {
        if (st.isEmpty()) {
            return;
        }
        long val = st.pop();
        if (val < mini) {
            mini = 2 * mini - val;
        }
    }

    public int top() {
        Long val = st.peek();
        if (val < mini) {
            return mini.intValue();
        }
        return val.intValue();
    }

    public int getMin() {
        return mini.intValue();
    }
}
