class Solution {
    public int maxProduct(int[] nums) {
        
        // A
        // return approach_a(nums);
        
        // B
        return approach_b(nums);
    }
    
    private int approach_a(int[] nums){
        int min = nums[0], max = nums[0], ans = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i]<0){
                int tmp = max;
                max = min;
                min = tmp;
            }
            
            max = Math.max(nums[i],max*nums[i]);
            min = Math.min(nums[i],min*nums[i]);
            
            ans = Math.max(ans, max);
        }
        return ans;
    }
    
    private int approach_b(int[] nums){
        int min = nums[0], max = nums[0], ans = nums[0];
        int n = nums.length;
        
        for(int i = 1; i < n; i++){
            int tmp = max;
            
            max = Math.max(Math.max(nums[i]*max,nums[i]*min),nums[i]);
            min = Math.min(Math.min(nums[i]*tmp,nums[i]*min),nums[i]);
            
            if(max>ans)
                ans=max;
        }
        
        return ans;
    }
}


/**

ATTEMPT 1

class Solution {
    public int maxProduct(int[] nums) {
        
        // CASE 1: ODD NUMBER OF NEGATIVES
        int pos = maxsubarray(nums);
        
        // CASE 2: EVEN NUMBER OF NEGATIVES
        int abs = maxabsolute(nums);
        
        // RETURN GREATER OF THE TWO
        return Math.max(pos,abs);
    }
    
    
    private int maxsubarray(int[] nums){
        int max = nums[0];
        int[] arr = new int[nums.length+1];
        for(int i = 1; i < nums.length; i++){
            arr[i] = Math.max(arr[i-1]*nums[i], nums[i]);
            
            if(arr[i]>max)
                max=arr[i];
        }
        
        return arr[nums.length-1];
    }
    
    private int maxabsolute(int[] nums){
        int max = nums[0];
        int[] arr = new int[nums.length+1];
        
        for(int i = 1; i < nums.length; i++){
            arr[i] = Math.max(Math.abs(arr[i-1]*nums[i]), Math.abs(nums[i]));
        }
        
        return arr[nums.length-1];
    }
}

**/
