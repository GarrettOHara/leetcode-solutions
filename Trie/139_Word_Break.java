import java.util.*;
class Solution {
    
    private TrieNode trie = new TrieNode();
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        for(String str : wordDict)
            insert(str);
        
        boolean[] dp = new boolean[s.length()+1];
        char[] str = s.toCharArray();
        dp[0] = true;
        
        for(int i = 0; i < dp.length;i++){
            if(!dp[i])
                continue;
            
            int tmp = i;
            TrieNode curr = trie;
            
            while(tmp < s.length() && curr.nodes[str[tmp]-'a']!=null){
                curr = curr.nodes[str[tmp++]-'a'];
                if(curr.isWord)
                    dp[tmp]=true;
            }
            
        }
        
        return dp[s.length()];
    }
    
    private void insert(String s){
        TrieNode curr = trie;
        for(char c : s.toCharArray()){
            if(curr.nodes[c-'a']==null)
                    curr.nodes[c-'a'] = new TrieNode();
            curr = curr.nodes[c-'a'];
        }
        curr.isWord = true;
    }
    
    class TrieNode {
        public boolean isWord;
        public TrieNode[] nodes = new TrieNode[26];
    }
    
}
