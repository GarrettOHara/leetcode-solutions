class Solution {
    private int lo, max;
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2)
            return s;
        
        for(int i = 0; i < len-1; i++){
            extend(s,i,i);      // odd
            extend(s,i,i+1);    // even
        }
        
        return s.substring(lo,lo+max);
    }
    
    private void extend(String s, int i, int j){
        while(i>=0 && j < s.length() && s.charAt(i)==s.charAt(j)){
            i--; j++;
        }
        
        if(max < j - i - 1){
            lo = i+1;
            max = j - i - 1;
        }
    }
    
   
}

/**
ATTEMPT 1
        int max = 0;
        String res = "";
        for(int i = 1; i < s.length(); i++){
            int a = i-1, b = i+1;
            int count = 1;
            while(inbounds(s,a,b)){
                System.out.println("VISIT "+a+" "+b+" "+count);
                a--; b++; count++;
            }
            a++; b--; count--;
            if(inbounds(s,a,b) && count > max){
                res = s.substring(a,b+1);
                System.out.println(res);
                max = count;
            }
            
        }
        return res;

**/
