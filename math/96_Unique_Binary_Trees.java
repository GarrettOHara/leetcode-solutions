import java.util.*;

// using catalan numbers 

class Solution {
    public int numTrees(int n) {
        int N = 2*n;
        long[] dp = new long[n+1];
        dp[0] = 1;
        for(int i = 1;i<=N;i++) {
            for(int j = Math.min(i,n);j>0;j--){
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return (int)(dp[n]/(n+1));
        
        //return (factorial(2*n)) / (factorial(n)) / (factorial(n)) / (n+1);
    }
    
    // public int factorial(int n){    
    //   if (n == 0) return 1;    
    //   else return(n * factorial(n-1));    
    // }    
}
