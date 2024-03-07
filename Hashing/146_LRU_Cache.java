class LRUCache {
    LinkedHashMap<Integer,Integer>LRU;
    final int MAX;
    public LRUCache(int capacity) {
        LRU = new LinkedHashMap<>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest){
                return size() > MAX;
            }
        };
        MAX = capacity;
    }
    
    public int get(int key) {
        return LRU.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        // if(LRU.size()>MAX)
        //     LRU.removeEldestEntry();
        LRU.put(key,value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 
 
 class LRUCache {
    TreeMap<Integer,Integer>LRU = new TreeMap<>(Collections.reverseOrder());
    int MAX;
    public LRUCache(int capacity) {
        MAX = capacity;
    }
    
    public int get(int key) {
        if(LRU.containsKey(key))
            return LRU.get(key);
        else 
            return -1;
    }
    
    public void put(int key, int value) {
        
        for(Map.Entry entry : LRU.entrySet())
            System.out.println(entry.getKey()+" : "+entry.getValue());
        System.out.println();
        if(LRU.size()>MAX)
            LRU.remove(LRU.lastKey());
        
        LRU.put(key,value);
        
    }
}


 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
 
 

