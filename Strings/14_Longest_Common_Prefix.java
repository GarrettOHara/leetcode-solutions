class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        String previous = "", current = "";
        int index = 1;
        boolean all_pass = true;
        
        // for every character in first word...
        for(int i = 0; i < strs[0].length(); i++){
            current += strs[0].charAt(i);
            
            // loop through word list
            for(int j = 0; j < strs.length; j++){
                if(i >= strs[j].length()){
                    all_pass = false;
                    break;
                }
                if(!current.equals(strs[j].substring(0,i+1)))
                    all_pass = false;
            }
            if(all_pass)
                previous = current;
            else
                break;
        }
        return previous;
    }
}


/**

Set<String> prefixes = new HashSet<>();
        String tmp = "";
        
        // add first word to list
        for(Character c : strs[0].toCharArray()){
            tmp+=c;
            prefixes.add(tmp);
        }
        
        
        int res = Integer.MAX_VALUE;
        String pre = "";
        
        // iterate words
        for(int i = 1; i < strs.length; i++){
            
            // iterate characters in word
            tmp = "";
            for(int j = 0; j < strs[i].length(); j++){
                tmp += strs[i].charAt(j);
                if(!prefixes.contains(tmp)){
                    if(j < res){
                        System.out.println
                        res = j;
                        pre = tmp;
                    }
                    break;
                }
            }
        }
        return pre;
        
        
        
        
        
        if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];
        
        List<String> list = new ArrayList<>();
        
        String tmp = "";
        for(char c : strs[0].toCharArray()){
            tmp += c;
            list.add(tmp);
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 1; i < strs.length; i++){
            tmp = "";
            int prefix = 0;
            for(int j = 0; j < strs[i].length() && j < list.size(); j++){
                tmp += strs[i].charAt(j);
                
                if(list.get(j).equals(tmp)){
                    prefix++;
                } else {
                    res = Math.min(res, prefix);
                    break;
                }
            }
        }
        return res > 0 ? list.get(res-1) : "";

**/
