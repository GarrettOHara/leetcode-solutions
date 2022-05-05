class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<double[]> q = new PriorityQueue<>( Comparator.comparingDouble(o -> -o[0]));
        
        for (int[] c : classes) {
            double a = c[0], b = c[1];
            q.offer(new double[]{profit(a, b), a, b});
        }
        
        while(extraStudents-- > 0){
            double[] arr = q.poll();
            double a = arr[1], b = arr[2];
            q.offer(new double[]{profit(a+1, b+1), a+1, b+1});
        }
        
        double average = 0;
        while(q.size()>0){
            double[] arr = q.poll();
            
            double a = arr[1], b = arr[2];
            average += a/b;
        }
        return average/classes.length;
    }
        
    double profit(double a, double b) {
        return (a + 1) / (b + 1) - a / b;
    }
}

/**
FIRST ATTEMP

public double maxAverageRatio(int[][] classes, int extraStudents) {
        Queue<int[]> q = new PriorityQueue<>( (a,b) -> ( (a[0]/a[1]) - (b[0]/b[1]) ) );
        for(int[] arr : classes) q.offer(arr);
        
        while(extraStudents-- > 0){
            int[] arr = q.poll();
            System.out.println(arr[0] + " "+ arr[1]);
            arr[0]++; arr[1]++;
            q.offer(arr);
        }
        
        double average = 0;
        while(q.size()>0){
            int[] arr = q.poll();
            
            average += (arr[0]/arr[1]);
        }
        return average/classes.length;
    }
    
**/
