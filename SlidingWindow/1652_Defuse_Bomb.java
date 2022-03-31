class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] arr = new int[code.length];
        if(k >= 0){
            for(int i = 0; i < code.length; i++){
                int sum = 0;
                for(int j = i+1; j < i+1+k; j++){

                    int index = (j) % code.length;
                    sum += code[index];
                    // System.out.print(index + " ");
                }
                // System.out.println();
                arr[i] = sum;
            } 
        } else {
            for(int i = 0; i < code.length; i++){
                int sum = 0;
                int index = (i+k+code.length) % code.length;
                if(index<0)
                    index = Math.abs(index);
                // System.out.println(i + ":"+k+":"+index+"\n");
                for(int count = 0; count < Math.abs(k); count++){
    
                    index = index % code.length;
                    sum += code[index];
                    // System.out.print(code[index] + "+");
                    index++;
                }
                // System.out.println();
                arr[i] = sum;
            }
        }
        
        return arr;
    }
}
