package Stacks_Queues;

import java.util.Stack;

/*
 * Input :  Postfix : ABC/-AK/L-*
 * Output : Prefix :  *-A/BC-/AKL
 */
public class PostfixToPrefix {
    public static void main(String[] args) {
        String exp="ABC/-AK/L-*";
        System.out.println("Prefix Expression: " + exp);
        System.out.println("Postfix Expression: " + postfixToPre(exp));
    }

    // TC: O(N) SC: O(N)
    private static String postfixToPre(String exp) {
        Stack<String> stack= new Stack<>();
        for(int i=0;i<exp.length();i++){
            char c=exp.charAt(i);
            if(isOperator(c)){
                String op1= stack.peek();
                stack.pop();
                String op2=stack.peek();
                stack.pop();
                String temp=c+op2+op1;
                stack.push(temp);

            }else{
                stack.push(c+"");
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
        }
        return false;
    }
}
