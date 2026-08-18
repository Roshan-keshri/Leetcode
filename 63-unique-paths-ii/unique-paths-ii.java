class Solution {
    public int uniquePathsWithObstacles(int[][] og) {
        int n=og.length;
        int m=og[0].length;
        int dp[][]=new int [n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        if(n==1 && m==1 & og[n-1][m-1]==1)return 0;
        return findpath(n-1,m-1,dp, og);
    }
    public int findpath(int n, int m, int dp[][], int og[][]){
        if(n==0 && m==0 & og[n][m]!=1){
            return 1;
        }
        if(n<0 || m<0)return 0;
        if(og[n][m]==1)return 0;
        if(dp[n][m]!= -1){
            return dp[n][m];
        }
        int up=findpath(n-1,m,dp,og);
        int left=findpath(n,m-1,dp,og);
        return dp[n][m]=up+left;

    }
}