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
    int res = 0;
    public int findTilt(TreeNode root) {
        dfs(root);
        return res;        
    }
    
    public int dfs(TreeNode root){
        if(root==null) return 0;
        
        int left  = dfs(root.left);
        int right = dfs(root.right);
        
        res += Math.abs(left - right);
        
        return left + right + root.val;
    }
}

/**
public int dfs(TreeNode root, int sum){
        if(root==null) return sum;
        
        int left = 0, right = 0;
        if(root.left != null)
            left = root.left.val;
        if(root.right != null)
            right = root.right.val;
        root.val = Math.abs(left - right);
        System.out.print(root.val+" ");
        sum += root.val;
        
        findTilt(root.left);
        findTilt(root.right);
        
        return sum;
    }
**/
