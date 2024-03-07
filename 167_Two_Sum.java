class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null || numbers.length<2)return new int[0];
        
        int i = 0, j = numbers.length-1;
        
        while(i<j){
            if(numbers[i]+numbers[j]==target)return new int[]{i+1,j+1};
            
            else if(numbers[i]+numbers[j]<target)
                i++;
            else
                j--;
        }
        return new int[0];
    }
}

/**
------------------------------------------------------------------
NOT UTALIZING THAT NUMBERS ARE SORTED:

    Map<Integer, Integer> map = new HashMap<>();

    for(int i=0;i<numbers.length;i++)
        map.put(numbers[i], i);

    for(int i = 0; i < numbers.length; i++){
        if(map.containsKey(target-numbers[i]))
            return new int[]{i+1,map.get(target-numbers[i])+1};
    }

    return new int[0];
------------------------------------------------------------------
**/


class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            int comp = target-nums[i];
            if(map.containsKey(comp) && i!=map.get(comp)){
                res[0]=i;
                res[1]=map.get(comp);
                break;
            } else
                map.put(nums[i],i);
        }
        return res;
    }
}

/*
Quadratic solution

int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j=0;j<nums.length;j++){
                if(j==i)
                    continue;
                else if(nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return res;

Better approach

HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i],i);
        for(int i = 0; i < nums.length; i++){
            int find = target-nums[i];
            if(map.containsKey(find) && map.get(find)!=i){
                int res = map.get(find);
                // if(i==res) continue;
                return new int[]{i,res};
            }
        }
        return new int[]{};


Optimal Solution | concurrent

int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            int comp = target-nums[i];
            if(map.containsKey(comp) && i!=map.get(comp)){
                res[0]=i;
                res[1]=map.get(comp);
                break;
            } else
                map.put(nums[i],i);
        }
        return res;
*/
