import java.util.*;

class Biparate {
  public static void main(String[] args){
    int[][] graphA = new int[][]{
      {1,2,3},
      {0,2},
      {0,1,3},
      {0,2}
    };

    int[][] graphB = new int[][]{
      {1,3},
      {0,2},
      {1,3},
      {0,2}
    };

    matrix_toString(graphA);
    matrix_toString(graphB);
    
    System.out.println("Graph A: "+is_bipartite(graphA));
    System.out.println("Graph B: "+is_bipartite(graphB));

  }

  private static boolean is_bipartite(int[][] graph){
    Map<int[],Integer> map = new HashMap<>();

    for(int[] arr : graph){ 
      for(int i : arr)
        System.out.print(i + " ");
      System.out.println();
      map.put(arr,map.getOrDefault(arr,0)+1);
    }


    int count = 0;

    for(Map.Entry<int[],Integer> entry : map.entrySet()) {
      if(entry.getValue() > 1)
        count++;
    }

    map_toString(map);

    if(count==0)
      return false;

    return (graph.length % count == 0) ?  true : false;
  }

  private static void  matrix_toString(int[][] graph){
    
    for(int i = 0; i < graph.length; i++){
      System.out.print("Node "+i+ ": ");
      for(int j = 0; j < graph[i].length; j++){
        System.out.print(graph[i][j]+" ");
      }
      System.out.println();
    }

    System.out.println();
  }
  
  private static void map_toString(Map<int[],Integer>map){
    for(Map.Entry<int[],Integer>entry : map.entrySet()){
      System.out.print("{");

      int[] arr = entry.getKey();
      for(int i = 0; i < arr.length; i++){
        if(i==arr.length-1)
          System.out.print(i);
        else
          System.out.print(i+" ");
      }
       System.out.println("}\t\t"+entry.getValue());
    }


  }

}
