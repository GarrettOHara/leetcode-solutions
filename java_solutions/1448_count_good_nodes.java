/**

Given a binary tree root, a node X in the tree is named good if in the path 
from root to X there are no nodes with a value greater than X.

Return the number of good nodes in the binary tree.


Example 1:

Input: root = [3,1,4,3,null,1,5]
Output: 4
Explanation: Nodes in blue are good.
Root Node (3) is always a good node.
Node 4 -> (3,4) is the maximum value in the path starting from the root.
Node 5 -> (3,4,5) is the maximum value in the path
Node 3 -> (3,1,3) is the maximum value in the path.

Example 2:

Input: root = [3,3,null,4,2]
Output: 3
Explanation: Node 2 -> (3, 3, 2) is not good, because "3" is higher than it.

Example 3:

Input: root = [1]
Output: 1
Explanation: Root is considered as good.


Constraints:

    The number of nodes in the binary tree is in the range [1, 10^5].
    Each node's value is between [-10^4, 10^4].
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
class Solution {
    private int good = 0;
    public int goodNodes(TreeNode root) {
        helper(root, root.val);

        return good;
    }

    private void helper(TreeNode root, int largestSeen) { 
        if (root == null) 
            return;

        if (root.val >= largestSeen) 
            good++;

        helper(root.left,  Math.max(root.val, largestSeen));
        helper(root.right, Math.max(root.val, largestSeen));
    }
}

/**
First Try:

class Solution {
    private int good = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;

        helper(root, root.val);

        return good;
    }

    private void helper(TreeNode root, int val) {
        if (root == null) return;

        if ( root.val >= val) {
            good++;
        } 

        helper(root.left, root.val);
        helper(root.right, root.val);
    }
}

*/

/*

Another solution 01/02/25

class Solution {
    private int good = 0;
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;

        helper(root, root.val);

        return good;
    }

    private void helper(TreeNode root, int largestSeen) {
        if (root == null) return;


        if (root.val >= largestSeen)
            good += 1;

        helper(root.left, Math.max(largestSeen, root.val));
        helper(root.right, Math.max(largestSeen, root.val));
    }
}
*/

/*
More solutions 04/22/25

class Solution {
    private int good = 0;

    public int goodNodes(TreeNode root) {
       // helper(root, root.val);
       // return good;

       return helper2(root, root.val);
    }

    private int helper2(TreeNode root, int largest) {
        if (root == null)
            return 0;

        int sum = 0;
        if (root.val >= largest) {
            largest = root.val;
            sum += 1;
        }

        sum += helper2(root.left, largest);
        sum += helper2(root.right, largest);

        return sum;
    }

    private void helper(TreeNode root, int largest) {
        if (root == null) {
            return;
        }

        if (root.val >= largest) {
            largest = root.val;
            good++;
        }

        helper(root.left, largest);
        helper(root.right, largest);
    }
}
*/
