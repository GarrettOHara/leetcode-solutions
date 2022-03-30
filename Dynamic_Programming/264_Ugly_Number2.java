class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }
}


/**
READABLE SOLUTION USING A MIN HEAP


public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }
    

NAIVE SOLUTION BAD COMPLEXITY... TOO SLOW!!!

class Solution {
    Map<Integer,Boolean>map = new HashMap<>();
    
    public int nthUglyNumber(int n) {
        
        int i = 0;
        while(n>0){
            i++;
            
            if(prime_factor(i)){
                n--;
            }
        }
        return i;
    }
    
    
    private boolean prime_factor(int n){
        while(n>1){
            if(n % 5 == 0)
                n /=5;
            else if(n % 3 == 0)
                n /= 3;
            else if(n % 2 == 0)
                n /= 2;
            else
                return false;
        }
        return n==1 ? true : false;
    }
}

**/
