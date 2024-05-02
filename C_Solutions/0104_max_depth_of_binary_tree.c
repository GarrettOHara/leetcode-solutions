#include <stdio.h>
#include <stdlib.h>

/**
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: 3

Example 2:
Input: root = [1,null,2]
Output: 2

Constraints:
    The number of nodes in the tree is in the range [0, 104].
    -100 <= Node.val <= 100
**/
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

// Function to create a new TreeNode
struct TreeNode* newNode(int val) {
    struct TreeNode* node = (struct TreeNode*)malloc(sizeof(struct TreeNode));
    node->val = val;
    node->left = NULL;
    node->right = NULL;
    return node;
}

int max(int a, int b) {
    return (a > b) ? a : b;
}

int dfs(struct TreeNode* root, int level) {
    if (root == NULL) return level;
    level++;
    return max(dfs(root->left, level), dfs(root->right, level));
}

int maxDepth(struct TreeNode* root) {
   return dfs(root, 0);
}

// or we can do this
int maxDepth2(struct TreeNode* root) {
    if (root==NULL) return 0;

    int left = maxDepth(root->left);
    int right = maxDepth(root->right);

    return max(left, right)+1;
}

int main() {
    // Test Case 1: Full binary tree
    struct TreeNode* root1 = newNode(3);
    root1->left = newNode(9);
    root1->right = newNode(20);
    root1->right->left = newNode(15);
    root1->right->right = newNode(7);
    printf("Test Case 1: %d\n", maxDepth(root1)); // Output: 3

    // Test Case 2: Binary tree with right child only
    struct TreeNode* root2 = newNode(1);
    root2->right = newNode(2);
    printf("Test Case 2: %d\n", maxDepth(root2)); // Output: 2

    // Test Case 3: Empty tree
    struct TreeNode* root3 = NULL;
    printf("Test Case 3: %d\n", maxDepth(root3)); // Output: 0

    return 0;
}
