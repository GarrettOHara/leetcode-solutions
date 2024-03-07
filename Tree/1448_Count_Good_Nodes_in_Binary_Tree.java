class Solution {
    public int goodNodes(TreeNode root) {
        return DFS(root, -10000);
    }
    
    private int DFS(TreeNode root, int good){
        if(root==null)
            return 0;
        
        int sum = 0;
        
        if(root.val>=good)
            sum++;
        
        sum+=DFS(root.right,Math.max(root.val,good));
        sum+=DFS(root.left ,Math.max(root.val,good));
        
        return sum;
    }
}
