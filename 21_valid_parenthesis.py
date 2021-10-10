"""
Python 2 Solution 
(Slow)
"""
class Solution(object):
    def isValid(self, s) -> bool:
        """
        :type s: str
        :rtype: bool
        """
        
        dic = {'}':'{',')':'(',']':'['}
        stack = []
        
        for c in s:
            if c not in dic:
                stack.append(c)
            else:
                if not stack:
                    return False
                if dic.get(c) == stack[-1]:
                    stack.pop()
                else:
                    return False
                
        if not stack:
            return True
        else:
            return False
