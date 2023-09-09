class Solution {
    public int solve(int[] nums, int idx, int target, int[][] dp){
        if(idx >= nums.length || target < 0){
            return 0;
        }
        if(target == 0){
            return 1;
        }
        
        if(dp[target][idx] != -1){
            return dp[target][idx];
        }
        
        int take = solve(nums, 0, target-nums[idx], dp);
        int reject = solve(nums, idx+1, target, dp);
        
        return dp[target][idx] = take+reject;
    }
        
    public int combinationSum4(int[] nums, int target) {
        int[][] dp = new int[target+1][nums.length+1];
        for(int i=0; i<target+1; i++)
            Arrays.fill(dp[i], -1);
    
        return  solve(nums, 0, target, dp);
    }
}
