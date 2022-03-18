class Solution {
    public int maximumScore(int a, int b, int c) {
        Queue<Integer>pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(a); pq.offer(b); pq.offer(c);
        
        int counter = 0;
        while(pq.size()>1){
            a = pq.poll();
            b = pq.poll();
            a--; b--; counter++;
            if(a>0)
                pq.offer(a);
            if(b>0)
                pq.offer(b);
        }
        return counter;
    }
}


/**

Constant: 

    public int maximumScore(int a, int b, int c) {
        // Make sure a <= b <= c
        if (a>b) return maximumScore(b,a,c);
        if (b>c) return maximumScore(a,c,b);

        // if sum of smallest numbers [a+b] is less than c, then we can a + b pairs with the c
        if (a+b<=c) return a+b;

        // if sum of smallest numbers is greater than c, then we can (a+b)/2 pairs after making c empty
        return c+(a+b-c)/2;
    }



    public int maximumScore(int a, int b, int c) {
        return (a+b+c)/2;
    }
1
50000
1999
Output:   26000
Expected: 2000
**/
