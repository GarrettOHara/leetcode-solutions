import java.util.*;
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
class DFS {
    List<List<Integer>> levels;
    public List<List<Integer>> levelOrder(TreeNode root) {
        levels = new ArrayList<>();
        dfs(root, 0);
        return levels;
    }
    
    private void dfs(TreeNode root, int level) {
        if(root==null)return;
        
        if(level > levels.size()-1)
            levels.add(new ArrayList<>());
        
        levels.get(level).add(root.val);
        
        dfs(root.left,  level+1);
        dfs(root.right, level+1);
        
        return;       
    }
}

class BFS {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        int level;
        TreeNode node;

        while(queue.size()>0){
            level = queue.size();
            List<Integer> tmp = new ArrayList<>();

            for(int i = 0 ; i < level ; i++) {
                node = queue.poll();
                tmp.add(node.val);
                if(node.left !=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }

            list.add(tmp);
        }
        return list;
    }
}
