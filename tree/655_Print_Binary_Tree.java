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
    int height = 0;
    public List<List<String>> printTree(TreeNode root) {
        /**
            find max hieght, this will be length of array:
                - height * 2 + 1
                
            root = length / 2
            
            TreeNode = root.left, index = index - 1
            TreeNode = root.right, index = index + 1
            
        **/
        List<List<String>> tree = new ArrayList<>();
        int height = (root==null) ? 1 : find_height(root,1);
        int rows = height; 
        int cols = (int)(Math.pow(2, height) - 1);
        
        List<String> row = new ArrayList<>();
        for(int i = 0; i < cols; i++) row.add("");
        for(int i = 0; i < rows; i++) tree.add(new ArrayList<>(row));
        
        
        build_tree(root, tree, 0, rows, 0, cols);
        
        return tree;
    }
    
    private int find_height(TreeNode root, int index) {
        if(root == null) return index;
        
        height = Math.max(height, index);
        
        find_height(root.left, index+1);
        find_height(root.right,index+1);
        
        return height;
    }
    
    public void build_tree(TreeNode root, List<List<String>> res, int row, int totalRows, int i, int j) {
        
        if (row == totalRows || root == null)
            return;
        
        res.get(row).set((i+j)/2, Integer.toString(root.val));
        
        
        build_tree(root.left,  res, row+1, totalRows, i,        (i+j)/2 - 1);
        build_tree(root.right, res, row+1, totalRows, (i+j)/2+1, j);
    }
}


/***


class Solution {
    int height = 0;
    public List<List<String>> printTree(TreeNode root) {
        //
        //    find max hieght, this will be length of array:
        //        - height * 2 + 1
        //        
        //    root = length / 2
        //    
        //    TreeNode = root.left, index = index - 1
        //    TreeNode = root.right, index = index + 1
        //    
        //
        
        int height = find_height(root,0);
        
        List<String[]> tree = new ArrayList<>();
        tree.add(new String[(height*2+1)]);
        System.out.println(height);
        //System.out.println(tree.size() + " " + tree.get(0).size() + " " + (height*2+1));
        
        build_tree(tree, root, height/2, height);
        
        List<List<String>> res = new ArrayList<>();
        
        for(int i = 0; i < tree.size(); i++){
            res.add(new ArrayList<>());
            for(int j = 0; j < tree.get(i).length; j++){
                System.out.println(tree.get(i)[j]);
                res.get(i).add(tree.get(i)[j]);
            }
        }
        
        return res;
    }
    
    private int find_height(TreeNode root, int index) {
        if(root == null) return index;
        
        height = Math.max(height, index);
        
        find_height(root.left, index+1);
        find_height(root.right,index+1);
        
        return height;
    }
    
    private void build_tree(List<String[]> tree, TreeNode root, int current, int height){
        if(root==null) return;
        
        int row   = height - current;
        
        if(row >= tree.size())
            tree.add(new String[(height*2+1)]);
        
        System.out.println(root.val + " " + current);
        
        tree.get(row)[current] = Integer.toString(root.val);
        
        build_tree(tree, root.left,  current-1, height);
        build_tree(tree, root.right, current+1, height);
        
        return;
        
        
    }
}

***/
