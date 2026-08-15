class Solution {
    public int rob(int[] nums) {
                int n=nums.length;
        if(n==1)return nums[0];
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        int case1 = houserob(nums, dp, n - 1, 1);
        Arrays.fill(dp, -1);
        int case2 = houserob(nums, dp, n - 2, 0);
        return Math.max(case1, case2);
    }
    public int houserob(int nums[],int dp[], int n, int s){
        if(n<s){
            return 0;
        }
        if(n==s)return nums[n];
        if(dp[n]!=-1){
            return dp[n];
        }
        int take=nums[n] + houserob(nums,dp,n-2, s);
        int nottake= 0 + houserob(nums,dp, n-1,s);
        return dp[n]=Math.max(take,nottake);
    }
}