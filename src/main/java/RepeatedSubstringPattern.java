public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int[] lps = lps(s);
        int lastElem = lps[s.length() - 1];

        return lastElem > 0 && s.length() % (s.length() - lastElem) == 0;
    }

    public int[] lps(String s) {
        int[] lps = new int[s.length()];

        int len = 0;
        for (int i = 1; i < s.length(); i++) {
            while (len > 0 && s.charAt(len) != s.charAt(i)) {
                len = lps[len - 1];
            }
            if (s.charAt(i) == s.charAt(len)) {
                len++;
            }
            lps[i] = len;
        }
        return lps;
    }

}
