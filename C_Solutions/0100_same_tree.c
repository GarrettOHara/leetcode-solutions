#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

/**
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false

Example 3:
Input: p = [1,2,1], q = [1,1,2]
Output: false

Constraints:
    The number of nodes in both trees is in the range [0, 100].
    -104 <= Node.val <= 104
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

bool isSameTree(struct TreeNode* p, struct TreeNode* q) {
    if (p == NULL && q == NULL) return true;
    if (p == NULL || q == NULL) return false;

    return p->val == q->val && isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
}

int main() {
    // Test Case 1: Same trees
    struct TreeNode* p1 = newNode(1);
    p1->left = newNode(2);
    p1->right = newNode(3);
    struct TreeNode* q1 = newNode(1);
    q1->left = newNode(2);
    q1->right = newNode(3);
    printf("Test Case 1: %s\n", isSameTree(p1, q1) ? "true" : "false");

    // Test Case 2: Different structure
    struct TreeNode* p2 = newNode(1);
    p2->left = newNode(2);
    struct TreeNode* q2 = newNode(1);
    q2->right = newNode(2);
    printf("Test Case 2: %s\n", isSameTree(p2, q2) ? "true" : "false");

    // Test Case 3: Different values
    struct TreeNode* p3 = newNode(1);
    p3->left = newNode(2);
    p3->right = newNode(1);
    struct TreeNode* q3 = newNode(1);
    q3->left = newNode(1);
    q3->right = newNode(2);
    printf("Test Case 3: %s\n", isSameTree(p3, q3) ? "true" : "false");

    return 0;
}
