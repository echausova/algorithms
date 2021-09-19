public class LongestPalidnrome {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }

        int start = 0;
        int end = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if ((j - i) > (end - start)) {
                            start = i;
                            end = j;
                        }
                    }

                }
            }
        }
        return s.substring(start, end + 1);

    }
}
