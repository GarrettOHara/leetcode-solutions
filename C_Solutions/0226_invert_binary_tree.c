#include <stdio.h>
#include <stdlib.h>

/**
Given the root of a binary tree, invert the tree, and return its root.

Example 1:
Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]

Example 2:
Input: root = [2,1,3]
Output: [2,3,1]

Example 3:
Input: root = []
Output: []

Constraints:
    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

**/

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

struct TreeNode* newNode(int val) {
    struct TreeNode* node = (struct TreeNode*) malloc(sizeof(struct TreeNode));
    node->val = val;
    node->left = NULL;
    node->right = NULL;
    return node;
}
void dfs(struct TreeNode* root) {
    if(root == NULL)
        return;

    struct TreeNode* tmp = root->left;
    root->left = root->right;
    root->right = tmp;

    dfs(root->left);
    dfs(root->right);

    return;
}
struct TreeNode* invertTreeA(struct TreeNode* root) {
   if (root == NULL) return root;

   struct TreeNode* node = newNode(root->val);
   node = root;

   dfs(root);

   return node; 
}

// Or we can define a function that does it all in 
// just a couple lines
struct TreeNode* invertTreeB(struct TreeNode* root) {
    if (root == NULL) 
        return NULL;

    struct TreeNode* left = invertTreeB(root->left);
    struct TreeNode* right = invertTreeB(root->right);

    root->left = right;
    root->right = left;

    return root;
}

// Function to print the tree in inorder traversal
void printInorder(struct TreeNode* node) {
    if (node == NULL) return;
    printInorder(node->left);
    printf("%d ", node->val);
    printInorder(node->right);
}
int main() {
    // Test case 1
    struct TreeNode* root1 = newNode(4);
    root1->left = newNode(2);
    root1->right = newNode(7);
    root1->left->left = newNode(1);
    root1->left->right = newNode(3);
    root1->right->left = newNode(6);
    root1->right->right = newNode(9);
    printf("Test Case 1:\nInput: ");
    printInorder(root1);
    printf("\nOutput: ");
    printf("\nInverting via invertTreeA\n");
    printInorder(invertTreeA(root1));
    //Invert tree back to run the other intert algorithm
    invertTreeA(root1);

    printf("\nInverting via invertTreeB\n");
    printInorder(invertTreeB(root1));
    printf("\n\n");

    // Test case 2
    struct TreeNode* root2 = newNode(2);
    root2->left = newNode(1);
    root2->right = newNode(3);
    printf("Test Case 2:\nInput: ");
    printInorder(root2);
    printf("\nOutput: ");
    printInorder(invertTreeA(root2));
    printf("\n\n");

    // Test case 3
    struct TreeNode* root3 = NULL;
    printf("Test Case 3:\nInput: ");
    printInorder(root3);
    printf("\nOutput: ");
    printInorder(invertTreeA(root3));
    printf("\n\n");

    return 0;
}
