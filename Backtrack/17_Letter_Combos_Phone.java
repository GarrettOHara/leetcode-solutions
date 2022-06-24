class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer,List<Character>> map = new HashMap<>();
        char c = 'a';
        
        // create ridiculous map
        for(int i = 2; i < 10; i++) {
            
            if(i == 7) {
                map.put(i, new ArrayList<>(Arrays.asList('p','q','r','s')));
                c += 4;
            } else if ( i == 9){
                map.put(i, new ArrayList<>(Arrays.asList('w','x','y','z')));
                break;
            } else {
                map.put(i, new ArrayList<>());
                for(int j = 0; j < 3; j++) {
                    map.get(i).add(c);
                    c++;
                }
            }
        }
        
        // print map to show correctness
        for(Map.Entry<Integer,List<Character>> entry : map.entrySet()) {
            System.out.print(entry.getKey()+": ");
            for(char letter : entry.getValue()){
                System.out.print(letter+" ");
            }

            System.out.println();
        }
        
        List<String> res = new ArrayList<>();
        
        // start backtracking
        for(char letter : digits.toCharArray()) {
            res.add(backtracking(map, digits, letter, res));
        }
        
        return new ArrayList<>();
    }
    
    private String backtracking()
}
