class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        //return quadratic(nums,k);
        return mapping(nums,k);
    }
    
    private boolean quadratic(int[]nums, int k){
        while(k > 0){
            for(int i = 0; i+k < nums.length; i++){
                if(nums[i]==nums[i+k])
                    return true;
            }
            k--;
        }
        return false;
    }
    
    private boolean mapping(int[]nums, int k){
        Map<Integer,Integer>map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i]) && (i-map.get(nums[i]))<= k)
                return true;
                
            map.put(nums[i],i);
        }
        return false;
    }
    
}

/**

        Set<Integer>set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.clear();
            for(int j = i; j < nums.length; j++){
                if(set.size() >= k)
                    break;
                if(!set.add(nums[j]))
                   return false;
            }
        }
        return true;
**/
