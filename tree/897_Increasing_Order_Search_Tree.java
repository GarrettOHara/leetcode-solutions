import java.util.*;


class Solution {
   public TreeNode increasingBST(TreeNode root) {
        /* OPTIMAL LINEAR SOLUTION */
        // return increasingBST(root, null);
       
        /* NON OPTIMAL SOLUTION */
        List<Integer>list = new ArrayList<>();
        dfs(list,root);
        Collections.sort(list);
        TreeNode tree = new TreeNode(list.get(0));
        TreeNode ptr = tree;
        for(int i = 1; i < list.size(); i++){
            tree.right = new TreeNode(list.get(i));
            tree = tree.right;
        }
        return ptr;
    }
    
    private void dfs(List<Integer>list, TreeNode root){
        if(root==null)return;
        list.add(root.val);
        dfs(list,root.left);
        dfs(list,root.right);
       
    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail) {
        if (root == null) return tail;
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }
}
