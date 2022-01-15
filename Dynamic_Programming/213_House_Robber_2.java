class Solution {
    public int rob(int[] nums) {
        int n = nums.length; 
        if(n==0)return 0;
        if(n==1)return nums[0];
        if(n==2)return Math.max(nums[0], nums[1]);
        
        // TWO CASES: TAKE FIRST VALUE OR NOT
        int a = dp(nums,0,n-1);
        int b = dp(nums,1,n);
        
        // CONSTANT MEMORY SOLUTION
        int c = two_pointers(nums,0,n-1);
        int d = two_pointers(nums,1,n);
        
        // RETURN LARGEST OF TWO CASES
        return Math.max(a,b);
    }
    
    // TIME  COMPLEXITY O(n)
    // SPACE COMPLEXITY O(n)
    private int dp(int[]nums, int start, int end){     
        int[] vals = new int[end+1];
        
        vals[start] = nums[start];
        vals[start+1] = Math.max(nums[start],nums[start+1]);
        
        for(int i = start+2; i<end; i++)
            vals[i] = Math.max(vals[i-2]+nums[i],vals[i-1]);
        
        System.out.println(curr);
        System.out.println(next);
        System.out.println("------");
        
        return vals[end-1];
    }
    
    // TIME  COMPLEXITY O(n)
    // SPACE COMPLEXITY O(1)
    private int two_pointers(int[]nums,int start, int end){
        int curr = 0, next = 0;
        for(int i = start; i < end; i++){
            int tmp = next;
            next = Math.max(curr+nums[i], next);
            curr = tmp;
        }
        
        System.out.println(curr);
        System.out.println(next);
        System.out.println("------");
        
        return next;
    }
}
