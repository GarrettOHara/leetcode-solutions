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
    public boolean flipEquiv(TreeNode a, TreeNode b) {
        if(a==null || b==null)
            return a==b;
        
        if(a.val != b.val) 
            return false;
        
        boolean same = flipEquiv(a.left, b.left) && flipEquiv(a.right,b.right);
        boolean diff = flipEquiv(a.left, b.right) && flipEquiv(a.right,b.left);
        
        return same || diff;
    }
}
