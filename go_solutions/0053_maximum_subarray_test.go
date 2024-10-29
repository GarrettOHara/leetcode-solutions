/*
Given an integer array nums, find the
subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
*/
package main

import (
	"testing"
	"time"
)

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func maxSubArrayKadaneAlgorithm(nums []int) int {
	res, sum := -100000, 0

	for _, num := range nums {
		sum += num
		if sum > res {
			res = sum
		}
		if sum < 0 {
			sum = 0
		}
	}
	return res
}

func maxSubArrayTwoPointers(nums []int) int {
	if len(nums) == 0 {
		return 0
	}

	dpA := nums[0]
	dpB := -10000
	res := max(dpA, dpB)

	for i := 1; i < len(nums); i++ {
		dpB = max(dpA+nums[i], nums[i])
		dpA = dpB
		res = max(dpB, res)
	}

	return res
}

func maxSubArrayQuadratic(nums []int) int {
	max_product := nums[0]

	for i, _ := range nums {
		prod := 0
		for _, n := range nums[i:] {
			prod += n
			if prod > max_product {
				max_product = prod
			}
		}
	}
	return max_product
}

func maxSubArrayTabulation(nums []int) int {
	n := len(nums)
	tab := make([]int, n)
	tab[0] = nums[0]

	res := nums[0]
	for i := 1; i < n; i++ {
		tab[i] = max(tab[i-1]+nums[i], nums[i])

		if tab[i] > res {
			res = tab[i]
		}
	}

	return res
}

func maxSubArrayKadaneAlgorithmRewrite(nums []int) int {
	n := len(nums)
	if n == 0 {
		return 0
	}

	res := nums[0]
	sum := 0

	for i := 0; i < n; i++ {
		sum += nums[i]
		res = max(res, sum)

		if sum < 0 {
			sum = 0
		}
	}

	return res
}

func TestMaxSubArray(t *testing.T) {
	testCases := []struct {
		nums     []int
		expected int
	}{
		{
			nums:     []int{-2, 1, -3, 4, -1, 2, 1, -5, 4},
			expected: 6, // Subarray [4,-1,2,1] has the largest sum 6.
		},
		{
			nums:     []int{1},
			expected: 1, // Single element array.
		},
		{
			nums:     []int{5, 4, -1, 7, 8},
			expected: 23, // Subarray [5,4,-1,7,8] has the largest sum 23.
		},
		{
			nums:     []int{-1, -2, -3, -4},
			expected: -1, // All negative, the largest sum is the largest single element.
		},
		{
			nums:     []int{0, -3, 1, 1, -1, 2, -2, 5},
			expected: 6, // Subarray [1,1,-1,2,-2,5] has the largest sum 6.
		},
		// Stress test case with a large array
		{
			nums:     generateLargeTestCase(1000000),                                    // Generate a large test case
			expected: maxSubArrayKadaneAlgorithmRewrite(generateLargeTestCase(1000000)), // Calculate expected using Kadane's Rewrite
		},
	}

	for _, tc := range testCases {
		t.Run("KadaneAlgorithm", func(t *testing.T) {
			start := time.Now()
			result := maxSubArrayKadaneAlgorithm(tc.nums)
			duration := time.Since(start)

			if result != tc.expected {
				t.Errorf("maxSubArrayKadaneAlgorithm(%v) = %d; want %d", tc.nums, result, tc.expected)
			}
			t.Logf("KadaneAlgorithm took %s", duration)
		})

		t.Run("TwoPointers", func(t *testing.T) {
			start := time.Now()
			result := maxSubArrayTwoPointers(tc.nums)
			duration := time.Since(start)

			if result != tc.expected {
				t.Errorf("maxSubArrayTwoPointers(%v) = %d; want %d", tc.nums, result, tc.expected)
			}
			t.Logf("TwoPointers took %s", duration)
		})

		t.Run("Quadratic", func(t *testing.T) {
			start := time.Now()
			result := maxSubArrayQuadratic(tc.nums)
			duration := time.Since(start)

			if result != tc.expected {
				t.Errorf("maxSubArrayQuadratic(%v) = %d; want %d", tc.nums, result, tc.expected)
			}
			t.Logf("Quadratic took %s", duration)
		})

		t.Run("Tabulation", func(t *testing.T) {
			start := time.Now()
			result := maxSubArrayTabulation(tc.nums)
			duration := time.Since(start)

			if result != tc.expected {
				t.Errorf("maxSubArrayTabulation(%v) = %d; want %d", tc.nums, result, tc.expected)
			}
			t.Logf("Tabulation took %s", duration)
		})

		t.Run("KadaneAlgorithmRewrite", func(t *testing.T) {
			start := time.Now()
			result := maxSubArrayKadaneAlgorithmRewrite(tc.nums)
			duration := time.Since(start)

			if result != tc.expected {
				t.Errorf("maxSubArrayKadaneAlgorithmRewrite(%v) = %d; want %d", tc.nums, result, tc.expected)
			}
			t.Logf("KadaneAlgorithmRewrite took %s", duration)
		})
	}
}

// generateLargeTestCase generates a large test case for stress testing.
func generateLargeTestCase(size int) []int {
	nums := make([]int, size)
	for i := 0; i < size; i++ {
		// Randomly generate values between -1000 and 1000
		nums[i] = (i % 2000) - 1000 // This creates a pattern to simulate variability
	}
	return nums
}
