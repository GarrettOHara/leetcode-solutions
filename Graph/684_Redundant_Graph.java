import java.util.*;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        /**
        create graph as we add edges in
        for each one, traverse the graph
        
        keep a nodes visited set while traversing
        if we find that the nodes are already present when 
        we add in the new edge return that edge
        
        i.e. we were alredy able to traverse there
        **/
        
       /**
       create graph, dfs until current edge. if 
       visited already has both nodes then return current edge
       **/
        
        // ndoes, edges from that node
        Map<Integer,List<Integer>> graph = new HashMap<>();
        
        
        for(int[] arr : edges){
            // create tmp vars
            int a = arr[0], b = arr[1];
            
            // add new edge set to node if not present
            if(!graph.containsKey(a))
                graph.put(a,new ArrayList<>());
            if(!graph.containsKey(b))
                graph.put(b,new ArrayList<>());
            
            // add edges
            graph.get(a).add(b);
            graph.get(b).add(a);
            
            // create new visited set for traversal
            Set<Integer> visited = new HashSet<>();
            
            // traverse graph dfs from first node
            //for(Map.Entry<Integer,List<Integer>> entry : graph){
            dfs(graph, 1, visited);
            //}
            
            // found our redundant edge
            if(visited.contains(a) && visited.contains(b))
                return arr;
        }
        return new int[2];
    }
    
    public void dfs(Map<Integer,List<Integer>> graph, int node, Set<Integer> visited){
        if(!graph.containsKey(node)) return;// new int[2];
        
        if(visited.contains(node)) return;// new int[2];
        
        visited.add(node);
        
        for(int i : graph.get(node))
            dfs(graph, i, visited);
    }
}

/**
Detects deplicate edges... wrong

    Set<int[]> set = new HashSet<>();
    for(int[] arr : edges){
        if(!set.add(arr))
            return arr;
    }
    return new int[2];

Detects if redundant nodes are added
... wrong because graphs can be disjoint

        // we want to store the nodes that we can reach in a map
        // when we add a new edge that doesn't add a new desitnation
        // we return that edge
        // Set<Integer>set = new HashSet<>();
        // for(int[] arr : edges){
            int a = arr[0], b = arr[1];
            boolean added = false;
            if(set.add(a)) added = true;
            if(set.add(b)) added = true;
            if(!added)
                return arr;
        }
        return new int[2];
**/
