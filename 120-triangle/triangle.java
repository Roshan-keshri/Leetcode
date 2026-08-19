class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        Integer dp[][]=new Integer [n][n];
        return findpath(triangle, dp, 0, 0);
    }

    public int findpath(
        List<List<Integer>> triangle, Integer dp[][], int row,int col){
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        if (dp[row][col] != null) {
            return dp[row][col];
        }

        int down = findpath(triangle, dp, row + 1, col);
        int diagonal = findpath(triangle, dp, row + 1, col + 1);
        int min = triangle.get(row).get(col) + Math.min(down, diagonal);
        dp[row][col]=min;
        return min;
    }
}