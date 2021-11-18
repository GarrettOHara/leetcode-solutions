class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character>set = new HashSet<>();
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            int count = 0;
            set.clear();
            for(int j = i; j < s.length(); j++){
                if(set.add(s.charAt(j)))
                    count++;
                else
                    break;
                
            }
            max = Integer.max(max,count);
        }        
        return max;
    }
}


/**
        Set<Character>set = new HashSet<>();
        int max = 0, count = 0;
        for(char c : s.toCharArray()){
            if(set.add(c))
                count++;
            else{
                max = Integer.max(max,count);
                count = 0;
                set.clear();
            }
        }
        
        return max;
    }
**/
