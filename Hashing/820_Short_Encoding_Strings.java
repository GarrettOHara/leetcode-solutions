import java.util.*;

class Solution {
    public int minimumLengthEncoding(String[] words) {
        
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for(String str : words){
            for(int i = 1; i < str.length(); i++)
                set.remove(str.substring(i));
        }
        
        int res = 0;
        for(String s : set) res+= s.length()+1;
        
        return res;
        
    }
    
    
}


/**
FIRST ATTEMPT

    Set<String> set = new HashSet<>();
    public int minimumLengthEncoding(String[] words) {

        Arrays.sort(words, (b,a)->Integer.compare(a.length(),b.length()));
        
        // for(String s : words)
        //     System.out.println(s);
        // System.out.println();
        
        // emplace first word
        String res = words[0] + "#";
        place_substrings(words[0]);
        
        for(int i = 1; i < words.length; i++){
            if(!set.contains(words[i])){
                res+=words[i] + "#";
                place_substrings(words[i]);
            }
        }
        return res.length();
    }
    
    private void place_substrings(String str){
        StringBuilder s = new StringBuilder(str);
        for(int i = 0 ; i < str.length() ; i++){
            set.add(s.toString());
            s.deleteCharAt(0);
        }
    }
    
    
**/
