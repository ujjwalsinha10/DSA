package Stacks_Queues;

import java.util.Stack;

/*
 * Input: str = “( )[ { } ( ) ]”
 * Output: True
 */
public class BalancedParenthesis {
    public static void main(String[] args) {
        String str="()[{}()]";
        System.out.println(checkBalance(str));
    }

    // TC: O(N) SC:O(N)
    private static boolean checkBalance(String str) {
        Stack<Character> stack= new Stack<>();
        for(char it: str.toCharArray()){
            if(it == '(' || it == '{' || it =='['){
                stack.push(it);
            }else{
                if(stack.isEmpty()) return false;
                char ch= stack.peek();
                if((it==')' && ch=='(') || (it=='}' && ch=='{' )||( it ==']' && ch == '[')){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
