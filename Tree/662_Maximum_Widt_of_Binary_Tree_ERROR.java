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

    HashMap<Integer,int[]>map = new HashMap<>();

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;

        findMax(root,0,0);

        int res = 1;
        for(int[] arr : map.values())
            res = Math.max(res,arr[1]-arr[0] + 1);

        return res;
    }

    private void findMax(TreeNode root, int level, int position){
        if(root==null) return;

        int[] arr = map.get(level);
        if(arr==null){
            arr = new int[2];
            arr[0] = Integer.MAX_VALUE;
            arr[1] = Integer.MIN_VALUE;

        }
        arr[0] = Math.min(arr[0],position);
        arr[1] = Math.max(arr[1],position);

        map.put(level,arr);


        findMax(root.left,  level + 1, 2*position);
        findMax(root.right, level + 1, 2*position+1);
    }
}


/**


 BREADTH FIRST SEARCH COUNT SIZE OF Q

        if(root==null) return 0;

        return bfs(root);
    }
    private int bfs(TreeNode root){
        Queue<TreeNode>queue = new LinkedList<>();
        queue.offer(root);
        int size = 0;
        while(!queue.isEmpty()){
            // size = Math.max(size,queue.size());
            // TreeNode curr = queue.poll();
            // queue.remove();

            int size = queue.size();

            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(i==0)
                    min = curr.val;
                if(i==size-1)
                    max = curr.val;
                if(curr!=null && curr.val)
            }

            if(curr.left!=null)
                queue.add(root.left);
            if(curr.right!=null)
                queue.add(root.right);

            System.out.println(size);

        }

        return size;


**/
