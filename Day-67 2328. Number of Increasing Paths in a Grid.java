import java.util.Arrays;

class Solution {
    int mod = (int) Math.pow(10, 9) + 7;

    public int countPaths(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dp[i][j] == -1) {
                    helper(i, j, grid, dp, -1);
                }
            }
        }

        long pathSum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                pathSum = (pathSum + dp[i][j]) % mod;
            }
        }
        return (int) pathSum;
    }

    public int helper(int row, int col, int[][] grid, int[][] dp, int parent) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] <= parent) {
            return 0;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        int down = helper(row + 1, col, grid, dp, grid[row][col]) % mod;
        int up = helper(row - 1, col, grid, dp, grid[row][col]) % mod;
        int right = helper(row, col + 1, grid, dp, grid[row][col]) % mod;
        int left = helper(row, col - 1, grid, dp, grid[row][col]) % mod;

        return dp[row][col] = (down + up + right + left + 1) % mod;
    }
}
