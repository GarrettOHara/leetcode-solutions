class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for(List<String> list : paths){
            String a = list.get(0);
            String b = list.get(1);
            
            map.put(a,b);
        }
        
        for(List<String> list : paths){
            String a = list.get(0);
            String b = list.get(1);
            if(!map.containsKey(a))
                return a;
            
            if(!map.containsKey(b))
                return b;
            
        }
        return "";
    }
}


/**
FASTER SOLUTION

        Set<String> cities = new HashSet<>(); 
        for (List<String> path : paths) {
            cities.add(path.get(0)); 
        }
        
        for (List<String> path : paths) {
            String dest = path.get(1); 
            if (!cities.contains(dest)) {
                return dest; 
            }
        }
        return "";

**/
