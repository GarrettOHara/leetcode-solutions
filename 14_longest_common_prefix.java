class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)return strs[0];
        String check = strs[0];
        
        for(int i = 1; i < strs.length; i++){
            String tmp = strs[i];
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < check.length();j++){
                if(j >= tmp.length() || check.charAt(j)!=tmp.charAt(j))
                    check = sb.toString();
                else {
                    sb.append(check.charAt(j));
                }
            }
        }
        return check;
    }
}

