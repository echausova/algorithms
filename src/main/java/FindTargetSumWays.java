public class FindTargetSumWays {
    public int findTargetSumWays(int[] nums, int target) {
        int[][] dp = new int[nums.length][2001];
        return findTargetSum(nums, dp, target);
    }

    private int findTargetSum(int[] nums, int[][] dp, int target) {
        dp[0][nums[0] + 1000] = 1;
        dp[0][-1 * nums[0] + 1000] += 1;

        for (int i = 1; i < nums.length; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                int prev = dp[i - 1][sum + 1000];
                if (prev > 0) {
                    dp[i][sum + 1000 + nums[i]] += prev;
                    dp[i][sum + 1000 - nums[i]] += prev;
                }
            }
        }
        return dp[nums.length - 1][target + 1000];
    }
}
