/**

OPTIMAL SOLUTION:

**/

class Solution {
    public int maxProfit(int[] prices) {
        int res=0, lo = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<lo){
                lo = prices[i]; 
            }
            res = Math.max(prices[i]-lo,res);
        }
        return res;
    }
}


/**
QUADRATIC SOLUTION:

    int max = Integer.MIN_VALUE;
    for(int i=0; i<prices.length-1;i++){
        for(int j=i+1;j<prices.length;j++){
            int tmp = prices[j]-prices[i];
            if(tmp>max)
                max = tmp;
        }
    }
    return (max>0) ? max : 0;

**/
