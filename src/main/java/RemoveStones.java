import java.util.Arrays;

public class RemoveStones {
    public int removeStones(int[][] stones) {
        DSU dsu = new DSU(stones);

        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    dsu.union(i, j);
                }
            }
        }
        return dsu.getCount();
    }
}

 class DSU {
    private int[] parent;
    private int[] rank;

    private int count;

    DSU(int[][] stones) {
        parent = new int[stones.length];
        rank = new int[stones.length];
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
        count++;
    }

    public int getCount() {
        return count;
    }
}
