import java.util.Map.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create map to store frequencies
        Map<Integer,Integer>map = new HashMap<>();
        
        // iterate array and count frequencies
        for(int i : nums){
            int res = map.getOrDefault(i,0);
            map.put(i,res+1);
        }
        
        // create and sort list
        List<Entry<Integer,Integer>>list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());
        
        // create return array
        int[] res = new int[k];
        
        // populate return array
        int n = list.size();
        for(int i = 0; i < k; i++)
            res[i] = list.get(n-i-1).getKey();
        
        return res;
       
    }
}

/**

Better approach would be to use a Heap or Priority Queue and 

store the frequencies of numbers headed into the data structure 

we would want to store tuples of some sort

**/
