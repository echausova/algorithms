import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) {
            return false;
        }


        Map<String, String> first = new HashMap<>();
        Map<String, String> second = new HashMap<>();
        int i = 0;
        while (i < s.length()) {
            String sc = String.valueOf(s.charAt(i));
            String tc = String.valueOf(t.charAt(i));
            if (first.containsKey(sc) && !first.get(sc).equals(tc)) {
                return false;
            } else if (!first.containsKey(sc) && second.containsKey(tc) ) {
                return false;
            } else {
                first.put(sc, tc);
                second.put(tc, sc);
            }
            i++;
        }
        return true;
    }
}
