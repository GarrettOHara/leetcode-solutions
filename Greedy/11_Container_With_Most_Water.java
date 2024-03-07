class Solution {
    public int maxArea(int[] arr) {
        int lo = 0, hi = arr.length-1;
        int max = 0;
        while(lo < hi){
            max = Math.max(max, ( (hi-lo) * Math.min(arr[lo],arr[hi])));
            
            if(arr[lo] < arr[hi])
                lo++;
            else
                hi--;
        }
        return max;
    }
}


/**
INITIAL APPROACH:

int a = height[0], b = height[1], max = 0;
int indexA = 0, indexB = 1;

for(int i = 2; i < height.length; i++){
    if(height[i]>a || height[i]>b){
        indexA = indexB;
        indexB = i;

        int tmp = b;
        b = height[i];
        a = tmp;

    } else if (i-indexA > b){
        b = height[i];
        indexB = i;
    }

    int num = Math.min(a,b) * (indexB-indexA);
    if(num > max)
        max = num;
}
System.out.println(indexA + " " + indexB);
return max;

**/
