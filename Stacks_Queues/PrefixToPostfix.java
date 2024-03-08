package Stacks_Queues;

import java.util.Stack;

/*
 * Input :  Prefix :  *-A/BC-/AKL
 * Output : Postfix : ABC/-AK/L-*
 */
public class PrefixToPostfix {
    public static void main(String[] args) {
        String exp="*-A/BC-/AKL";
        System.out.println("Prefix Expression: " + exp);
        System.out.println("Postfix Expression: " + prefixToPost(exp));
    }

    private static String prefixToPost(String exp) {
        Stack<String> stack= new Stack<>();
        for(int i=exp.length()-1;i>=0;i--){
            char c= exp.charAt(i);
            if(isOperator(c)){
                String op1= stack.peek();
                stack.pop();
                String op2= stack.peek();
                stack.pop();
                String temp=op1+op2+c;
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
            case '^':
            case '%':
                return true;
        }
        return false;
    }
}
