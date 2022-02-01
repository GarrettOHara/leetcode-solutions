// EACH CLASS IS A DIFFERENT DFS APPROACH TO THE QUESTION
// MY ORIGINAL SOLUTION WAS THE SLOWEST AND IS SOLUTIONC

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
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        
        helper(root,list,0);
            
        return list;
    }
    
    private void helper(TreeNode root, List<Integer> list, int k){
        
        if(root==null) 
            return;
        
        if(list.size() == k) 
            list.add(root.val);
        
        else
            list.set(k,Math.max(list.get(k),root.val));
        
        
        helper(root.left,list,k+1);
        helper(root.right,list,k+1);
        
        return;
        
    }
}
class SolutionB {
    
    // int depth=0;
    
    // ArrayList<Integer> track= new ArrayList();
    
    ArrayList<List<Integer>> res = new ArrayList();
    
    public List<Integer> largestValues(TreeNode root) {
     
        if(root==null) return new ArrayList();
        
        this.traverse(root,0);
        
        ArrayList<Integer> result = new ArrayList();
        
        for(List<Integer> list: res){
            Collections.sort(list);
            
            result.add(list.get(list.size()-1));
            
        }
        
        return result;
    }
    
    public void traverse(TreeNode node, int depth){
        
        if(node==null) return;
        
        //preorder
        
        if(res.size()==depth) {
            
            res.add(new ArrayList<Integer>());
            
        }
        
        res.get(depth).add(node.val);
        
        this.traverse(node.left, depth+1);
        this.traverse(node.right, depth+1);
        
    }
    
}
class SolutionC {
    List<Integer>list = new LinkedList<>();
    Map<Integer,Integer>map = new HashMap<>();
    
    public List<Integer> largestValues(TreeNode root) {
        if(root==null)
            return Collections.emptyList();
        
        if(root.left==null && root.right==null)
            return Collections.singletonList(root.val);
        
        DFS(root, 0);
        
        for(int val : map.values()){
            list.add(val);
        }
        
        return list;
    }
    
    private void DFS(TreeNode root, int level){
        if(root==null)
            return;
        
        if(map.getOrDefault(level,Integer.MIN_VALUE)<=root.val)
            map.put(level,root.val);
        
        DFS(root.left,level+1);
        DFS(root.right,level+1);
        
        return;
    }
}
