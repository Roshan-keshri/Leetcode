class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int idx1=text1.length();
        int idx2=text2.length();
        int dp[][]=new int [idx1][idx2];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return findlen(text1, text2, idx1-1, idx2-1, dp);
    }
    public int findlen(String text1, String text2, int idx1, int idx2, int dp[][]){
        if(idx1<0  || idx2 < 0){
            return 0;
        }
        if(dp[idx1][idx2]!=-1)return dp[idx1][idx2];
        if(text1.charAt(idx1)==text2.charAt(idx2)){
            return dp[idx1][idx2]=1+findlen(text1, text2, idx1-1, idx2-1, dp);
        }
       return dp[idx1][idx2]=Math.max(findlen(text1, text2, idx1-1,idx2,dp), findlen(text1, text2, idx1, idx2-1, dp));

    }
}