class Solution {
    public int search(int[] nums, int target) {
        return bs(nums,target,0,nums.length-1);
    }
    private int bs(int[]nums, int target, int lo, int hi){
        if(hi>=lo){
            int mid = lo + (hi-lo)/2;
            
            if(nums[mid]==target) return mid;
            
            if(target<nums[mid])
                return bs(nums, target, lo, mid-1);
            return bs(nums, target, mid+1, hi);
        }
        return -1;
    }
}


/**
    private int helper(int[] nums, int target, int lo, int hi){
        if(lo>=hi)return -1;
        if(nums[hi-lo]==target)return hi-lo;
        if(nums[hi-lo]>target)
            helper(nums, target, lo*2+1, hi);
        else
            helper(nums, target, lo, hi/2);
        return -1;
    }
    
    private int helper(int[] nums, int target, int lo, int hi){
        if(hi>=lo){
            int mid = lo + (hi-lo) / 2;
            
            if(nums[mid]==target)
                return mid;
            
            if(nums[mid]<target)
                return helper(nums, target, mid+1, hi);
            
            return helper(nums,target,lo,mid-1);
        }
        return -1;
    }
**/
