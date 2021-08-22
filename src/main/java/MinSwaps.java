import java.util.Arrays;

public class MinSwaps {
    public int minSwapsCouples(int[] row) {
        DSU dsu = new DSU(row.length);

        int count = 0;
        for (int i = 0; i < row.length - 1; i += 2) {
            dsu.union(row[i], row[i + 1]);
        }

        for (int i = 0; i < row.length - 1; i += 2) {
            if (dsu.find(i) != dsu.find(i + 1)) {
                dsu.union(i, i + 1);
                count++;
            }
        }
        return count;
    }
}

class DSU {
    private int[] rank;
    private int[] parent;

    DSU(int n) {
        rank = new int[n];
        parent = new int[n];
        Arrays.fill(parent, -1);
    }

    public int find(int x) {
        if (parent[x] == -1) {
            parent[x] = x;
            return x;
        }
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) {
            return;
        }

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[py] < rank[px]) {
            parent[py] = px;
        } else {
            parent[px] = py;
            rank[py]++;
        }
    }
}
