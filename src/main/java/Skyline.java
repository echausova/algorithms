import java.util.*;

public class Skyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();

        List<Point> list = convertToPoints(buildings);
        list.sort(Comparator.comparingInt(Point::getX));

        int prevHeight = 0;
        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> b.getHeight() - a.getHeight());

        for (Point p : list) {
            if (p.isStart()) {
                pq.offer(p);
            } else {
                //remove all the points that are before the currect point
                while (!pq.isEmpty() && pq.peek().getOther() <= p.getX()) {
                    pq.poll();
                }
            }

            Point cur = pq.peek();
            if (cur == null || cur.getHeight() != prevHeight) {
                int h = cur == null ? 0 : cur.getHeight();
                addSubResult(p.getX(), h, result);
                prevHeight = h;
            }
        }
        return result;
    }


    private void addSubResult(int x, int height, List<List<Integer>> result) {
        List<Integer> res = new ArrayList<>();
        res.add(x);
        res.add(height);
        result.add(res);
    }

    private List<Point> convertToPoints(int[][] buildings) {
        List<Point> list = new ArrayList<>();

        for (int[] building : buildings) {
            Point start = new Point(building[0], building[1], building[2], true);
            list.add(start);
            Point end = new Point(building[1], building[0], building[2], false);
            list.add(end);
        }

        return list;
    }

    private class Point {
        private int x;
        private int other;
        private int height;
        private boolean isStart;

        Point(int x, int other, int height, boolean isStart) {
            this.x = x;
            this.other = other;
            this.height = height;
            this.isStart = isStart;
        }

        public int getX() {
            return x;
        }

        public int getOther() {
            return other;
        }

        public int getHeight() {
            return height;
        }

        public boolean isStart() {
            return isStart;
        }
    }
}


