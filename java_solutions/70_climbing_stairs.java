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
