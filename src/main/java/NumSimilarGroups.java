import java.util.Arrays;

public class NumSimilarGroups {
    public int numSimilarGroups(String[] strs) {
        DSU dsu = new DSU(strs.length);

        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    dsu.union(i, j);
                }
            }
        }

        return dsu.getCount();
    }

    private boolean isSimilar(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}

class DSU {
    private int[] rank;
    private int[] parent;
    private int count;

    DSU(int n) {
        rank = new int[n];
        parent = new int[n];
        Arrays.fill(parent, -1);
        count = n;

    }

    public int find(int val) {
        if (parent[val] == -1) {
            parent[val] = val;
            return val;
        }
        if (parent[val] != val) {
            parent[val] = find(parent[val]);
        }
        return parent[val];
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
        count--;
    }

    public int getCount() {
        return count;
    }
}
