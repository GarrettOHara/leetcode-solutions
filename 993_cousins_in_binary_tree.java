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
class Recursive_Solution {
    TreeNode xNode, yNode;
    int xHeight, yHeight;
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) 
            return false;
        
        helper(root,x,y,null,0);
        
        if(xHeight == yHeight && xNode != yNode)
            return true;
        return false;
    }
    
    private boolean helper(TreeNode root, int x, int y, TreeNode parent, int height){
        if(root==null) return false;
        
        if(root.val == x){
            xNode = parent;
            xHeight = height;
        } 
        else if(root.val == y){
            yNode = parent;
            yHeight = height;
        }
        
        helper(root.left,x,y,root,height+1);
        helper(root.right,x,y,root,height+1);
        
        return false;
    }
}

class Iterative_Solution{
 public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null)return false;
        Queue<TreeNode> q = new LinkedList<>();
        int xheight = -1;
        int yheight = -2;
        int height = 0;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode tmp = q.remove();
                if(tmp.left!=null && tmp.right!=null){
                    if(tmp.left.val==x&&tmp.right.val==y)
                        return false;
                    if(tmp.left.val==y&&tmp.right.val==x)
                        return false;
                }
                
                if(tmp.val==x)xheight = height;
                if(tmp.val==y)yheight = height;
                if(tmp.left!=null)q.add(tmp.left);
                if(tmp.right!=null)q.add(tmp.right);
                
            }
            height++;
        }
        return xheight==yheight;
    }
}

