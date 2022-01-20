class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = nums[0];
        
        // Finding max_sum subarray     case_1 : [- - - + + + + - - -]
        int max = nums[0];
        int currmax = nums[0];
        
        // Finding min_sum subarray      case_2:  [+ + + - - - + + +]
        int min = nums[0];
        int currmin = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            total += nums[i];
            
            currmax = Math.max(nums[i],currmax+nums[i]);
            max = Math.max(currmax,max);
            
            currmin = Math.min(nums[i],currmin+nums[i]);
            min = Math.min(currmin, min);
        }
        
        if(max>0){
            return Math.max(max,total-min);
        }
        
        return max;
    }
}
