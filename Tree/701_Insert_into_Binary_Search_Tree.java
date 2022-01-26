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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        TreeNode tmp = root;
        insert(root, val);
        return tmp;
    }
    
    private void insert(TreeNode root, int val){            
        if(root.val<val){
            if(root.right==null){
                TreeNode curr = new TreeNode(val);
                root.right = curr;
            } else {
                insertIntoBST(root.right, val);
            }
        } else {
            if(root.left==null){
                TreeNode curr = new TreeNode(val);
                root.left = curr;
            } else {
                insertIntoBST(root.left, val);
            }
        }
        return;
    }
}
