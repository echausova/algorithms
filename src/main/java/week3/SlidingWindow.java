package week3;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindow {
    private Deque<Integer> q = new ArrayDeque<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[]  result = new int[nums.length - k + 1];
        int cnt = 0;

        for (int i = 0; i < k; i++) {
            addToQueue(q, nums[i]);
        }
        result[0] = q.peek();

        int j = 1;
        for(int i = k; i < nums.length; i++) {
            if (nums[i - k] == q.getFirst()) {
                q.remove();
            }
            addToQueue(q, nums[i]);
            result[j++] = q.peek();
        }
        return result;
    }

    private void addToQueue(Deque<Integer> q, int el) {
        while(q.size() > 0 && q.peekLast() < el) {
            q.removeLast();
        }
        q.addLast(el);
    }
}
