boolean solution(double[] prices, String[] notes, double x) {
    
    double[] arr = new double[notes.length];
    double res = 0;
    for(int i = 0; i < notes.length; i++){
        
        String delmin = "[\\s%]+";
        String[] tokens = notes[i].split(delmin);
        
        if(tokens[0].equals("Same"))
            arr[i]=0;
        else{
            
            double val = Double.parseDouble(tokens[0]);
            
            if(tokens[1].equals("lower")){
                val*=-1;
                res += prices[i] * (val / (100+val));
            }
            
            else{
                res += prices[i] * (val / (100+val));
            }
        }
    }
    return x>=res;
}
