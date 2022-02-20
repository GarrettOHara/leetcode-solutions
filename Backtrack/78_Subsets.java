class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>list = new ArrayList<>();
        backtrack(nums, new ArrayList<Integer>(), list, 0);
        
        return list;
    }
    
    private void backtrack(int[] nums, List<Integer>curr, List<List<Integer>>list, int start){
        list.add(new ArrayList<>(curr));
        for(int i = start; i < nums.length; i++){
            curr.add(nums[i]);
            backtrack(nums,curr,list,i+1);
            curr.remove(curr.size()-1);
        }
    }
}
