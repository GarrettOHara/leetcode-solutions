class Solution {
    public int maxSubArray(int[] nums) {
        
        return kadane_algorithm(nums);
        
        // return dynamic_programming(nums);
				
				// return two_pointers(nums);
    }
    
    private int kadane_algorithm(int[] nums){
        int n = nums.length;
        int MAX = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            MAX = Math.max(sum,MAX);
            if(sum < 0) sum = 0;
        }
        return MAX;
    }
    
    private int dynmaic_programming(int[] nums){
        int n = nums.length;
        int[] tab = new int[n+1];
        tab[0] = nums[0];
        int max = tab[0];

        for(int i = 1; i < n; i++){
            tab[i] = Math.max(tab[i-1]+nums[i],nums[i]);
            System.out.println(tab[i]);
            if(tab[i]>max)
                max=tab[i];
        }
        return max;
    }

    private int two_pointers(int[] nums){
        int dp_a = nums[0];
        int dp_b = Integer.MIN_VALUE;
        int max = Math.max(dp_a,dp_b);
        for(int i = 1; i < nums.length; i++){
            dp_b = Math.max(dp_a+nums[i], nums[i]);
            dp_a = dp_b;
            max = Math.max(dp_b,max);
        }
        return max;
    }
}

