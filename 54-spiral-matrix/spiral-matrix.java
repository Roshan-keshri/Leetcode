class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int sr=0;
        int er=matrix.length-1;
        int sc=0;
        int ec=matrix[0].length-1;
        ArrayList<Integer> ans=new ArrayList<>();
        while(sr <= er && sc <= ec){
        for (int i = sc; i <= ec; i++) {
            ans.add(matrix[sr][i]);
        }

        for (int j = sr + 1; j <= er; j++) {
            ans.add(matrix[j][ec]);
        }

        if (sr < er) {
            for (int i = ec - 1; i >= sc; i--) {
               ans.add(matrix[er][i]);
            }
        }

        if (sc < ec) {
            for (int j = er - 1; j >= sr + 1; j--) {
               ans.add(matrix[j][sc]);
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