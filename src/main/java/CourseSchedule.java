import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = convert(prerequisites);
        int[] visited = new int[numCourses + 1];
        List<Integer> result = new ArrayList<>();
        boolean isPossible = true;

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                isPossible &= getOrder(i, map, visited, result);
            }
        }
        if (!isPossible) {
            return new int[]{};
        }

        int[] resArr = new int[numCourses];

        for (int i = 0; i < result.size(); i++) {
            resArr[i] = result.get(i);
        }
        return resArr;
    }

    private boolean getOrder(int i, Map<Integer, List<Integer>> map, int[] visited, List<Integer> result) {
        visited[i] = 1;
        List<Integer> adj = map.get(i);

        if (adj != null) {
            for (int j : adj) {
                if (visited[j] == 1) {
                    return false;
                } else if (visited[j] == 0 && !getOrder(j, map, visited, result)) {
                    return false;
                }
            }
        }
        visited[i] = 2;
        result.add(i);
        return true;
    }

    private Map<Integer, List<Integer>> convert(int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            List<Integer> list = map.getOrDefault(prerequisite[0], new ArrayList<>());
            list.add(prerequisite[1]);
            map.put(prerequisite[0], list);
        }

        return map;
    }
}

