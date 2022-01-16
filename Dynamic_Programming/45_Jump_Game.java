class Solution {
    public int jump(int[] nums) {
        int reach = 0;
        int jump = 0;
        int curr = 0;
        for(int i = 0; i < nums.length-1; i++){
            
            reach = Math.max(reach, i+nums[i]);
            
            if(i == curr){
                jump++;
                curr = reach;
            }
        }
        return jump;
    }
}
