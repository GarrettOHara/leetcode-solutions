
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
// A class to store a graph edge
class Edge
{
    int source, dest;
 
    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}
 
// A class to represent a graph object
class Graph
{
    // A list of lists to represent an adjacency list
    List<List<Integer>> adjList = null;
 
    // Constructor
    Graph(List<Edge> edges, int n)
    {
        adjList = new ArrayList<>();
 
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
 
        // add edges to the undirected graph
        for (Edge edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;
 
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
    }
}
 
class Main
{
    public static void hamiltonianPaths(Graph graph, int v, boolean[] visited,
                                            List<Integer> path, int n)
    {
        // if all the vertices are visited, then the Hamiltonian path exists
        if (path.size() == n)
        {
            // print the Hamiltonian path
            System.out.println(path);
            return;
        }
 
        // Check if every edge starting from vertex `v` leads
        // to a solution or not
        for (int w: graph.adjList.get(v))
        {
            // process only unvisited vertices as the Hamiltonian
            // path visit each vertex exactly once
            if (!visited[w])
            {
                visited[w] = true;
                path.add(w);
 
                // check if adding vertex `w` to the path leads
                // to the solution or not
                hamiltonianPaths(graph, w, visited, path, n);
 
                // backtrack
                visited[w] = false;
                path.remove(path.size() - 1);
            }
        }
    }
 
    public static void findHamiltonianPaths(Graph graph, int n)
    {
        // start with every node
        for (int start = 0; start < n; start++)
        {
            // add starting node to the path
            List<Integer> path = new ArrayList<>();
            path.add(start);
 
            // mark the start node as visited
            boolean[] visited = new boolean[n];
            visited[start] = true;
 
            hamiltonianPaths(graph, start, visited, path, n);
        }
    }
 
    public static void main(String[] args)
    {
        // consider a complete graph having 4 vertices
        List<Edge> edges = Arrays.asList(
                new Edge(0, 1), new Edge(0, 2), new Edge(0, 3),
                new Edge(1, 2), new Edge(1, 3), new Edge(2, 3)
        );
 
        // total number of nodes in the graph (labelled from 0 to 3)
        int n = 4;
 
        // build a graph from the given edges
        Graph graph = new Graph(edges, n);
 
        findHamiltonianPaths(graph, n);
    }
}