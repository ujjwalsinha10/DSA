package Stacks_Queues;

import java.util.Stack;

/*
 * Input: /-ab+-cde
 * Output: ((a-b)/((c-d)+e))
 * Explanation:
 * In this test case, there are four operators ‘/’, ‘-’, ‘+’, ‘-’.
 * Prefix expression:  /-ab+-cde. 
 * The operator between  ‘a’ and ‘b’ is ‘-’. Resulting expression: /(a-b)+-cde.
 * The operator between  ‘c’ and ‘d’ is ‘-’. Resulting expression: /(a-b)+(c-d)e.
 * The operator between ‘c-d’ and ‘e’ is +. Resulting expression: /(a-b)((c-d)+e).
 * The operator between ‘a-b’ and ‘((c-d)+e)’ is ‘/’. 
 * Resulting expression: ((a-b)/((c-d)+e)).
 */
public class PrefixToInfix {
    public static void main(String[] args) {
        String exp = "/-ab+-cde";
        System.out.println("Prefix Expression: " + exp);
        System.out.println("Infix Expression: " + prefixToInf(exp));
    }

    // NOTE: for Prefix -> iterate from end
    // TC: O(N) SC: O(N)
    private static String prefixToInf(String exp) {
        Stack<String> stack = new Stack<>();
        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);
            if (isOperator(c)) {
                // popping the top element
                String op1 = stack.pop();
                // Popping the second element
                String op2 = stack.pop();
                // arranging the expression
                String temp = "(" + op1 + c + op2 + ")";
                // Push the whole formed expression to Stack for next operation
                stack.push(temp);
            } else {
                // coversion from char to String
                stack.push(c + "");
            }
        }
        return stack.pop();
    }

    // check for operator
    private static boolean isOperator(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
            case '%':
                return true;
        }
        return false;
    }
}
