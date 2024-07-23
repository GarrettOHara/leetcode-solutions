// Java program for the above approach
import java.io.*;
import java.lang.*;
import java.util.*;
 
class PathFinder{
 
// Function to check whether there
// exists a Hamiltonian Path or not
static boolean Hamiltonian_path(int graph[][], int N)
{
    boolean dp[][] = new boolean[N][(1 << N)];
 
    // Set all dp[i][(1 << i)] to
    // true
    for(int i = 0; i < N; i++)
        dp[i][(1 << i)] = true;
 
    // Iterate over each subset
    // of nodes
    for(int i = 0; i < (1 << N); i++)
    {
        for(int j = 0; j < N; j++)
        {
             
            // If the jth nodes is included
            // in the current subset
            if ((i & (1 << j)) != 0)
            {
 
                // Find K, neighbour of j
                // also present in the
                // current subset
                for(int k = 0; k < N; k++)
                {
                     
                    if ((i & (1 << k)) != 0 &&
                         graph[k][j] == 1 && j != k &&
                           dp[k][i ^ (1 << j)])
                    {
                         
                        // Update dp[j][i]
                        // to true
                        dp[j][i] = true;
                        break;
                    }
                }
            }
        }
    }
 
    // Traverse the vertices
    for(int i = 0; i < N; i++)
    {
         
        // Hamiltonian Path exists
        if (dp[i][(1 << N) - 1])
            return true;
    }
 
    // Otherwise, return false
    return false;
}

private static int[][] create_graph(int row, int col){
    Random rand = new Random();
    int[][] graph = new int[row][col];
    for(int i = 0; i < graph.length; i++){
        for(int j = 0; j < graph[i].length; j++){
            // graph[i][j] = rand.nextInt(2);
            int num = rand.nextInt(10);
            if(num % 6 == 0)
                graph[i][j] = 1;
            else
                graph[i][j] = 0;
      }
    }
    return graph;
}

private static void print_graph(int[][] graph){
    for(int i = 0; i < graph.length; i++){
        for(int j = 0; j < graph[i].length; j++){
            if(j==0)
                System.out.print(String.format("%10s", graph[i][j]));
            else
                System.out.print(String.format("%2s", graph[i][j]));
      }
      System.out.println();
    }
}

 
// Driver Code
public static void main(String[] args)
{
    Scanner scan = new Scanner(System.in);
    System.out.print("Configure graph dimensions: ");
    int row = Integer.parseInt(scan.nextLine());
    System.out.println();
    int col = row;
    scan.close();
    
    
    int[][]graph = create_graph(row, col);
    
    
    print_graph(graph);
    if (Hamiltonian_path(graph, graph.length))
        System.out.println("YES");
    else
        System.out.println("NO");
    }
}
 
// This code is contributed by Kingash