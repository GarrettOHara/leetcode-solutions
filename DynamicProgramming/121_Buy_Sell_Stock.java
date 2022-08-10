import java.util.*;


class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int max = 0; //Integer.MIN_VALUE;
        while(r < prices.length) {
            if(prices[l] < prices[r])
                max = Math.max(max, prices[r]-prices[l]);
            else
                l = r;
            r++;
        }
        return max;
    }
}
