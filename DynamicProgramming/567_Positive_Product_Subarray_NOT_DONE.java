class Solution {
    public int getMaxLen(int[] nums) {
        int min = nums[0], max = nums[0], ans = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] < 0){
                int tmp = max;
                max = min; 
                min = tmp;
            }
            max = Math.max(nums[i]*max, nums[i]);
            min = Math.min(nums[i]*min, nums[i]);
            if(ans<max)
                ans = max;
        }
        if(ans>0)
            return ans;
        else
            return 0;
    }
}




/**

APPROACH 1

    int max = nums[0];
    int[] arr = new int[nums.length];

    for(int i = 1; i < nums.length; i++){
        arr[i] = Math.max(nums[i]*arr[i-1], nums[i]);

        if(max<arr[i])
            max = arr[i];
    }
    return max;
    
**/
