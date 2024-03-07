class Solution {
    List<int[]>POS = new ArrayList<>();
    public void setZeroes(int[][] matrix) {
        List<int[]>list = new ArrayList<>();
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j]==0)
                    list.add(new int[]{i,j});
            }
        }
        
        for(int[]arr : list){
            setmatrix(matrix,arr[0],arr[1]);
        }
        
        for(int[]arr : POS){
            matrix[arr[0]][arr[1]]=0;
        }
    }
    
    private void setmatrix(int[][]mat, int i, int j){
        int ptr = i;
        while(--ptr>=0)
            POS.add(new int[]{ptr,j});
        ptr=i;
        while(++ptr<mat.length)
            POS.add(new int[]{ptr,j});
        ptr=j;
        while(--ptr>=0)
            POS.add(new int[]{i,ptr});
        ptr=j;
        while(++ptr<mat[i].length)
            POS.add(new int[]{i,ptr});
    }
}
