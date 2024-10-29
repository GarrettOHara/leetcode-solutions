/*
MEDIUM

Given an integer array nums, return an array answer such that answer[i] is
equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a
32-bit integer.
You must write an algorithm that runs in O(n) time and without using the
division operation.

Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
*/
package main

import (
	"fmt"
	"reflect"
	"testing"
	"time"
)

func productExceptSelfBruteForce(nums []int) []int {
	copy := make([]int, len(nums))

	for i, _ := range nums {
		copy[i] = 1
	}

	for i, _ := range nums {
		for j, n := range nums {
			if i == j {
				continue
			}
			copy[i] *= n
		}
	}

	return copy
}

func productExceptSelf(nums []int) []int {
	copy := make([]int, len(nums))

	product, tmp, zeros := 1, 1, 0

	for _, num := range nums {
		if num == 0 {
			zeros += 1
		} else {
			tmp *= num
		}

		product *= num
	}

	for i, num := range nums {
		if zeros > 1 {
			copy[i] = product
		} else if num != 0 {
			copy[i] = product / num
		} else {
			copy[i] = tmp
		}
	}

	return copy
}

// Helper function to generate a large test case with sequential numbers
func generateLargeTestCaseProduct(size int) []int {
	nums := make([]int, size)
	for i := range nums {
		nums[i] = i + 1 // Use sequential values from 1 to size
	}
	return nums
}

// Helper function to generate the expected output for the large test case
func generateLargeResult(size int) []int {
	result := make([]int, size)
	product := 1
	for i := 1; i <= size; i++ {
		product *= i
	}
	for i := range result {
		if i == 0 {
			result[i] = product
		} else {
			result[i] = product / (i + 1)
		}
	}
	return result
}

func TestProductExceptSelf(t *testing.T) {
	tests := []struct {
		name   string
		nums   []int
		result []int
	}{
		{"Example 1", []int{1, 2, 3, 4}, []int{24, 12, 8, 6}},
		{"Example 2", []int{-1, 1, 0, -3, 3}, []int{0, 0, 9, 0, 0}},
		{"Large Case 1", generateLargeTestCaseProduct(1000), generateLargeResult(1000)},
		{"Large Case 2", generateLargeTestCaseProduct(10000), generateLargeResult(10000)},
	}

	fmt.Printf("\n\nProduct Except Self Optimal:\n")
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			start := time.Now()
			got := productExceptSelf(test.nums)
			duration := time.Since(start)

			if !reflect.DeepEqual(got, test.result) {
				t.Errorf("productExceptSelf(%v) = %v; want %v", test.nums, got, test.result)
			}
			t.Logf("Execution time for %s: %v", test.name, duration)
		})
	}

	fmt.Printf("\n\nProduct Except Self Brute Force:\n")
	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			start := time.Now()
			got := productExceptSelfBruteForce(test.nums)
			duration := time.Since(start)

			if !reflect.DeepEqual(got, test.result) {
				t.Errorf("productExceptSelfBruteForce(%v) = %v; want %v", test.nums, got, test.result)
			}
			t.Logf("Execution time for %s: %v", test.name, duration)
		})
	}

}
