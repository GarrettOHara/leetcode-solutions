/**
Given a string s, find the length of the longest substring without repeating 
characters.
===============================================================================
Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
-------------------------------------------------------------------------------
Example 2:
Input: s = "bbbbb"
Output: 1

Explanation: The answer is "b", with the length of 1.
-------------------------------------------------------------------------------
Example 3:
Input: s = "pwwkew"
Output: 3

Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a 
substring.
===============================================================================
Constraints:

    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.
**/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return max;
    }
}

/**
Time Complexity:  O (n^2)
Space Complexity: O (n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;

        for (int left = 0; left < s.length(); left++) {
            Set<Character> set = new HashSet<>();
            int curr = 0;
            for(int right = left; right < s.length(); right++) {
                if (set.add(s.charAt(right))) {
                    curr++;
                } else {
                    break;
                }
            }
            max = Math.max(max, curr);
        }

        return max;
    }
}
 */
