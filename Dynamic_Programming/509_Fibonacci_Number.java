class Solution {
    public int fib(int n){
        // MEMOIZE
        return memoize(n);
        
        
        // TABULATION
        //return tabulation(n);
        
    }
    Map<Integer,Integer> memo = new HashMap<>();
    private int memoize(int n){
        if(n==0)return 0;
        if(n==1)return 1;
        
        if(memo.containsKey(n))
            return memo.get(n);
                
        int res = memoize(n-1)+memoize(n-2);
        
        memo.put(n,res);
        
        return res;
    }
    
    private int tabulation(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        int[] fibs = new int[n+1];
        fibs[0]=0;
        fibs[1]=1;
        for(int i = 2; i <= n; i++)
            fibs[i]=fibs[i-1]+fibs[i-2];
        return fibs[n];
    }
}

