import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedian {
    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;


    /**
     * initialize your data structure here.
     */
    public FindMedian() {
        min = new PriorityQueue<Integer>();
        max = new PriorityQueue<Integer>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (min.size() == 0 && max.size() == 0) {
            max.offer(num);
            return;
        }
        if (max.peek() >= num) {
            max.offer(num);
        } else {
            min.offer(num);
        }

        if (min.size() > max.size()) {
            max.offer(min.poll());
        } else if (max.size() > min.size()) {
            min.offer(max.poll());
        }
    }

    public double findMedian() {
        if (min.size() == 0) {
            return max.peek();
        }
        if (max.size() == 0) {
            return min.peek();
        }
        if (max.size() == min.size()) {
            return (double) (min.peek() + max.peek()) / 2;
        } else if (min.size() > max.size()) {
            return min.peek();
        } else {
            return max.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
