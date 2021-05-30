package week3;

import java.util.ArrayDeque;
import java.util.Deque;

class FrontMiddleBackQueue {
    Deque<Integer> q1;
    Deque<Integer> q2;

    public FrontMiddleBackQueue() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void pushFront(int val) {
        q1.addFirst(val);
    }

    public void pushBack(int val) {
        q2.addLast(val);
    }

    public void pushMiddle(int val) {
        while ((q1.size() + q2.size()) / 2 != q1.size()) {
            rebalanceQueues();
        }
        q1.addLast(val);
    }

    public int popFront() {
        if (!q1.isEmpty()) {
            return q1.removeFirst();
        }
        if (!q2.isEmpty()) {
            return q2.removeFirst();
        }
        return -1;
    }

    public int popBack() {
        if (!q2.isEmpty()) {
            return q2.removeLast();
        }
        if (!q1.isEmpty()) {
            return q1.removeLast();
        }
        return -1;
    }

    public int popMiddle() {
        while ((q1.size() + q2.size()) / 2 != q2.size()) {
            rebalanceQueues();
        }
        if (!q1.isEmpty()) {
            return q1.removeLast();
        }
        if (!q2.isEmpty()) {
            return q2.removeLast();
        }
        return -1;
    }

    private void rebalanceQueues() {
        if (q1.size() < q2.size()) {
            q1.addLast(q2.pollFirst());
        } else {
            q2.addFirst(q1.pollLast());
        }
    }
}