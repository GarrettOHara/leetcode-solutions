import java.util.*;

class Solution {
    final int MAX_SIZE = 100;
    public Node cloneGraph(Node node) {
        return deep_copy_bfs(node);
//         if (node == null || node.neighbors == null) return node;

//         Node[] visited = new Node[MAX_SIZE+1];
//         Node copy = new Node(node.val);
//         deep_copy_dfs(node, copy, visited);
//         return copy;
    }

    // source https://leetcode.com/problems/clone-graph/discuss/1793436/Java-Simple-Code-With-Heavy-Comments-(No-HashMap)
    private Node deep_copy_dfs(Node node, Node copy, Node[] visited) {
        visited[copy.val] = copy;

        for(Node n : node.neighbors) {

            if(visited[n.val]==null){

                Node tmp = new Node(n.val);
                copy.neighbors.add(tmp);
                deep_copy_dfs(n, tmp, visited);

            } else
                copy.neighbors.add(visited[n.val]);

        }
        return copy;
    }

    // source https://leetcode.com/problems/clone-graph/discuss/42482/Java-BFS-solution
    private Node deep_copy_bfs(Node node) {
        if (node == null) return node;

        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));

        Queue<Node> q = new LinkedList<>();
        q.add(node);


        while(!q.isEmpty()) {
            Node temp = q.poll();

            for(Node n : temp.neighbors){
                if(!map.containsKey(n)){
                    map.put(n, new Node(n.val));
                    q.add(n);
                }
                map.get(temp).neighbors.add(map.get(n));
            }
        }
        return map.get(node);

    }
}


