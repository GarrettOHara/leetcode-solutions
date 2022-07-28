class Quadratic {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i!=j && nums[i]+nums[j]==target)
                    return new int[]{i,j};
            }
        }
        return new int[]{};
    }
}

class Hashing {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            
            int val = target-nums[i];
            if(map.containsKey(val) && i != map.get(val)){
                res[0] = i;
                res[1] = map.get(val);
            } else {
                map.put(nums[i],i);
            }
        }
        return res;
    }
    
    public int[] twoSum_twoPass(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++)
            map.putIfAbsent(nums[i],i);
        
        for(int i = 0; i < nums.length; i++){
            int val = target-nums[i];
            if(map.containsKey(val) && map.get(val) != i){
                res[0] = i;
                res[1] = map.get(val);
            }
        }
        return res;
    }
}
