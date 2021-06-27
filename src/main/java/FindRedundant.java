import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindRedundant {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        ArrayList<Integer>[] graph = new ArrayList[n+ 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        Set<Integer> visited = new HashSet<>();

        for (int[] edge : edges) {
            visited = new HashSet<>();
            graph[edge[0]].add(edge[1]);
          //  graph[edge[1]].add(edge[0]);
            if (!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() &&
                    dfs(graph, edge[0], -1, visited)) {
                return edge;
            }
        }

        return null;
    }

    private boolean dfs(ArrayList<Integer>[] graph, int v, int parent, Set<Integer> visited) {
        visited.add(v);
        System.out.println("v=====" + v);
        List<Integer> adj = graph[v];

        for (int i : adj) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int n : adj) {
            System.out.println("n=" + n + " contains=" + visited.contains(n) + " parent=" + parent);
            if (!visited.contains(n) && dfs(graph, n, v, visited)) {
                return true;
            } else if (n != parent) {
                System.out.println("n=" + n + " parent=" + parent);
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};
        FindRedundant fr = new FindRedundant();
        fr.findRedundantConnection(edges);
    }
}
