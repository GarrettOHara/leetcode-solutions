class Solution {
    List<List<Integer>>list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n,k,new ArrayList<>(),1);
        return list;
    }
    
    private void backtrack(int n, int k, List<Integer>current, int start){
        if(k==0)
            list.add(new ArrayList<>(current));
        
        for(int i = start; i <= n; i++){
            current.add(i);
            
            /* INSTEAD OF START + 1 WE NEED TO DO i+1 */
            backtrack(n,k-1,current,i+1);
            
            current.remove(current.size()-1);
        }
    }
}


/**


class Solution {
    List<List<Integer>>list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n,k,new HashSet<>(),1);
        return list;
    }
    
    private void backtrack(int n, int k, Set<Integer>current, int start){
        if(current.size()>k)
            return;
        
        // if(current.size()==k)
        //     list.add(current);
        
        for(int i = start; i <= n; i++){
            if(current.size()<2)
                current.add(i);
            else{
                List<Integer>l = new ArrayList<>();
                l.addAll(current);
                list.add(l);
                Set<Integer>tmp = new HashSet<>();
                tmp.add(i);
                backtrack(n,k,tmp,start+1);
                list.remove(list.size()-1);
            }
            
            
        }
        
        return;
    }
}

**/
