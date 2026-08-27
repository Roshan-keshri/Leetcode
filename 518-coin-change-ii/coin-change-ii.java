class Solution {
    public int change(int amount, int[] coins) {
        int dp[][]=new int[coins.length][amount+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return findcount(coins, coins.length-1, amount, dp);
    }
    public int findcount(int coins[], int n, int amt, int dp[][]){
        if(n==0){
            int count=0;
            if(amt%coins[n]==0)return 1;
            return 0;
        }
        if(amt==0)return 1;
        if(dp[n][amt]!=-1)return dp[n][amt];
        int ntake=findcount(coins, n-1, amt, dp);
        int take = 0;
        if (coins[n] <= amt) {
            take = findcount(coins, n, amt - coins[n], dp);
        }      
        return dp[n][amt]=ntake+take;
    }
}