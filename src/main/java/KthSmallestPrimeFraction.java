import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> getDouble(b) - getDouble(a) > 0 ? 1 : -1);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                Pair<Integer, Integer> val = new Pair<>(arr[i], arr[j]);
                if (pq.size() < k) {
                    pq.offer(val);
                } else if (getDouble(pq.peek()) > getDouble(val)) {
                    pq.poll();
                    pq.offer(val);
                }
            }
        }
        int[] res = new int[2];
        res[0] = pq.peek().getKey();
        res[1] = pq.peek().getValue();
        return res;

    }

    private double getDouble(Pair<Integer, Integer> pair) {
        return (double)pair.getKey() / (double)pair.getValue();
    }
}
