import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class MaxAreaOfIslandDSU {
    public int maxAreaOfIsland(int[][] grid) {
        DSU1 dsu = new DSU1(grid);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        dsu.union(new Pair<>(i - 1, j), new Pair<>(i, j));
                    }
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                        dsu.union(new Pair<>(i + 1, j), new Pair<>(i, j));
                    }

                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        dsu.union(new Pair<>(i, j - 1), new Pair<>(i, j));
                    }
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                        dsu.union(new Pair<>(i, j + 1), new Pair<>(i, j));
                    }
                }
            }
        }
        return dsu.getMaxArea();
    }
}

class DSU1 {
    private Map<Pair<Integer, Integer>, Pair<Integer, Integer>> parent;
    private Map<Pair<Integer, Integer>, Integer> rank;
    private Map<Pair<Integer, Integer>, Integer> area;
    private int maxArea;

    DSU1(int[][] grid) {
        parent = new HashMap<>();
        rank = new HashMap<>();
        area = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                parent.put(new Pair<>(i, j), new Pair<>(i, j));
                rank.put(new Pair<>(i, j), 1);
                if (grid[i][j] == 1) {
                    area.put(new Pair<>(i, j), 1);
                    maxArea = 1;
                } else {
                    area.put(new Pair<>(i, j), 0);
                }
            }
        }
    }

    public Pair<Integer, Integer> find(Pair<Integer, Integer> x) {
        Pair<Integer, Integer> p = parent.get(x);
        if (!p.equals(x)) {
            p = find(p);
            parent.put(x, p);
        }
        return p;
    }

    public void union(Pair<Integer, Integer> x, Pair<Integer, Integer> y) {
        Pair<Integer, Integer> px = find(x);
        Pair<Integer, Integer> py = find(y);

        if (px.equals(py)) {
            return;
        }

        if (rank.get(px) < rank.get(py)) {
            parent.put(px, py);
            area.put(py, area.get(px) + area.get(py));
        } else if (rank.get(py) < rank.get(px)) {
            parent.put(py, px);
            area.put(px, area.get(px) + area.get(py));
        } else {
            parent.put(px, py);
            rank.put(py, rank.get(py) + 1);
            area.put(py, area.get(px) + area.get(py));
        }
        maxArea = Math.max(maxArea, Math.max(area.get(px), area.get(py)));
    }

    public int getMaxArea() {
        return maxArea;
    }
}
