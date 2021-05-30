package week3;

import javafx.util.Pair;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        stack.push(new Pair<>(temperatures[0], 0));

        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek().getKey()) {
                Pair<Integer, Integer> pair = stack.pop();
                int index = pair.getValue();
                result[index] = i - index;
            }
            stack.push(new Pair<>(temperatures[i], i));

        }
        return result;
    }
}
