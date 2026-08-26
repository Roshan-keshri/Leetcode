class Solution {

    public int coinChange(int[] coins, int amount) {

        int[][] dp = new int[coins.length][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = findcoin(coins, coins.length - 1, amount, dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int findcoin(int[] coins, int n, int amt, int[][] dp) {
        if (n == 0) {
            if (amt % coins[0] == 0)
                return amt / coins[0];
            else
                return Integer.MAX_VALUE;
        }
        if (dp[n][amt] != -1)
            return dp[n][amt];
        int ntake = findcoin(coins, n - 1, amt, dp);
        int take = Integer.MAX_VALUE;
        if (coins[n] <= amt) {
            int result = findcoin(coins, n, amt - coins[n], dp);
            if (result != Integer.MAX_VALUE) {
                take = 1 + result;
            }
        }
        return dp[n][amt] = Math.min(take, ntake);
    }
}