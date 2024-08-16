class Solution {
    public int longestPalindrome(String s) {
        Set<Character>set = new HashSet<>();
        int count = 0;
        for(char c : s.toCharArray()){
            if(set.remove(c))
                count++;
            else
                set.add(c);
        }
        return set.isEmpty() ? count*2 : count*2+1;
    }
}

/**
Attempt 1

        Map<Character,Integer>map = new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        int oddcount = 0, count = 0;
        for(Map.Entry<Character,Integer>entry : map.entrySet()){
            int key = map.getKey();
            int val = map.getVal();
            if(val%2 != 0)
                oddcount++;
            count+=val;
        }
        return 
        
**/

/**

find longest palindrome in substring

        int max = 0;
        for(int i = 1; i < s.length(); i++){
            int a = i-1, b = i+1;
            int count = 1;
            while(a >= 0 && b < s.length()){
                if(s.charAt(a) != s.charAt(b))
                    break;
                a--; b++; count++;
            }
            max = Math.max(max, count);
        }
        return 0;

**/
