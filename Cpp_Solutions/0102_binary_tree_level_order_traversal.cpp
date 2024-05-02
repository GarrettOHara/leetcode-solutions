#include <iostream>
#include <queue>
#include <vector>

using std::queue;
using std::vector;
using std::cout;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> result;
        if(root == NULL) return result;

        queue<TreeNode*> queue;
        queue.push(root);

        while(!queue.empty()) {
            int level = queue.size();
            vector<int> values;

            for(int i = 0; i < level; i++) {
                TreeNode *curr = queue.front();
                queue.pop();
                values.push_back(curr->val);

                if(curr->left != NULL) queue.push(curr->left);
                if(curr->right!= NULL) queue.push(curr->right);
            }
            result.push_back(values);
        }
        return result;
    }
};

int main() {
    // Create a binary tree (you need to define the tree according to your requirement)
    TreeNode* root = new TreeNode(3);
    root->left = new TreeNode(9);
    root->right = new TreeNode(20);
    root->right->left = new TreeNode(15);
    root->right->right = new TreeNode(7);

    // Create an instance of the Solution class
    Solution solution;

    // Call the levelOrder method and print the result
    vector<vector<int>> result = solution.levelOrder(root);
    for (const auto& level : result) {
        for (int val : level) {
            cout << val << " ";
        }
        cout << "\n";
    }

    // Don't forget to free the memory allocated for the tree nodes
    // (you may want to use a proper memory management strategy here)
    delete root->left;
    delete root->right->left;
    delete root->right->right;
    delete root->right;
    delete root;

    return 0;
}
