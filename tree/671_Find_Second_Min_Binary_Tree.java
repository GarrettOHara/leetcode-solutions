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
    int min = Integer.MAX_VALUE;
    int second_min = Integer.MAX_VALUE;
    boolean found = false;
    public int findSecondMinimumValue(TreeNode root) {
        return dfs(root);
    }
    private int dfs(TreeNode root){
        if(root==null)return 0;
        if(root.val < min)
            min = root.val;
        if(root.val > min && root.val <= second_min){
            second_min = root.val;
            found = true;
        }
        dfs(root.left);
        dfs(root.right);
        return found ? second_min : -1;
    }
}

/**


    public int findSecondMinimumValue(TreeNode root) {
        int[]res = new int[1];
        res[0] = Integer.MAX_VALUE;
        dfs(root,root,res);
        return res[0]==root.val ? res[0] : -1;
    }
    private void dfs(TreeNode root, TreeNode child, int[] arr){
        if(root==null || child==null)return;
        if(root.val < arr[0])
            arr[0]=root.val;
        dfs(root,child.left,arr);
        dfs(root,child.right,arr);
    }


PriorityQueue<Integer>pq = new PriorityQueue();
        dfs(pq,root);
        if(pq.size()==0)return -1;
        int val = pq.poll();
        System.out.println(val);
        while(pq.size()>0 && pq.peek()==val)
            pq.poll();
        if(pq.isEmpty())
            return -1;
        else
            return pq.poll();
    }
    private void dfs(PriorityQueue<Integer>pq,TreeNode root){
        if(root==null)
            return;
        
        dfs(pq,root.left);
        pq.offer(root.val);
        dfs(pq,root.right);
    }
// traverse tree, use stack, pop off until different val
        Stack<Integer>stack = new Stack<>();
        dfs(stack,root);
        
    }
    private void dfs(Stack<Integer>stack,TreeNode root){
        if(root==null)return;
        dfs(stack,root.left);
        stack.push(root.val);
        if(stack.size()>1){
            int val = stack.pop();
            while((!stack.isEmpty())&&val==stack.peek())
                stack.pop();
            if(!stack.isEmpty())
                return stack.pop();
        }
        dfs(stack,root.right);
            int val = stack.pop();
            while((!stack.isEmpty())&&val==stack.peek())
                stack.pop();
            if(!stack.isEmpty())
                return stack.pop();
            else
                return -1;

**/

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
class SolutionB {
    int min = Integer.MAX_VALUE;
    int second_min = Integer.MAX_VALUE;
    boolean found = false;
    public int findSecondMinimumValue(TreeNode root) {
        return dfs(root);
    }
    private int dfs(TreeNode root){
        if(root==null)return 0;
        if(root.val < min)
            min = root.val;
        if(root.val > min && root.val <= second_min){
            second_min = root.val;
            found = true;
        }
        dfs(root.left);
        dfs(root.right);
        return found ? second_min : -1;
    }
}

/**
Queue<Integer> pq;
    public int findSecondMinimumValue(TreeNode root) {
        pq = new PriorityQueue<>( (a,b) -> Integer.compare(a,b) );
        dfs(root);
        pq.poll();
        return pq.size()==0 ? -1 : pq.peek();
    }

    private void dfs(TreeNode root) {
        if(root==null)return;

        if(pq.size() == 0 || pq.peek()!=root.val)
            pq.offer(root.val);

        dfs(root.left);
        dfs(root.right);

        return;
    }

---------
attempt at optimization failed


int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        return (b==a || b==Integer.MAX_VALUE) ? -1 : b;
    }

    private void dfs(TreeNode root) {
        if(root==null)return;

        if(a > root.val)
            a = root.val;
        else if(b > root.val && root.val != a)
            b = root.val;

        dfs(root.left);
        dfs(root.right);

        return;
    }

**/
