class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum +=nums[i];
        }
        int dp[][]=new int [nums.length][2*sum+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return findexp(nums, nums.length-1, target, dp,sum);
    }
    public int findexp(int nums[], int n, int tar, int dp[][],int sum){
        if(n==0){
             int count = 0;
            if (tar - nums[0] == 0) count++;
            if (tar + nums[0] == 0) count++;
            return count;
        }
         if (tar < -sum || tar > sum) return 0;
        if(dp[n][tar+sum]!=-1)return dp[n][tar+sum];
        int po=findexp(nums, n-1, tar-(1*nums[n]), dp,sum);
        int neg=findexp(nums, n-1, tar-(-1*nums[n]), dp,sum);
        return dp[n][tar+sum]=po+neg;
    }
}