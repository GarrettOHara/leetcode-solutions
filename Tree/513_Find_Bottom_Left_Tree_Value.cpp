class Solution {
public:
    int arr[2] = {0,1};
    int findBottomLeftValue(TreeNode* root) {
        if(root->left==nullptr && root->right==nullptr)
            return root->val;
        
        DFS(root, 0);
        
        return arr[1];
    }
    
private:
    void DFS(TreeNode* root, int level){
        if(root == nullptr)
            return;
        
        if(level>arr[0]){
            arr[0]=level;
            arr[1]=root->val;
        }
        
        DFS(root->left, level+1);
        DFS(root->right, level+1);
        
        return;
    }
}; 
