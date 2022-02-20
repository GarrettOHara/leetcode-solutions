import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>>list = new ArrayList<>();
        
        Arrays.sort(arr);
        
        backtrack(list,new ArrayList<>(), arr, target, 0);
        
        return list;
    }
    
    private void backtrack(List<List<Integer>> list,List<Integer> curr,
                           int[]nums, int target, int start){
        if(target<0)
            return;
        
        else if(target==0)
            list.add(new ArrayList<Integer>(curr));
        
        else{
            for(int i = start; i < nums.length; i++){
                
                if(i > start && nums[i] == nums[i-1])
                    continue;

                curr.add(nums[i]);

                backtrack(list,curr,nums,target-nums[i],i+1);

                curr.remove(curr.size()-1);
            }
        }
        return;
    }
}
