import javafx.util.Pair;

import java.util.Stack;

class Islands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        Stack<Pair<Integer, Integer>> stack = new Stack<>();

        stack.push(new Pair<>(i, j));

        while(!stack.isEmpty()) {
            Pair<Integer, Integer> el = stack.pop();
            int row = el.getKey();
            int col = el.getValue();

            int[][] dimensions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

            for (int[] d : dimensions) {

                if (row + d[0] >= 0 && row + d[0] < grid.length &&
                        col + d[1] >= 0 && col + d[1] < grid[0].length &&
                        grid[row + d[0]][col + d[1]] == '1') {
                    stack.push(new Pair<>(row + d[0], col + d[1]));
                    grid[row + d[0]][col + d[1]] = '0';
                }
            }
        }
    }
}