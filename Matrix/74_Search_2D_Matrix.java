class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search per matrix row
        
        for(int[] arr : matrix){
            if(Arrays.binarySearch(arr,target)>=0)
                return true;
        }
        return false;
    }
    
    private boolean naive_search(int[][]matrix, int target){
        // naive solution O(n)
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }
}
