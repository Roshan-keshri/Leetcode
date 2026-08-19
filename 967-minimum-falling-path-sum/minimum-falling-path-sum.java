class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        Integer dp[][]= new Integer[n][n];
        int min = Integer.MAX_VALUE;

        for (int col = 0; col < n; col++) {
           min = Math.min(min, findpath(matrix, dp, n - 1, col));
        }
        return min;
    }
    public int findpath(int matrix[][], Integer dp[][], int row, int col){
        if(row==0&& col>=0&&col<matrix.length){
            return matrix[row][col];
        }
        if(row<0||col<0||col>=matrix.length){
            return Integer.MAX_VALUE;
        }
        if(dp[row][col]!= null){
            return dp[row][col];
        }
        int up=findpath(matrix, dp, row-1,col);
        int ldia=findpath(matrix,dp,row-1,col-1);
        int rdia=findpath(matrix, dp, row-1, col+1);
        return dp[row][col]=matrix[row][col]+Math.min(up,Math.min(ldia,rdia));
    }
}