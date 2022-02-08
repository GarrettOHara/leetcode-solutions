int[] solution(int[] a) {
    // loop through until not -1, store pointer at start
    // iterate until -1
    // sort subet of array
    int start = 0, end = 0;
    for(int i = 0; i < a.length; i++){
        if(a[i] == -1)
            continue;
            
        else{
            
            start = i;
            for(int j = i; j < a.length; j++){
                if(a[j]==-1)
                    end = j-1;
            }
            if(start-end > 0)
                Arrays.sort(a,start,end);
            
        }
    }
    return a;
}


/**
FIRST ATTEMPT
    List<Integer>list = new LinkedList<>();
    int count = 0;
    for(int i : a){
        if(i == -1 && count > 0){
            list.add(count);
            list.add(i);
            count = 0;
        } else if(i==-1){
            list.add(i);
            count = 0;
        } else {
            count++;
        }
    }
    for(int i : list){
        System.out.println(i);
    }
    return a;
**/
