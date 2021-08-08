import javafx.util.Pair;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorginizeString {
    public static String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), count + 1);
        }

        pq.addAll(map.keySet());

        while(pq.size() > 1) {
            char c1 = pq.poll();
            char c2 = pq.poll();
            result.append(c1);
            result.append(c2);

            map.put(c1, map.get(c1) - 1);
            map.put(c2, map.get(c2) - 1);
            if (map.get(c1) <= 0) {
                map.remove(c1);
            } else {
                pq.offer(c1);
            }

            if (map.get(c2) <= 0) {
                map.remove(c2);
            } else {
                pq.offer(c2);
            }
        }

        if (pq.size() == 1) {
            if (map.get(pq.peek()) > 1) {
                return "";
            }
            result.append(pq.poll());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(reorganizeString(s));
    }
}
