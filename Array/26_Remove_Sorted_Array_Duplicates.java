class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) 
            return 1;

        int unique = 1;

        for(int i = 0; i < nums.length-1; i++){ 
            if(nums[i] < nums[i+1]) {
                nums[unique] = nums[i+1];
                unique++;
            }
        }

        return unique;
    }
}


