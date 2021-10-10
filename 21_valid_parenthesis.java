class Solution {
    public boolean isValid(String s) {
      HashMap<Character,Character> map = new HashMap<Character,Character>(){{
        put('}','{');
        put(']','[');
        put(')','(');
      }};
      Stack<Character>stack = new Stack<>();

      for(char c : s.toCharArray()) {
        if(!map.containsKey(c))
          stack.push(c);
        else{

          if(stack.isEmpty()) 
            return false;
          else if(map.get(c) == stack.peek())
            stack.pop();
          else
            return false;
        }

      }
      if(stack.isEmpty())
        return true;
      else 
        return false;
    }
}



/*
   JAVA solution 
TIME:  O(N)
SPACE: O(N)
HashMap<Character,Character> map = new HashMap<Character,Character>(){{
put('}','{');
put(']','[');
put(')','(');
}};
Stack<Character>stack = new Stack<>();

for(char c : s.toCharArray()) {
if(!map.containsKey(c))
stack.push(c);
else{

if(stack.isEmpty()) 
return false;
else if(map.get(c) == stack.peek())
stack.pop();
else
return false;
}

}
if(stack.isEmpty())
return true;
else 
return false;
*/
