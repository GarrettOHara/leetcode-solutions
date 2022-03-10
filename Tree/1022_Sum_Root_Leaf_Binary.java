import java.util.*;

class Solution {
    public int sumRootToLeaf(TreeNode root) {
        if(root==null)return 0;
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode root, int val){
        if(root==null)return 0;
        int sum = 0;
        
        val = val << 1 | root.val;
		if(root.left == null && root.right == null)
			return val;
        
        sum+=dfs(root.left, val);
        sum+=dfs(root.right, val);
        
        return sum;
    }
}
