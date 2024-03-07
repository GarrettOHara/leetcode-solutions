class Solution {
    public void moveZeroes(int[] nums) {
        if(nums==null || nums.length==0) return;
        int pos = 0;
        for(int i : nums){
            if(i!=0)nums[pos++]=i;
        }
        while(pos<nums.length)
            nums[pos++]=0;
    }
}

/**
        int count = 0, index = nums.length-1;
        int[] res = new int[index+1];
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==0){
                res[index]=0;
                index--;
            }
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i]!=0){
                System.out.println(nums[i]);
                res[count]=nums[i];
                count++;
            }
        }
        
        for(int i = 0; i < nums.length; i++)
            nums[i]=res[i];
            
    -------------------------------------------
    
    if(nums.length==1&&nums[0]==0)return;
        int zeros = 0;
        for(int i = 0; i < nums.length;i++){
            while(i<nums.length&&nums[i]==0){
                zeros++; i++;
            }
            nums[i-zeros]=nums[i];
            
        }
        for(int i = nums.length-1; i >nums.length-zeros-1; i--){
            nums[i] = 0;
        }
        
**/
