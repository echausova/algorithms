import java.util.LinkedList;
import java.util.Queue;

class OrangesRotting {
    public int orangesRotting(int[][] grid) {
        Queue<Cell> queue = new LinkedList<>();

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Cell(i, j, 0));
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return bfs(queue, grid, count);
    }

    private int bfs(Queue<Cell> queue, int[][] grid, int count) {
        int result = 0;
        while (!queue.isEmpty()) {
            Cell p = queue.remove();
            int i = p.getRow();
            int j = p.getCol();
            int level = p.getLevel();

            if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                queue.add(new Cell(i - 1, j, level + 1));
                count--;
                grid[i - 1][j] = 2;
            }

            if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                queue.add(new Cell(i + 1, j, level + 1));
                count--;
                grid[i + 1][j] = 2;
            }

            if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                queue.add(new Cell(i, j - 1, level + 1));
                count--;
                grid[i][j - 1] = 2;
            }

            if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                queue.add(new Cell(i, j + 1, level + 1));
                count--;
                grid[i][j + 1] = 2;
            }
            result = level;
        }
        return count > 0 ? -1 : result;
    }

    private class Cell {
        private int i;
        private int j;
        private int level;

        Cell(int i, int j, int level) {
            this.i = i;
            this.j = j;
            this.level = level;
        }
        int getRow() {
            return i;
        }

        int getCol() {
            return j;
        }

        int getLevel() {
            return level;
        }
    }
}