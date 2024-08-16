class Solution {
    int[] arr = {0,0};
    public int findBottomLeftValue(TreeNode root) {
        if(root.left == null && root.right == null) return root.val;
        DFS(root, 0);
        return arr[1];
    }
    
    private void DFS(TreeNode root, int level){
        if(root == null)
            return;
        
        if(level > arr[0]){
            arr[0] = level;
            arr[1] = root.val;
        }
        

        DFS(root.left, level+1);
        DFS(root.right,level+1);
        
         
        return;
    }
}
