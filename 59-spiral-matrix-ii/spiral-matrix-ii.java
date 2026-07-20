class Solution {
    public int[][] generateMatrix(int n) {
        int ans[][]=new int[n][n];
        int val=1;
        int sr=0;
        int er=n-1;
        int sc=0;
        int ec=n-1;
        while(sr<=er && sc<=ec){
            for(int i=sc;i<=ec;i++){
                ans[sr][i]=val;
                val++;
            }
            for(int j=sr+1;j<=er;j++){
                ans[j][ec]=val;
                val++;
            }
            if(sr<er){
                for(int i=ec-1;i>=sc;i--){
                    ans[er][i]=val;
                    val++;
                }
            }
            if(sc<ec){
                for(int j=er-1;j>=sr+1;j--){
                    ans[j][sc]=val;
                    val++;
                }
            }
            sr++;
            sc++;
            er--;
            ec--;
        }
        return ans;
    }
}