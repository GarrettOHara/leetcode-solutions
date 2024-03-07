class Solution {
    public int findPairs(int[] nums, int k) {
        // return quadratic(nums,k);
        
        // return mapping(nums,k);
        
        return binarySearch(nums,k);
    }
    
    private int binarySearch(int[]nums,int k){
        Set<Integer>set = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++){
            if(Arrays.binarySearch(nums, i+1, nums.length, nums[i]+k) > 0)
                set.add(nums[i]);
        }
        return set.size();
    }
    
    private int mapping(int[]nums,int k){
        int count = 0;
        Map<Integer,Integer>map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            
            if(k==0){
                
                if(entry.getValue()>=2)
                    count++;
                
            } else {
                
                if(map.containsKey(entry.getKey()+k))
                    count++;
            }
            
        }
        
        return count;
    }
    
    private int quadratic(int[]nums,int k){
        int count = 0;
        Set<Integer>set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(Math.abs(nums[i]-nums[j])==k && set.add(nums[i]+nums[j])){
                    count++;
                }
            }
        }
        
        return count;
    }
}
