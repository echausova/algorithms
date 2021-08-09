public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp.length; j++) {
                if (nums[i] >= nums[j]) {
                    dp[j] = dp[j] == 0 ? 1 : dp[j];
                } else {
                    dp[j] = Math.max(dp[j], dp[i] +  1);
                    maxLength = Math.max(maxLength, dp[j]);
                }
            }
        }

        return maxLength;
    }
}
