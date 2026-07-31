class Solution {
    public int fib(int n) {
         int dp[]=new int[n+1];
         return check(n,dp); 
    }
    public int check(int n, int dp[]){
        if(n<=1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        return dp[n]=check(n-1,dp)+check(n-2,dp);
    }
}