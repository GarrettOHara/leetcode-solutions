package main

import "fmt"
/**
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
**/
func twoSum(nums []int, target int) []int {
    mem := make(map[int]int)

    for idx, num := range nums {
        if val, found := mem[target - num]; found {
            return []int{idx,val}
        }
        mem[num] = idx
    }
    return nil
}


func main() {
    // Test cases
    tests := []struct {
        nums   []int
        target int
        result []int
    }{
        {[]int{2, 7, 11, 15}, 9, []int{0, 1}},
        {[]int{3, 2, 4}, 6, []int{1, 2}},
        {[]int{3, 3}, 6, []int{0, 1}},
        {[]int{1, 5, 3, 4, 2}, 7, []int{1, 4}}, // Extra case for more coverage
        {[]int{-1, -2, -3, -4, -5}, -8, []int{2, 4}}, // Extra case with negative numbers
    }

    for _, test := range tests {
        result := twoSum(test.nums, test.target)
        fmt.Printf("twoSum(%v, %d) = %v; Expected = %v\n", test.nums, test.target, result, test.result)
    }
}
