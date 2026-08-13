class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return findval(nums,nums.length-1,dp);
    }
    public int findval(int nums[],int n,int dp[]){
        if(n==0)return nums[n];
        if(n<0)return 0;
        if(dp[n]!=-1)return dp[n];
        int nottake=nums[n]+findval(nums,n-2,dp);
        int take=0+findval(nums,n-1,dp);
        return dp[n]=Math.max(nottake,take);
    }
}