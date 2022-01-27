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
    
    Map<String, Integer>map = new HashMap<>();
    List<TreeNode>list = new LinkedList<>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map(root);
        return list;
    }
    
    private String map(TreeNode root){
        if(root == null) return "null";
        
        String L = map(root.left);
        String R = map(root.right);
        
        String curr = root.val + " " + L + " " + R;
        
        map.put(curr, map.getOrDefault(curr, 0)+1);
        
        if(map.get(curr)==2)
            list.add(root);
        
        return curr;
    }
}
