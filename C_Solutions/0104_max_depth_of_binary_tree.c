/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

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

// #############################################################
// or we can do this
int max2(int a, int b) {
    return (a > b) ? a : b;
}

int maxDepth2(struct TreeNode* root) {
    if (root==NULL) return 0;

    int left = maxDepth(root->left);
    int right = maxDepth(root->right);

    return max(left, right)+1;
}
