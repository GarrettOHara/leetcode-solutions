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
