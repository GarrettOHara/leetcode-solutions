class Solution {
    public int rob(int[] nums){
        // TWO POINTERS
        return pointers(nums);
        
        // TABULATION
        return tabulation(nums);
        
        // BRUTE FORCE
        return brute(nums,nums.length-1);
    }
    public int pointers(int[] nums) {
        int a = 0, b = 0;
        for(int num : nums){
            int tmp = a;
            a = Math.max(a,b+num);
            b=tmp;
        }
        return a;
    }
    private int tablulation(int[]nums){
        int n = nums.length;
        int[] dp = new int[n+1];
        
        dp[0]=0;dp[1]=nums[0];
        
        for(int i = 1; i < n; i++)
            dp[i+1] = Math.max(dp[i-1]+nums[i],dp[i]);
        
        return dp[n];
    }
    private int brute(int[] nums, int n){
        if(n<0)return 0;
        return Math.max(brute(nums,n-2)+nums[n], brute(nums,n-1));
    }
}
