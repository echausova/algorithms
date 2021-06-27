package week2;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    static Deque<Integer> q = new ArrayDeque<>();

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[]  result = new int[nums.length - k + 1];
        int cnt = 0;
        int j = 1;
        while (cnt < k) {
            addToQueue(q, nums[cnt]);
            cnt++;
        }
        result[0] = q.peek();

        for(int i = k; i < nums.length; i++) {
            if (nums[i - k] == q.getLast()) {
                q.remove();
            }
            addToQueue(q, nums[i]);
            result[j++] = q.peek();
        }
        return result;
    }

    private static void addToQueue(Deque<Integer> q, int el) {
        while(q.size() > 0 && q.peekLast() < el) {
            q.remove();
        }
        q.addLast(el);
    }

    public static void main(String[] args) {
        int[] arr = {1,3,1,2,0,5};
        int[] res = maxSlidingWindow(arr, 3);

    }
}
