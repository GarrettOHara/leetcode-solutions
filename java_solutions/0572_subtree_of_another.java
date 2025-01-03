/**
Given the roots of two binary trees root and subRoot, return true if there is
a subtree of root with the same structure and node values of subRoot and false
otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and 
all of this node's descendants. The tree tree could also be considered as a 
subtree of itself.
 

Example 1:

Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:

Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false


Constraints:

    The number of nodes in the root tree is in the range [1, 2000].
    The number of nodes in the subRoot tree is in the range [1, 1000].
    -104 <= root.val <= 104
    -104 <= subRoot.val <= 104

**/
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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) 
            return true;
        if (root == null || subRoot == null)
            return false;

        return isSubtree(root.left, subRoot)  ||
               isSubtree(root.right, subRoot) ||
               helper(root, subRoot);
    }

    private boolean helper(TreeNode root, TreeNode sub) {
        if (root == null && sub == null) 
            return true;
        if (root == null || sub == null)
            return false;

        return root.val == sub.val && helper(root.left, sub.left) && helper(root.right, sub.right);
    }
}

/**
Also optimal

class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) 
            return true;
        if (root == null || subRoot == null)
            return false;


        if (helper(root, subRoot))
            return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean helper(TreeNode root, TreeNode sub) {
        if (root == null && sub == null) 
            return true;
        if (root == null || sub == null)
            return false;

        return root.val == sub.val && helper(root.left, sub.left) && helper(root.right, sub.right);
    }
}
**/
