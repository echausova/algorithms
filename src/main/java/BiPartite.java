import java.util.LinkedList;
import java.util.Queue;

public class BiPartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == 0) {
                boolean result = bfs(graph, i, colors);
                if (!result) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfs(int[][] graph, int i, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        colors[i] = 1;

        while (!queue.isEmpty()) {
            int el = queue.remove();
            int[] adj = graph[el];
            for (int j : adj) {

                if (colors[j] == colors[el]) {
                    return false;
                }
                if (colors[j] == 0) {
                    colors[j] = colors[el] == 1 ? 2 : 1;
                    queue.add(j);
                }
            }
        }

        return true;
    }
    
}
