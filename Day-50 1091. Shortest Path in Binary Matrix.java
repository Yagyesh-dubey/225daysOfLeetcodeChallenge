class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,-1},{-1,1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 1});
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            if (cell[0] == n - 1 && cell[1] == n - 1) {
                return cell[2];
            }
            for (int[] dir : dirs) {
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                
                if (0 > x || x > n - 1 || 0 > y || y > n - 1 || visited[x][y] || grid[x][y] == 1) {
                    continue;
                }
                queue.add(new int[] {x, y, cell[2] + 1});
                visited[x][y] = true;
            }
        }
        return -1;
    }
}
