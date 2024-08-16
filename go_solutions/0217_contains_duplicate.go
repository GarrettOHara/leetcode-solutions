/**
Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true

Example 2:
Input: nums = [1,2,3,4]
Output: false

Example 3:
Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
**/
package main

import (
    "fmt"
)

func containsDuplicate(nums []int) bool {
   m := make(map[int]bool)
   for _, num := range nums {
        if _, found := m[num]; found {
            return true
        }
        m[num] = true
   }
   return false
}

func main() {

    // Test cases
    tests := []struct {
        nums   []int
        result bool
    }{
        {[]int{1, 2, 3, 1}, true},
        {[]int{1, 2, 3, 4}, false},
        {[]int{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}, true},
        {[]int{5, 6, 7, 8, 9, 10}, false},  // No duplicates
        {[]int{1, 1, 2, 2, 3, 3}, true},   // Multiple duplicates
        {[]int{}, false},                   // Edge case: empty array
        {[]int{42}, false},                 // Edge case: single element
    }

    for _, test := range tests {
        result := containsDuplicate(test.nums)
        fmt.Printf("containsDuplicate(%v) = %v; Expected = %v\n", test.nums, result, test.result)
    }
}
