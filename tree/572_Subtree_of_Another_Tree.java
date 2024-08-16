import java.util.*;
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        
        return isSubtree(root.left,subRoot)
            || isSubtree(root.right,subRoot)
            || sametree(root,subRoot);
        
    }
    
    private boolean sametree(TreeNode root, TreeNode child){
        if(root==null && child == null) return true;
        if(root == null || child == null) return false;
        if(root.val != child.val) return false;
        return sametree(root.left,child.left) 
            && sametree(root.right,child.right);
        
    }
}
