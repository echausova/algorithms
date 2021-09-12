import java.util.Comparator;
import java.util.PriorityQueue;

public class MInEffort {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(Comparator.comparingInt(o -> o[2]));
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        int[][] minDist = new int[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                minDist[i][j] = Integer.MAX_VALUE;
            }
        }
        minDist[0][0] = 0;
        visited[0][0] = true;

        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] v = pq.poll();

            int i = v[0];
            int j = v[1];
            visited[i][j] = true;

            if (i == heights.length - 1 && j == heights[0].length) {
                return v[2];
            }


            if (i - 1 >= 0 && !visited[i - 1][j]) {
                updateDiff(minDist, heights, pq, visited, i - 1, j, i, j);
            }
            if (i + 1 < heights.length && !visited[i + 1][j]) {
                updateDiff(minDist, heights, pq, visited, i + 1, j, i, j);
            }
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                updateDiff(minDist, heights, pq, visited, i, j - 1, i, j);
            }
            if (j + 1 < heights[0].length && !visited[i][j + 1]) {
                updateDiff(minDist, heights, pq, visited, i, j + 1, i, j);
            }
        }

        return minDist[heights.length - 1][heights[0].length - 1];
    }

    private void updateDiff(int[][] minDist, int[][] heights, PriorityQueue<int[]> pq, boolean[][] visited, int i, int j, int curI, int curJ) {
        if (visited[i][j]) {
            return;
        }
        int currDiff = Math.abs(heights[curI][curJ] - heights[i][j]);
        int diff = Math.max(minDist[curI][curJ], currDiff);
        if (minDist[i][j] > diff) {
            pq.offer(new int[]{i, j, diff});
            minDist[i][j] = diff;
        }
    }
}