import java.util.*;
class Solution {
    public String removeKdigits(String num, int k) {
       if(num.length()==k)
           return "0";
        
        Stack<Character>stack = new Stack<>();
        
        
        int i = 0;
        while(i < num.length()){
            char c = num.charAt(i);
            while(k>0 && !stack.isEmpty() && c<stack.peek()){
                stack.pop();
                k--;
            }
            stack.push(c);
            i++;
        }
        
        
        while(k>0){
            stack.pop();
            k--;
        }
        
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();
        
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        
        return sb.toString();
    } 
}
    
    
    
    /**
         if(k==num.length())
                return "0";
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i <= num.length()-k; i++){
            String str = num.substring(0,i);
            str += num.substring(i+k,num.length());
            int res = Integer.parseInt(str);
            min = Math.min(min,res);
        }
        // System.
        return Integer.toString(min);
    }
    
    
    
     PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(char c : num.toCharArray())
            pq.offer((int)c);
        
        StringBuilder str = new StringBuilder(num);
        List<Integer>list = new ArrayList<>();
        for(int i = 0; i < k; i++)
            list.add(pq.poll());
        
        for(int i = 0; i < num.length();i++){
            if(k==0)
                break;
            char c = num.charAt(i);
            if(list.contains((int)c)){
                k--;
                //str.deleteCharAt(i);
                str.replaceFirst(c, "");
            }
        }
        
        return str.toString();
    **/
