class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int [n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return findtpath(n-1, m-1, dp, grid);
        }
    public int findtpath(int n, int m, int dp[][], int grid[][]){
        if(n==0 && m==0){
            return grid[n][m];
        }
        if(n<0 || m<0){
            return Integer.MAX_VALUE;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        int up=findtpath(n-1, m, dp, grid);
        int left=findtpath(n, m-1, dp, grid);
        int max=Math.min(up,left);
        return dp[n][m]=grid[n][m]+max;
    }
}