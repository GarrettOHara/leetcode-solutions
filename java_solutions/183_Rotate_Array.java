class Solution {
    public void rotate(int[] nums, int k) {
        int[] res = new int[nums.length];
        int pos = k % nums.length;
        int index = 0;
        
        for(int i = nums.length-pos; i < nums.length;i++){
            res[index]=nums[i];
            index++;
        }
        

        for(int i = 0; i < nums.length-pos; i++){
            res[index] = nums[i];
            index++;
        }
        
        for(int i = 0; i < nums.length; i++)
            nums[i]=res[i];
        
    }
}
    

/**
for(int i = count; i<nums.length; i++){
            res[i] = nums[count];
            index++;
        }
        System.out.println(count);
        for(int i = 0; i < count; i++){
            res[i] = nums[count];
            count++;
        }
        for(int i = 0; i < nums.length; i++)
            nums[i]=res[i];
    }
    **/
