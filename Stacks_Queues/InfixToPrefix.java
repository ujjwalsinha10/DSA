package Stacks_Queues;

import java.util.Stack;

/* (Using 2 Stacks)
 * Infix expression: (p+q)*(c-d)
 * Prefix Expression: *+pq-cd
 */
public class InfixToPrefix {
    public static void main(String[] args) {
        String exp = "(p+q)*(c-d)";
        System.out.println("Postfix Expression: " + exp);
        System.out.println("Infix Expression: " + infixToPref(exp));
    }

    private static String infixToPref(String exp) {
        Stack<Character> operators = new Stack<>();
        Stack<String> operands = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            // If current character is an
            // opening bracket, then
            // push into the operators stack.
            if (c == '(') {
                operators.push(c);
            }
            // If current character is a
            // closing bracket, then pop from
            // both stacks and push result
            // in operands stack until
            // matching opening bracket is
            // not found.
            else if (c == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    String op1 = operands.peek();
                    operands.pop();
                    String op2 = operands.peek();
                    operands.pop();
                    char op = operators.peek();
                    operators.pop();
                    // Add operands and operator
                    // in form operator +
                    // operand1 + operand2.
                    String temp = op + op2 + op1;
                    operands.push(temp);
                }
                // Pop opening bracket
                // from stack.
                operators.pop();
            }
            // If current character is an
            // operand then push it into
            // operands stack.
            else if (!isOperator(c)) {
                operands.push(c + "");
            }
            // If current character is an
            // operator, then push it into
            // operators stack after popping
            // high priority operators from
            // operators stack and pushing
            // result in operands stack.
            else {
                while (!operators.isEmpty() && getPriority(c) <= getPriority(operators.peek())) {
                    String op1 = operands.peek();
                    operands.pop();
                    String op2 = operands.peek();
                    operands.pop();
                    char op = operators.peek();
                    operators.pop();
                    String temp = op + op2 + op1;
                    operands.push(temp);
                }
                operators.push(c);
            }
        }
        // Pop operators from operators
        // stack until it is empty and
        // operation in add result of
        // each pop operands stack.
        while (!operators.isEmpty()) {
            String op1 = operands.peek();
            operands.pop();
            String op2 = operands.peek();
            operands.pop();
            char op = operators.peek();
            operators.pop();
            String temp = op + op2 + op1;
            operands.push(temp);
        }
        return operands.peek();
    }

    private static int getPriority(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        } else if (c == '^') {
            return 3;
        }
        return 0;
    }

    private static boolean isOperator(char c) {
        return (!(c >= 'a' && c <= 'z')
                && !(c >= 'A' && c <= 'Z')
                && !(c >= '0' && c <= '9'));
    }
}
