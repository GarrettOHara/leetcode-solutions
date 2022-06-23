import java.util.*;

class SecondTry {
    int islands;
    public int findCircleNum(int[][] isConnected) {
        // create set that is passed during recursion
        // set will contain all things that have been vistied
        //
        // if we encounter a new item in the set then we increment
        // the counter only once per group (use boolean value in parent for loop)
        //

        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> graph = new ArrayList<>();

        // for every node in graph, add new element to list
        for(int i = 0; i < isConnected.length; i++) {

            // add current node to list
            graph.add(new ArrayList<>());

            for(int j = 0; j < isConnected[i].length; j++){

                // looking at self edge
                if(j==i) continue;

                // add new edge
                if(isConnected[i][j] == 1)
                    graph.get(i).add(j);
            }
        }
        islands = 0;

        // loop through every node in the graph
        for(int i = 0; i < graph.size(); i++){

            // traverse node dfs
            dfs(graph, i, visited);
            islands++;
        }

        return islands;
    }

    private void dfs(List<List<Integer>> graph, int node, Set<Integer> visited) {
        if(visited.contains(node)){
            islands--;
            return;
        }

        visited.add(node);

        // loop all edges of node
        for(int i = 0 ; i < graph.get(node).size() ; i++) {

            // check to see if new node
            if(!visited.contains(graph.get(node).get(i)))
                dfs(graph, graph.get(node).get(i), visited);

        }

        return;
    }
}


class FirstTry {
    int islands;
    public int findCircleNum(int[][] matrix) {

        islands = 0;

        Set<Integer> visited = new HashSet<>();
        Map<Integer,List<Integer>> graph = new HashMap<>();


        for(int i = 0; i < matrix.length; i++)
            graph.put(i,new ArrayList());

        for(int i = 0; i < matrix.length; i++){
            // i is the vertex
            // matrix[i] is the edge set

            for(int j = 0; j < matrix[i].length; j++){
                // remove self edges
                if(i==j)
                    continue;
                if(matrix[i][j]==1)
                    graph.get(i).add(j);
            }
        }

        for(Map.Entry<Integer,List<Integer>> entry : graph.entrySet()){
            dfs(graph, visited, entry.getKey());
            islands++;
        }

        return islands;
    }

    private void dfs(Map<Integer,List<Integer>> graph, Set<Integer>visited, int start){
        if(visited.contains(start)){
            islands--;
            return;
        }

        visited.add(start);

        for(int i : graph.get(start)){
            if(!visited.contains(i))
                dfs(graph, visited, i);
        }
    }
}
