import java.util.HashMap;
import java.util.Map;
class Solution {
    public static long fib(long n){
        // MEMOIZE
        return memoize(n);
        
        
        // TABULATION
        // return tablulation(n);
        
    }
    static Map<Long,Long> map = new HashMap<>();
    private static long memoize(long n){
        if(n==0)return 0;
        if(n==1)return 1;
        
        if(map.containsKey(n))return map.get(n);

        long res = memoize(n-1)+memoize(n-2);
        
        map.put(n,res);
        
        return res;
    }
    
    private static long tabulation(long n) {
        int q = (int) n;
        long[] fibs = new long[q+1];
        fibs[0]=0;
        fibs[1]=1;
        for(int i = 2; i <= n; i++)
            fibs[i]=fibs[i-1]+fibs[i-2];
        return fibs[q];
    }

  public static void main(String[] args){
    System.out.println(fib(3));
    System.out.println(fib(5));
    System.out.println(fib(7));
    System.out.println(fib(9));
    System.out.println(fib(10));
    System.out.println(fib(15));
    System.out.println(fib(20));
    System.out.println(fib(100));
    System.out.println(fib(200));
    System.out.println(fib(300));
  }
}
