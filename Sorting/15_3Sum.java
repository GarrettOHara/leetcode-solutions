class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        
        Set<List<Integer>> res  = new HashSet<>();
        Arrays.sort(nums);
        
        // base case
        if(nums.length==0)
            return new ArrayList<>(res);
        
        for(int i=0; i<nums.length-2;i++){
            int j = i+1;
            int  k = nums.length-1;
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0)
                    res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if ( sum >0)
                    k--;
                else if (sum<0)
                    j++;
            }

        }
        return new ArrayList<>(res);

    }
        
}


/**

// Sort array of numbers
        // insert numbers as keys with array postion as index
        // two pointers on either side of list, while
        // lo < hi (index wise)
        // 
        // int res = - arr[lo] - arr[hi]
        // if(map.containsKey(res) && map.get(res) != lo && != hi)
        // LIST.add(new int[]{lo,hi,map.get(res)})
        
        // create data structs
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        
        // sort array for two pointer approach
        Arrays.sort(nums);
        
        // insert values into map with index occurances
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                List<Integer> tmp = map.get(nums[i]);
                tmp.add(i);
                map.put(nums[i],tmp);
            } else{
                map.put(nums[i],new ArrayList<>());
                map.get(nums[i]).add(i);
            }
        }
        
        int lo = 0, hi = nums.length-1;
        while(lo < hi){
            int num = -nums[lo] - nums[hi];
            
            // 3 sum exists, check indicies of occurance so no duplicates
            if(map.containsKey(num)){
                List<Integer> tmp = map.get(num);
                
                // if list at key has occurance that is not lo or hi, add to result
                for(int i = 0; i < tmp.size(); i++){
                    if(tmp.get(i) != lo && tmp.get(i) != hi){
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[lo],nums[hi],nums[tmp.get(i)])));
                        break;
                    }
                }
            }
                
            if(num > 0)
                hi--;
            else
                lo++;
            
        }
        
        return res;
    }

**/
