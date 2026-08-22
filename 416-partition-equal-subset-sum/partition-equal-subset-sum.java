class Solution {
    public boolean canPartition(int[] nums) {
        int k=0;
        for(int i=0;i<nums.length;i++){
            k += nums[i];
        }
        if(k%2 != 0)return false;
        k=k/2;
        int dp[][]=new int[nums.length][k+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return checknum(nums, dp, nums.length-1, k);
    }
    public boolean checknum(int nums[], int dp[][], int n, int k){
        if(k==0)return true;
        if(n==0)return nums[0]==k;
        if(dp[n][k]!=-1){
            return dp[n][k]==1;
        }
        boolean nottake=checknum(nums, dp, n-1,k);
        boolean take = false;
        if(nums[n]<k){
            take=checknum(nums, dp, n-1, k-nums[n]);
        }
        boolean ans = take || nottake;
        dp[n][k] = ans ? 1 : 0;
        return ans;
    }
}