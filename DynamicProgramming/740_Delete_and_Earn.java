class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] dp = new int[n];
                
        for(int i : nums)
            dp[i] += i;

        int skip = 0, take = 0;
        
        for(int i = 0; i < n; i++){
            int take_i = dp[i]+skip; 
            int skip_i = Math.max(skip,take);
            skip = skip_i;
            take = take_i;
        }
        
        return Math.max(skip,take);
    }
}
