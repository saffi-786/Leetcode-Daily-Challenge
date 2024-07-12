class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int i[]: dp)
        {
            Arrays.fill(i,-1);
        }
        return task(m-1,n-1,dp);
    }
    private int task(int i, int j, int dp[][])
    {
        if(i<0 || j<0)
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
        return dp[i][j] = task(i-1,j,dp) + task(i,j-1,dp);
    }
}