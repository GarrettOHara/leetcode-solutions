class Trie {
    public Map<Character,Trie> characters;
    public boolean isWord;
    
    public Trie(){
        characters = new HashMap<>();
        isWord = false;
    }
    
    public void insert(String word) {
        Trie root = this;
        
        for(char c : word.toCharArray()){
            
            root.characters.putIfAbsent(c, new Trie());
            
            root = root.characters.get(c);
        }
        
        root.isWord = true;
    }
    
    public boolean search(String word) {
        Trie root = this;
        
        for(char c : word.toCharArray()){
            
            root = root.characters.get(c);
            
            if(root == null)
                return false;
        }
        return root.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Trie root = this;
        
        for(char c : prefix.toCharArray()){
            
            root = root.characters.get(c);
            
            if(root == null)
                return false;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
