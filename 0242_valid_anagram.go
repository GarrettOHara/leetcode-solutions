/**
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
**/
package main


func isAnagram(s string, t string) bool {
    m := make(map[rune]int)
    for _, char := range s {
        if val, found := m[char]; found {
            m[char] = val + 1
        } else {
            m[char] = 1
        }
    }

    for _, char := range t {
        if val, found := m[char]; found {
            if val <= 1 {
                delete(m, char)
            } else {
                m[char] = val - 1
            }
        } else {
            return false
        }
    }

    return len(m) == 0
}

func isAnagramOptimal(s string, t string) bool {
    if len(s) != len(t) { return false }

    var freq [26]int

    for i := 0; i < len(s); i++ {
        freq[s[i]-'a']++
        freq[t[i]-'a']--
    }

    for i := 0; i < len(freq); i++ {
        if(freq[i] != 0) {
            return false
        }
    }

    return true

