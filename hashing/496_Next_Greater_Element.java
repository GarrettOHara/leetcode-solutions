class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer,Integer> pos = new HashMap<>();
        
        for(int i = 0; i < nums2.length; i++)
            pos.put(nums2[i],i);
        
        for(int i = 0; i < nums1.length; i++){
            int val = nums1[i];
            int index = pos.get(val);
            boolean found = false;
            for(int j = index ; j < nums2.length; j++){
                if(nums2[j] > val) {
                    nums1[i] = nums2[j];
                    found = true;
                    break;
                }
            }
            if(!found)
                nums1[i] = -1;
        }
        return nums1;
    }
}


/**

        // use treemap and grab nums1[i]+1 
        // map.ceilingEntry( nums[i]+1 )
        
        TreeMap<Integer,Integer>map = new TreeMap<>();
        for(int i = 0; i < nums2.length; i++)
            map.put(nums2[i],i);
        
        for(int i = 0 ; i < nums1.length ; i++) {
            
            int val = nums1[i];
            boolean notset = false;
            System.out.print(val+": ");
            for(int j = i; j < nums2.length; j++) {
                
                // System.out.print(nums2[j]+" ");
                if(nums2[j] > val){
                    System.out.print(nums2[j]+" ");
                    nums1[i] = nums2[j];
                    notset = true;
                    break;
                }
            }
            
            if(!notset)
                nums1[i] = -1;
            
            System.out.println();
        }
        
        return nums1;

**/
