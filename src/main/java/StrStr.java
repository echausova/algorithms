public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }

        int[] lps = lps(needle);

        int i = 0;
        int j = 0;

        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i++;
                if (j == needle.length()) {
                    return i - j;
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }

        }

        return -1;
    }

    public int[] lps(String needle) {
        int[] lps = new int[needle.length()];

        int len = 0;

        for (int i = 1; i < lps.length; i++) {
            while (len > 0 && needle.charAt(len) != needle.charAt(i)) {
                len = lps[len - 1];
            }

            if (needle.charAt(i) == needle.charAt(len)) {
                len = len + 1;
            }
            lps[i] = len;
        }

        return lps;
    }
}
