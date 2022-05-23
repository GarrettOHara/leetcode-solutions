class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            StringBuilder str = new StringBuilder();
            for(int j = i; j < s.length(); j++) {
                str.append(s.charAt(j));
                if(palindrome(str.toString())) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean palindrome(String s){
        if(s.length() % 2 == 0) {
            boolean check = false;
            int l = s.length()/2 - 1, r = s.length()/2;
            while(l >= 0 && r < s.length()){
                check = true;
                if(s.charAt(l) != s.charAt(r))
                    return false;
                l--; r++;
            }
            return check ? true : false;
        } else {
            boolean check = false;
            int l = s.length()/2, r = s.length()/2;
            while(l >= 0 && r < s.length()){
                check = true;
                if(s.charAt(l) != s.charAt(r))
                    return false;
                l--; r++;
            }
            return check ? true : false;
        }
    }
}


/***
NON OPTIMAL < O(N^2)

public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            StringBuilder str = new StringBuilder();
            for(int j = i; j < s.length(); j++) {
                str.append(s.charAt(j));
                if(palindrome(str.toString())) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean palindrome(String s){
        if(s.length() % 2 == 0) {
            boolean check = false;
            int l = s.length()/2 - 1, r = s.length()/2;
            while(l >= 0 && r < s.length()){
                check = true;
                if(s.charAt(l) != s.charAt(r))
                    return false;
                l--; r++;
            }
            return check ? true : false;
        } else {
            boolean check = false;
            int l = s.length()/2, r = s.length()/2;
            while(l >= 0 && r < s.length()){
                check = true;
                if(s.charAt(l) != s.charAt(r))
                    return false;
                l--; r++;
            }
            return check ? true : false;
        }
    }
    
    
public class OPTIMAL {
    int count = 0;
    
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }
        
        return count;
    }
    
    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }
}

***/
