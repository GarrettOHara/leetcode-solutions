import java.util.*;

class Solution {
    public static void main(String[] args){
      String[] dictionary = {"cat","bat","rat"};
      String sentence = "the cattle was rattled by the battery";
      System.out.print("BEFORE REPLACE WORDS:\n"+sentence+
        "\n\nAFTER REPLACE WORDS:\n");
      String result = replaceWords(dictionary, sentence);
      System.out.println(result);
    }
    public static  String replaceWords(String[] dictionary, String sentence) {
        // SPLIT STRING
        String[] words = sentence.split("\\s");
        
        // CREATE TRIE
        Trie trie = new Trie();
        
        // BUILD TRIE
        for(String s : dictionary)
            trie.insert(s);
        
        
        for(int i = 0; i < words.length; i++){
            String curr = "";
            for(int j = 0; j < words[i].length(); j++){
                curr += words[i].charAt(j);
                if(trie.find(curr)){
                    words[i] = curr;
                    break;
                }
            }
        }
        String res = "";
        for(int i = 0; i < words.length; i++){
            if(i < words.length-1){
                res += words[i];
                res += " ";
            } else 
                res += words[i];
        }
        return res;
    }
    
}
class TrieNode{
    public HashMap<Character, TrieNode> children;
    public String content;
    public boolean isWord;
    
    public TrieNode(){
        this.children = new HashMap<>();
        this.content = "";
        this.isWord = false;
    }
}
class Trie {
    
    TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }
    
    public void insert(String word){
        TrieNode curr = root;
        for(char l : word.toCharArray())
            curr = curr.children.computeIfAbsent(l, c -> new TrieNode());
        
        curr.isWord = true;
    }
    public boolean find(String word) {
       
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) 
                return false;
            
            current = node;
        }
        return current.isWord;
    }
}
