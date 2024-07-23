//package HamiltonianPath;

import java.util.*;

class Path{
  public static void main(String[] args){
    Random rand = new Random();
    int[][] graph = new int[25][25];

    for(int i = 0; i < graph.length; i++){
      for(int j = 0; j < graph[i].length; j++){
        graph[i][j] = rand.nextInt(100);
      }
    }
    print_graph(graph);
    return;
  }


  private static void print_graph(int[][]graph){
    for(int i = 0; i < graph.length; i++){
      for(int j = 0; j < graph[i].length; j++){
        System.out.print(String.format("%5s", graph[i][j]));
      }
      System.out.println();
    }
  }
}