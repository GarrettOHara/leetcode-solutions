ass Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>list = new ArrayList<>();
        backtrack(list,new ArrayList<Integer>(),candidates, target, 0);
        return list;
    }
    
    private void backtrack(List<List<Integer>>list, 
                           List<Integer>curr, int[]nums,int target, int start){
        
        if(target<0)
            return;
        
        else if(target==0)
            list.add(new ArrayList<>(curr));
        
//         if(IntStream.of(curr).sum()==target)
//             list.add(new ArrayList<>(curr));
        
//         int sum = 0;
//         for(int i : curr)
//             sum = sum + i;
        
//         if(sum==target)
//             list.add(new ArrayList<>(curr));
        
        for(int i = start; i < nums.length; i++){
            
            curr.add(nums[i]);

            /** DON'T INCREAMENT i WE CAN REUSE NUMBERS **/
            backtrack(list,curr,nums,target-nums[i],i);
            
            curr.remove(curr.size()-1);
        }
        return;
    }
}
