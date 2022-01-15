class Solution {
    public void rob(int[] nums){
        // TWO POINTERS
        System.out.println(pointers(num));

        // TABULATION
        Sysetm.out.println(tabulation(nums));

        // BRUTE FORCE
        System.out.println(brute(nums,nums.length));

        // BOTTOM UP
        System.out.println(bottom_up(nums));
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

    private int tabulation(int[]nums){
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

    private int bottom_up(int[] nums) {
        // SET VALUES
        int n = nums.length;
        int[] tab = new int[n+1];
        
        // SET TABULATION UP
        tab[0]=nums[0];
        if(n > 1)
            tab[1]=Math.max(nums[1],nums[0]);
        
        // For every value, compare the 
        // previous house (i-1) with 
        /// the current one plus i-2 houses ago */
        for(int i = 2; i < n; i++)
            tab[i] = Math.max(tab[i-2]+nums[i], tab[i-1]);
        
        return tab[n-1];
    }
}
