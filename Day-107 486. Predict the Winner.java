
class Solution {
    private int[][] dp = new int[23][23];

    public int solve(int[] nums, int F, int L) {
        if (F > L) return 0;
        if (F == L) return nums[F];
        if (dp[F][L] != -1) return dp[F][L];

        int F_score = nums[F] - solve(nums, F + 1, L);
        int L_score = nums[L] - solve(nums, F, L - 1);
        dp[F][L] = Math.max(F_score, L_score);
        return dp[F][L];
    }

    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length - 1;
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(nums, 0, n) >= 0;
    }
}
