class Solution {
    public int tribonacci(int n) {
        
        // TABULATION
        //return tabulation(n);
        
        // MEMOIZATION
        return memoization(n);
    }
    
    private int tabulation(int n){
        if(n==0)return 0;
        if(n==1)return 1;
        if(n==2)return 1;
        int[] fibs = new int[n+1];
        fibs[0]=0;fibs[1]=1;fibs[2]=1;
        for(int i = 3; i <= n; i++)
            fibs[i]=fibs[i-1]+fibs[i-2]+fibs[i-3];
        return fibs[n];
    }
    Map<Integer,Integer>memo = new HashMap<>();
    private int memoization(int n){
        if(n==0)return 0;
        if(n==1)return 1;
        if(n==2)return 1;
        if(memo.containsKey(n))return memo.get(n);
        
        int res = memoization(n-1)+memoization(n-2)+memoization(n-3);
        
        memo.put(n,res);
        
        return res;
    }
}
