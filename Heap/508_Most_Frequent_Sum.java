import java.util.*;

class Solution {
    PriorityQueue<int[]>pq = new PriorityQueue<>(
        (a,b) -> Integer.compare(b[1],a[1])
    );  
    Map<Integer,Integer>map = new HashMap<>();
    
    public int[] findFrequentTreeSum(TreeNode root) {        
        if(root==null)return new int[0];

        buildMap(root);
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int[] tmp = new int[]{entry.getKey(),entry.getValue()};
            pq.offer(tmp);
        }
        List<int[]>list = new ArrayList<>();
        list.add(pq.poll());
        while(pq.size()>0 && pq.peek()[1]==list.get(0)[1])
            list.add(pq.poll());
        
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i)[0];
        return res;        
    }
    // DFS find sum
    private int findSum(TreeNode root){
        if(root==null)return 0;
        int sum = 0;
        sum+= root.val;
        sum+=findSum(root.left);
        sum+=findSum(root.right);
        return sum;        
    }
    // Construct memoization map
    private void buildMap(TreeNode root){
        if(root==null)return;
        int a = findSum(root);
        map.put(a,map.getOrDefault(a,0)+1);
        buildMap(root.left);
        buildMap(root.right);
    }
}