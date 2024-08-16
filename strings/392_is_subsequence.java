class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0)
            return true;
        boolean[]res = new boolean[s.length()];
        int index = 0;
        for(int i = 0; i < t.length() && index < s.length(); i++){
            if(t.charAt(i)==s.charAt(index)){
                res[index]=true;
                index++;
            }
        }
        return res[s.length()-1];
    }
}


/**

        if(s.length()==0)
            return true;
        int index = 0; boolean found = false;
        for(char c : t.toCharArray()){
            if(index==s.length()-1)
                return true;
            if(c==s.charAt(index)){
                index++; found = true;
            }
        }
        System.out.println(found);
        return index==s.length()-1 && found;

**/
