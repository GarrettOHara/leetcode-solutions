/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        return dfs(root,0,0);
    }
    private int dfs(TreeNode root, int val, int sum){
        if(root==null)return sum;
        
        val=val*10+root.val;
        
        if(root.left==null && root.right==null)
            return sum+val;
        
        
        return dfs(root.left,val,sum)+dfs(root.right,val,sum);
        
    }
}


/**
MY ORIGINAL SLOW SOLUTION:

    int sum;
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        
        int[] nums = new int[1000];
        dfs(root, nums, 0);
        
        return sum;
    }
    private void dfs(TreeNode root, int[] nums, int index){
        if(root==null)return;
        
        nums[index]=root.val;
        index++;
        
        if(root.left==null && root.right==null){
            int[] pass = new int[index];
            System.arraycopy(nums,0,pass,0,index);
            addSum(pass);
        }
        
        dfs(root.left, nums, index);
        dfs(root.right, nums, index);
    }
    private void addSum(int[] nums){
        StringBuilder build = new StringBuilder();
        for(int i : nums){
            build.append(Integer.toString(i));
        }
        String res = build.toString();
        System.out.println(res);
        sum += Integer.parseInt(res);
    }
**/
