package week3;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        int result = 0;

        for (int i = 0; i < tokens.length; i++) {
            if (operators.contains(tokens[i])) {
                int first = Integer.valueOf(stack.pop());
                int second = Integer.valueOf(stack.pop());

                switch(tokens[i]) {
                    case "+":
                        result = first + second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "-":
                        result = second - first;
                        break;
                    case "/":
                        result = second / first;
                        break;
                }
                stack.push(String.valueOf(result));

            } else {
                stack.push(tokens[i]);
            }
        }
        result = Integer.valueOf(stack.pop());
        return result;
    }
}
