class Solution {
    public int numWays(int steps, int arrLen) {
        int maxPosition = Math.min(steps / 2 + 1, arrLen);
        int[] curWays = new int[maxPosition + 2];
        int[] nextWays = new int[maxPosition + 2];
        curWays[1] = 1;
        int mod = 1000000007;

        while (steps > 0) {
            for (int pos = 1; pos <= maxPosition; pos++) {
                nextWays[pos] = (int)(((long)curWays[pos] + curWays[pos - 1] + curWays[pos + 1]) % mod);
            }

            int[] temp = curWays;
            curWays = nextWays;
            nextWays = temp;
            steps--;
        }

        return curWays[1];        
    }
}
