class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length,n=obstacleGrid[0].length;
        int dp[][]=new int[m][n];
        for(int i[]: dp)
        {
            Arrays.fill(i,-1);
        }
        return task(obstacleGrid,m-1,n-1,dp);
    }
    private int task(int grid[][], int i, int j, int dp[][])
    {
        if(i<0 || j<0 || grid[i][j]==1)
        {
            return 0;
        }
        if(i==0 && j==0)
        {
            return 1;
        }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        return dp[i][j] = task(grid,i-1,j,dp) + task(grid,i,j-1,dp);
    }
}