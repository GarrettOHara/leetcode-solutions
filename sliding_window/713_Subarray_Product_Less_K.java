class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int ptr = 0;
        for(int i = 0; i < nums.length; i++){
            ptr = i;
            
            int val = nums[i];
            if(val < k){
                count++;
                ptr++;
            }
            
            
            while(ptr < nums.length && val*nums[ptr] < k){
                val *= nums[ptr]; count++; ptr++;
            }
        }
        return count;
    }
}


/**

RUNTIME 13ms:

int n = nums.length;
        long p = 1l;
        int i = 0;
        int j = 0;
        int total = 0;
        while(j < n){
            p *= nums[j];
            while(i <= j&&p >= k){
                p /= nums[i];
                i++;
            }
            total += (j - i + 1);
            j++;
        }
        return total;
        
**/
