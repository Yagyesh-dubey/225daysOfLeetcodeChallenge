class Solution {
    public boolean isMatching(int index,char[]s,char[]c){
        if(s.length-index < c.length) return false;
        for(int i=0;i<c.length;i++) {
            if(s[index+i] != c[i]) return false;
        }
        return true;
    }
    public boolean recFindWordBreak(int index,char[]s,char[][]c) {
        if(index == s.length) return true;
        boolean ans = false;
        for(int i=0;i<c.length;i++) {
            boolean isMatch = isMatching(index,s,c[i]);
            if(isMatch) {
                ans = ans | recFindWordBreak(index+c[i].length,s,c);
            }
        }
        return ans;
    }
    public boolean memoFindWordBreak(int index,char []s,char [][]c,int []dp) {
        if(index == s.length) return true;
        if(dp[index] != -1) return dp[index] == 1 ? true : false;
        boolean ans = false;
        for(int i=0;i<c.length;i++) {
            boolean isMatch = isMatching(index,s,c[i]);
            if(isMatch) {
                ans = ans | memoFindWordBreak(index+c[i].length,s,c,dp);
            }
            if(ans) break;
        } 
        dp[index] = ans ? 1 : 0;
        return ans;
    }
    public boolean dpFindWordBreak(char []s,char[][]c) {
        boolean []dp = new boolean[s.length+1];
        Arrays.fill(dp,false);
        dp[s.length] = true;
        for(int index=dp.length-2;index>=0;index--) {
            boolean ans = false;
            for(int i=0;i<c.length;i++) {
                boolean isMatch = isMatching(index,s,c[i]);
                if(isMatch) {
                    ans = ans | dp[index+c[i].length];
                }
                if(ans) break;
            }
            dp[index] = ans;
        }
        return dp[0];
    }
    public boolean wordBreak(String str1, List<String> wordDict) {
        char[][]c = new char[wordDict.size()][];
        char[]s = str1.toCharArray();
        int i=0;
        for(String str : wordDict) {
            c[i++] = str.toCharArray();
        }
        int []dp = new int[s.length];
        Arrays.fill(dp,-1);
        // return recFindWordBreak(0,s,c);    
        // return memoFindWordBreak(0,s,c,dp);
        return dpFindWordBreak(s,c);
    }
}
