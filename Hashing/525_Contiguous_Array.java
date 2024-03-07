class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer>map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i]==0)nums[i]=-1;
        }
        map.put(0,-1);
        int sum = 0;
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            sum+=nums[i];
            if(map.containsKey(sum))
                max = Math.max(max, i - map.get(sum));
            else 
                map.put(sum,i);
            
        }
        return max;
    }
}

/**

int[] tab = new int[nums.length+1];
        tab[0] = 0;
        int size = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i]!=nums[i-1]){
                System.out.println("yes");
                size++;
            } else 
                size = 1;
            System.out.println(size);
            tab[i] = Math.max(tab[i-1],size);
        }
        
        return tab[nums.length-1];

**/
