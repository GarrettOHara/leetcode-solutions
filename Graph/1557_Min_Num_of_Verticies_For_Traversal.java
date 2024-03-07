class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        List<Integer>res = new ArrayList<>();
        int[] arr = new int[n];
        
        for(List<Integer>list : edges)
            arr[list.get(1)] = 1;
        
        for(int i = 0; i < arr.length; i++){
            if(arr[i]==0) res.add(i);
        }
        
        return res;
    }
    
    public List<Integer> set_method(int n, List<List<Integer>edges){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) set.add(i);
        
        for(List<Integer> list : edges)
            set.remove(list.get(1));
        
        return new ArrayList<>(set);
    }
}

/**

ORIGINAL ATTEMPT

        graph traversal. use dfs. have visited map. 
        perform unique traversal on each node and store in map.
                
        create set of all nodes. traverse each one. if we encounter 
        a node, remove it from the set (its reachable by another node)
        
        
//         // traverse each node
//         for(int i = 0; i < n-1; i++){
//             System.out.print("node:"+i);
//             dfs(edges, set, i, new boolean[n], false);
//             System.out.println();
//             for(int p : set)
//                 System.out.print(p+" ");

//         }
//         return new ArrayList<>(set);

//     public void dfs(List<List<Integer>>edges,Set<Integer>set,int node, boolean[] visited, boolean removable){
//         // base case
//         if(edges.get(node).size()==0) return;
        
//         // iterate current nodes edge set
//         for(int i = 0; i < edges.get(node).size(); i++){
            
//             int current = edges.get(node).get(i);
            
//             // already been here, skip
//             if(visited[current]) return;
            
//             // node is reachable and not root, remove it
//             if(removable) set.remove(current);

//             // leave our bread crumb trail
//             visited[current] = true;

//             // move on
//             dfs(edges,set,i,visited,true);
//         }
//     }
