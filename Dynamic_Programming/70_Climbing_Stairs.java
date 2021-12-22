class Solution {
    public int climbStairs(int n) {
        //TABLULATION
        return tabulation(n);
        
        //MEMOIZATION
        //return memoization(n);
    }
    
    private int tabulation(int n){
        if(n==0)return 1;
        if(n==1)return 1;
        
        int[] res = new int[n+1];
        res[0]=1;res[1]=1;
        
        for(int i = 2; i<=n; i++)
            res[i] = res[i-1]+res[i-2];
        
        return res[n];
    }
    
    Map<Integer, Integer> memo = new HashMap<>();
    private int memoization(int n){
        if(n==0)return 1;
        if(n==1)return 1;
        
        if(memo.containsKey(n))
            return memo.get(n);
        
        else {
            int res = memoization(n-1)+memoization(n-2);
            memo.put(n,res);
            return res;
        }
    }
}

/**

        if(num==1)return 1;
        if(num==2)return 2;
        int[] n = new int[num];
        n[0]=1;
        n[1]=2;
        for(int i = 2; i < num; i++)
            n[i]=n[i-1]+n[i-2];
        return n[num-1];

class Solution {
    public int climbStairs(int num) {
        if(num==1)return 1;
        if(num==2)return 2;
        int[] n = new int[num];
        n[0]=1;
        n[1]=2;
        for(int i = 2; i < num; i++)
            n[i]=n[i-1]+n[i-2];
        return n[num-1];
    }
}

**/
