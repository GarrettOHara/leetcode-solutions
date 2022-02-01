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
    int level = 0, parent = 0;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)return false;
        
        int[] a = new int[2];
        int[] b = new int[2];
        
        DFS(root, x, 0, root.val);
        a[0] = level; a[1] = parent;
        
        DFS(root, y, 0, root.val);
        b[0] = level; b[1] = parent;
        
//         for(int i : a)
//             System.out.println(i);
//         System.out.println();
//         for(int i : b)
//             System.out.println(i);
        
        return a[0]==b[0] && a[1]!=b[1];
    }
    
    private void DFS(TreeNode root, int target, int thislevel, int thisparent){
        if(root==null)return;
        
        if(root.val==target){
            level = thislevel;
            parent = thisparent;
        }
        
        DFS(root.left, target, thislevel+1, root.val);
        DFS(root.right, target, thislevel+1, root.val);
        
        return;
    }
}
