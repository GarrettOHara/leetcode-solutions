package main

import (
    "fmt"
)
/**
Given two strings s and t, return true if t is an anagram of s, and false
otherwise. An Anagram is a word or phrase formed by rearranging the letters
of a different word or phrase, typically using all the original letters
exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false
**/


func isAnagram1(s string, t string) bool {
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

func isAnagram2(s string, t string) bool {
    if(len(s) != len(t)) {
        return false
    }

    letters := make(map[rune]int)

    for _, ch := range(s) {
        letters[ch]++
    }

    for _, ch := range(t) {
        // Retreive letter:frequency
        val, exists := letters[ch]

        // Check if letter exists and decrement
        if exists && val > 1 {
            letters[ch]--
        // If last occurance, delete key
        } else if exists {
            delete(letters, ch)

        // Doesn't exist
        } else {
            return false
        }
    }

    // All letters:frequency used in interation
    return len(letters) == 0;
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
}

func main() {
    // Test cases
    tests := []struct {
        s, t   string
        result bool
    }{
        {"anagram", "nagaram", true},
        {"rat", "car", false},
        {"listen", "silent", true},
        {"evil", "vile", true},
        {"fluster", "restful", true},
        {"hello", "world", false},
        {"", "", true},           // Edge case: both empty strings
        {"a", "a", true},         // Edge case: single character, same
        {"a", "b", false},        // Edge case: single character, different
        {"abc", "ab", false},     // Edge case: different lengths
    }

    for _, test := range tests {
        result := isAnagram1(test.s, test.t)
        fmt.Printf("isAnagram1(%q, %q) = %v\n", test.s, test.t, result)

        result = isAnagram2(test.s, test.t)
        fmt.Printf("isAnagram2(%q, %q) = %v\n", test.s, test.t, result)

        result = isAnagramOptimal(test.s, test.t)
        fmt.Printf("isAnagramOptimal(%q, %q) = %v\n", test.s, test.t, result)
    }
}
