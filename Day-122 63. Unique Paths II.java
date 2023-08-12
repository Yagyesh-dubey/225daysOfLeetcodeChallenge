class Solution {

public int find(int i,int j,int m,int n,int[][] arr,int[][] dp){

    if(dp[i][j]!=-1)
        return dp[i][j];
		
    if(arr[i][j] ==1 && i==m-1 && j==n-1)
        return 0;
		
    if(i==m-1 && j==n-1)
        return 1;
    
    int l=0;
    int r=0;
    
    if(j+1<n && arr[i][j+1]!=1)
        l = find(i,j+1,m,n,arr,dp);
    if(i+1<m && arr[i+1][j]!=1)
        r = find(i+1,j,m,n,arr,dp);
    return dp[i][j] = l+r;
    
}

public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
    for(int[] i:dp){
        Arrays.fill(i,-1);
    }
    if(obstacleGrid[0][0]==1) return 0;
    return find(0,0,obstacleGrid.length,obstacleGrid[0].length,obstacleGrid,dp);
}
}
