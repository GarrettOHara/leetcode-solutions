/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return binarySearch(1,n);
    }
    private int binarySearch(int lo, int hi){
        if(hi >= lo){
            int mid = lo + (hi - lo)/2;
            if(isBadVersion(mid))
                return binarySearch(lo, mid-1);
            else
                return binarySearch(mid+1,hi);
        }
        return lo;
    }
}

/*
Iterative approach:

    int left = 1;
    int right = n;
    while (left < right) {
        int mid = left + (right - left) / 2;
        if (isBadVersion(mid)) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }
    return left;

*/
