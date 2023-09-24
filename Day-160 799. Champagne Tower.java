class Solution {
    private double solve(int poured, int query_row, int query_glass, Double[][] dp) {
        if(query_row < 0 || query_glass < 0 || query_row < query_glass) 
            return 0.0;
        if(query_row == 0 && query_glass == 0) return poured;
        if(dp[query_row][query_glass] != null) return dp[query_row][query_glass];
        double upperLeft = (solve(poured, query_row - 1, query_glass - 1, dp) - 1)/2.0;
        double upperRight = (solve(poured, query_row - 1, query_glass, dp) - 1)/2.0;

        return dp[query_row][query_glass] = (upperLeft < 0 ? 0 : upperLeft) + (upperRight < 0 ? 0 : upperRight);
    }
    public double champagneTower(int poured, int query_row, int query_glass) {
        Double[][] dp = new Double[query_row+1][query_glass+1];
        return Math.min(1.0, solve(poured, query_row, query_glass, dp));
    }
}
