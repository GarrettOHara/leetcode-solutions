class Solution{
    public static void main(String[] args){
      System.out.println(solution("aaabaaa");
    }
    public static boolean solution(String str) {
        int lo = 0, hi = str.length()-1;
        while(lo<hi){
            if(str.charAt(lo)!=str.charAt(hi))
                return false;
            lo++;
            hi--;
        }
        return true;
    }
}

