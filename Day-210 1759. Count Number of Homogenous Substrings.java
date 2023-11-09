class Solution {
    static final long MOD = 1_000_000_007L;
    
    public int countHomogenous(String s) {
        int n = s.length();
        byte[] sc = new byte[n];
        s.getBytes(0, n, sc, 0);
        long result = 0;
        for (int idx = n - 1; idx >= 0; ) {
            int startIdx = idx;
            byte c = sc[idx--];
            while (idx >= 0 && sc[idx] == c)  idx--;
            result += ((long)(startIdx - idx) * (startIdx - idx + 1)) >> 1;
        }
        return (int)(result % MOD);
    }
}
