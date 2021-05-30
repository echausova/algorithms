package week3;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        char[] arr = s.toCharArray();
        int nonDupIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            int dupIdx = -1;
            if (map.containsKey(arr[i])) {
                dupIdx = map.get(arr[i]);

            }

            if (dupIdx != -1 && dupIdx >= nonDupIdx) {
                maxLen = Math.max(maxLen, i - nonDupIdx);
                nonDupIdx = dupIdx + 1;
            }
            map.put(arr[i], i);
        }
        return Math.max(maxLen, s.length() - nonDupIdx);
    }
}
