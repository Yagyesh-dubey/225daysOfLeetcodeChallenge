 class Solution {
     public int minOperations(int[] nums, int x) {
         int n = nums.length;
         int dp[][] = new int [n+1][n+1];

         for(int [] arr : dp)Arrays.fill(arr,-1);

         int temp = helper(nums,x,0,n-1,n,dp);

         return temp == 1000000 ? -1:temp;
     }
     public int helper(int[] nums,int x,int i,int j,int n,int dp[][]){
         if(x == 0)return 0;
         if(i > j || i >= n || j < 0 || x < 0){
             return 1000000;
         }
         if(dp[i][j] != -1)return dp[i][j];

         int ans = 1000000;
         ans = Math.min(ans,1+helper(nums,x-nums[i],i+1,j,n,dp));
         ans = Math.min(ans,1+helper(nums,x-nums[j],i,j-1,n,dp));
         return dp[i][j] = ans;
     }
 }
