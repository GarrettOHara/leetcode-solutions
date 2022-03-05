import java.uutil.*;

class Solution {
    List<Integer>list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root==null)
            return  list;
        else {
            list.add(root.val);
            for(int i = 0; i < root.children.size(); i++){
                preorder(root.children.get(i));
            }
        }
        return list;
    }
}
