import javafx.util.Pair;

import java.util.Stack;

class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int k, int m) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(k, m));
        grid[k][m] = 0;

        int count = 0;
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> pair = stack.pop();
            int i = pair.getKey();
            int j = pair.getValue();
            count++;
            if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                stack.push(new Pair<>(i + 1, j));
                grid[i + 1][j] = 0;
            }
            if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                stack.push(new Pair<>(i - 1, j));
                grid[i - 1][j] = 0;
            }
            if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                stack.push(new Pair<>(i, j + 1));
                grid[i][j + 1] = 0;
            }
            if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                stack.push(new Pair<>(i, j - 1));
                grid[i][j - 1] = 0;
            }
        }
        return count;
    }
}
