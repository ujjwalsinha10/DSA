package Stacks_Queues;

import java.util.Stack;

/*
 * Input: ‘postfix’ = “ABC/DA-*+”
 * Output: ‘infix’ = “(A+((B/C)*(D-A))))”
 */
public class PostfixToInfix {
    public static void main(String[] args) {
        String exp = "ABC/DA-*+";
        System.out.println("Postfix Expression: " + exp);
        System.out.println("Infix Expression: " + postfixToInf(exp));
    }

    private static String postfixToInf(String exp) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (!isOperand(c)) {
                String op1 = stack.peek();
                stack.pop();
                String op2 = stack.peek();
                stack.pop();
                String temp = "(" + op2 + c + op1 + ")";
                stack.push(temp);
            } else {
                stack.push(c + "");
            }
        }
        return stack.pop();
    }

    private static boolean isOperand(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
            return true;
        }
        return false;
    }
}
