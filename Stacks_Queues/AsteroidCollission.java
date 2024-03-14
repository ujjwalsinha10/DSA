package Stacks_Queues;

import java.util.Stack;

/*
 * Input: asteroids = [10,2,-5]
 * Output: [10]
 * Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 */

public class AsteroidCollission {
    public static void main(String[] args) {
        int asteroids[] = { -2, -1, 1, 2 };
        int[] collide = collide(asteroids);
        for (int i : collide) {
            System.out.print(i);
        }
    }

    private static int[] collide(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int a : arr) {
            if (a > 0) {
                stack.push(a);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(a)) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(a);
                } else if (stack.peek() == Math.abs(a)) {
                    stack.pop();
                }
            }
        }

        return stack.stream().mapToInt(e -> e).toArray();
    }
}
