class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer>map = new HashMap<>();
        map.put(0,1);
        int total = 0, sum = 0;
        for(int i : nums){
            
            sum+=i;
            
            if(map.containsKey(sum-k))
                total+=map.get(sum-k);
            
            map.put(sum,map.getOrDefault(sum,0)+1);
            
        }
        return total;
    }
}


/***

List<List<Integer>>sums = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        
        int sum = 0;
        int start_index = 0;
        for(int i = 0; i < nums.length; i++){
            
            while(sum>k && list.size()>0){
                list.remove(0);
                start_index++;
            }
            
            if(sum==k){
                start_index++;
                i = start_index;
                sums.add(list);
                list.clear();
                sum = 0;
            }
            sum+=nums[i];
            list.add(nums[i]);
            
        }
        return list.size();

***/
