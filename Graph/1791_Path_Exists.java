class Solution {
    boolean found;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        /**
        NAIVE: recursive DFS search on graph, return 
            true if reach destination 
            false if not
            
        OPTIMIZED: Dikstra Pathfinding algorithm 
        
        **/
        
        // INITIALIZE FINDER HELPER
        found = false;
        
        // BASE CASE
        if(source == destination)
            return true;
        
        // GRAPH TO STORE VERTECIES AND EDGES
        Map<Integer,List<Integer>> graph = new HashMap<>();
        
        // VISITED ARRAY
        boolean[] visited = new boolean[n];
        
        // POPULATE EDGE SETS
        for(int i = 0; i < n; i++)
            graph.put(i,new ArrayList());
        
        // ADD EDGES TO VERTECIES
        for(int[]edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // TRAVERSE GRAPH FROM SOURCE
        dfs(graph, visited, source, destination);
        
        // RETURN RESULT
        return found;
    }
    
    private void dfs(Map<Integer,List<Integer>>graph, boolean[] visited, int source, int dest){
        
        // RECURSIVE BASE CASE
        if(visited[source] || found)
            return;
        
        // MARK NODE FOR VISITATION
        visited[source]=true;
        
        // TRAVERSE NODE EDGES
        for(int i : graph.get(source)){
            
            // FOUND PATH!
            if(source == dest){
                found = true;
                break;
            }
            
            // TRAVERSE IF NOT VISITED BEFORE
            if(!visited[i])
                dfs(graph, visited, i, dest);
        }
    }
}
        
        
        
/**
DOESN'T ACCOUNT FOR NON CONNECTED SUBGRAPHS

OR WHEN INDEX != SOURCE NODE

        return find(source,edges,destination);
    }
    
    private boolean find(int source, int[][]graph, int dest){
        if(graph[source][0]!=source)
            return false;
        if(position==dest)
            return true;
        
        find(graph[position][1]);
    }
}

**/
