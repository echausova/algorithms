import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] tmp = s.toCharArray();
            Arrays.sort(tmp);
            String sortedStr = new String(tmp);
            List<String> list = map.getOrDefault(sortedStr, new ArrayList<>());
            list.add(s);
            map.put(sortedStr, list);
        }

        return new ArrayList<>(map.values());
    }
}

