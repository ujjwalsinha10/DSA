package Stacks_Queues;

import java.util.Stack;

/**
 * Input: a+b*(c^d-e)^(f+g*h)-i
 * Output: abcd^e-fgh*+^*+i-
 */
public class InfixToPostfix {

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Infix expression: " + exp);
        System.out.println("Postfix expression:" + infixToPost(exp));
    }

    // TC: O(N) SC: O(N)
    private static String infixToPost(String exp) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            // If the scanned character is an
            // operand, add it to output.
            if (Character.isLetterOrDigit(c)) {
                result += c;
            }
            // If the scanned character is an '(',
            // push it to the stack.
            else if (c == '(') {
                stack.push(c);
            }
            // If the scanned character is an ')',
            // pop and output from the stack
            // until an '(' is encountered.
            else if (c == ')') {
                while (!stack.isEmpty() & stack.peek() != '(') {
                    result += stack.pop();
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && prec(c) <= prec(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(c);
            }
        }
        // pop all the operators from the stack
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    // A utility function to return
    // precedence of a given operator
    // Higher returned value means
    // higher precedence
    private static int prec(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }
}