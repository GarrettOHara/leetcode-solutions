import java.util.*;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[2001];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        
        for (int[] edge: edges){
            int f = edge[0], t = edge[1];
            if (find(parent, f) == find(parent, t)) return edge;
            else parent[find(parent, f)] = find(parent, t);
        }
        
        return new int[2];
    }
    
    private int find(int[] parent, int f) {
        if (f != parent[f]) {
          parent[f] = find(parent, parent[f]);  
        }
        return parent[f];
    }
}


/**
NOTES

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


    /** 
     * dfs -> reachable, if new edge has nodes with both reachable then 
     * ... if we have multiple subgraphs make a set of set...
**/
        


/** 
LATEST ATTEMPT, TIME LIMIT EXCEEDED

// ndoes, edges from that node
        Map<Integer,List<Integer>> graph = new HashMap<>();
        int[] tmp = edges[0];
        int x = tmp[0], y = tmp[1];
        
        // add new edge set to node if not present
        graph.put(x,new ArrayList<>());
        graph.put(y,new ArrayList<>());

        // add edges
        graph.get(x).add(y);
        graph.get(y).add(x);
        
        
        for(int i = 1; i < edges.length; i++){
            
            // create tmp vars
            int[] arr = edges[i];
            int a = arr[0], b = arr[1];
            
            // create master set to store all subgraphs
            Set<Set<Integer>> master = new HashSet<>();
            
            for(Map.Entry<Integer, List<Integer>> entry : graph.entrySet()){
                
                // create new visited set for traversal of single subgraph
                Set<Integer> visited = new HashSet<>();
                
                int index = entry.getKey();
                
                master.add(dfs(graph, index, visited));
            }
            
            
            // redundant edge, return
            for(Set<Integer> visited : master){
                if(visited.contains(a) && visited.contains(b))
                    return arr;
            }
            
            // else, insert node into graph
            if(!graph.containsKey(a))
                graph.put(a,new ArrayList<>());
            if(!graph.containsKey(b))
                graph.put(b,new ArrayList<>());
            
            // add edges
            graph.get(a).add(b);
            graph.get(b).add(a);
            
        }
        return new int[2];
    }
    
    public Set<Integer> dfs(Map<Integer,List<Integer>> graph, int node, Set<Integer> visited){
        if(!graph.containsKey(node)) return visited;// new int[2];
        
        if(visited.contains(node)) return visited;// new int[2];
        
        visited.add(node);
        
        for(int i : graph.get(node))
            dfs(graph, i, visited);
        
        return visited;
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

