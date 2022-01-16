class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length+1];
        dp[0]=nums[0];
        
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            if(max<dp[i])
                max = dp[i];
        }
        
        return max;
    }
}
