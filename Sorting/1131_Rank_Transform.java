import java.util.*;
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] copy = Arrays.copyOf(arr,arr.length);
        Arrays.sort(copy);
        
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < copy.length; i++)
            map.putIfAbsent(copy[i],map.size()+1);
        
        for(int i = 0; i < arr.length; i++){
            copy[i] = map.get(arr[i]);
        }
        
        return copy;
    }
}
