package main

import (
    "fmt"
)

func isAnagram(s string, t string) bool {
    if len(s) != len(t) {
        return false
    }

    var freq [26]int

    for idx := 0; idx < len(s); idx++ {
        freq[s[idx] - 'a']++
        freq[t[idx] - 'a']--
    }

    for idx := 0; idx < len(freq); idx++ {
        if freq[idx] != 0 {
            return false
        }
    }

    return true
}

func isAnagram_garrett(s string, t string) bool {
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
        result := isAnagram(test.s, test.t)
        fmt.Printf("isAnagram(%q, %q) = %v\n", test.s, test.t, result)
    }
}
