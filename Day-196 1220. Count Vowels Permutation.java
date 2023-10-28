class Solution {
    static int MOD=1000000007;
    public static long calc(int currsize,char prev,int n,int dp[][]){
        if(currsize==n) {
            return 1L;
        }
        if(dp[currsize][prev]!=-1) return dp[currsize][prev];
        // lets check if we can use characters
        long call=0;
        // a
        if(prev=='e' || prev=='u') call+= calc(currsize+1,'a',n,dp)%MOD;
        // e
        if(prev=='a') call+= calc(currsize+1,'e',n,dp)%MOD;
        // i
        if(prev=='e' || prev=='o') call+= calc(currsize+1,'i',n,dp)%MOD;
        // u
        if(prev=='o') call+= calc(currsize+1,'u',n,dp)%MOD;
        if(prev=='i') {
            call=call%MOD+calc(currsize+1,'a',n,dp);
            call=call%MOD+calc(currsize+1,'e',n,dp);
            call=call%MOD+calc(currsize+1,'o',n,dp);
            call=call%MOD+calc(currsize+1,'u',n,dp);
        }
        return dp[currsize][prev]=(int)call;
    }
    public int countVowelPermutation(int n) {
         char arr[]={'a','e','i','o','u'};
         long ans=0;
         int dp[][] = new int[n+1][123];
         for(int rows[]:dp) Arrays.fill(rows,-1);
         for(int i=0;i<5;i++){
             ans=(ans%MOD+calc(1,arr[i],n,dp)%MOD)%MOD;
         }
         return (int)ans;
    }
}
