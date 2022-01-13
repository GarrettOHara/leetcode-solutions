class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1) 
            if(nums[0] <= n-1)
                return false;
            else
                return true;
        // if(n==1) return nums[0]>=n;
        // if(n==2) return Math.max(nums[0]-1,nums[1])>=n;
        
        int[] dp = new int[n+1];
        
        dp[0] = nums[0];
        
        dp[1] = Math.max(dp[0]-1,dp[1]);
        
        for(int i = 2; i < n; i++){
            int a = dp[i-1], b = nums[i];
            if(a==0 && b==0)
                return false;
        
         //   dp[i] = Math.max(dp[i-1]-1,nums[i]);
        }
        
        for(int i : dp)
            System.out.print(i + " ");
        
        return true;
    }
}
