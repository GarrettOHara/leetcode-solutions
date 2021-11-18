class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer>list=new LinkedList<>();
        int a = 0, b = 0;
        while(a<nums1.length || b<nums2.length){
            if(a<nums1.length && b<nums2.length){
                if(nums1[a]<nums2[b]){
                    list.add(nums1[a]); a++;
                } else {
                    list.add(nums2[b]); b++;
                }
            } else if(a<nums1.length){
                list.add(nums1[a]); a++;
            } else {
                list.add(nums2[b]); b++;
            }
        }
        int val = list.size();
        if(val%2==0){
            double res = (list.get(val/2-1)+list.get(val/2));
            res /= 2;
            return res;
        } else {
            int res = list.get(val/2);
            return (double)res;
        }
    }
}
