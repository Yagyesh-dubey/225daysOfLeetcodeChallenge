class Solution {
    public int countOrders(int n) {
        int mod=1000000007;
        int[] dp=new int[501];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i]=(int)(((long)dp[i-1]*(long)i*(long)(2*i-1))%mod);
        }
        return dp[n];
    }
}
