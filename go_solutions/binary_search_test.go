package main

import (
	"testing"
)

func binary_search(arr []int, lo, hi, target int) int {
	if lo > hi {
		return -1
	}

	mid := lo + (hi-lo)/2 // Correctly calculate the middle index

	if arr[mid] == target {
		return mid
	}

	if target < arr[mid] {
		return binary_search(arr, lo, mid-1, target)
	} else {
		return binary_search(arr, mid+1, hi, target)
	}
}

func TestBinarySearch(t *testing.T) {
	tests := []struct {
		arr    []int
		target int
		expect int
	}{
		{arr: []int{1, 2, 3, 4, 5, 6, 7, 8, 9}, target: 5, expect: 4},   // Target found
		{arr: []int{1, 2, 3, 4, 5, 6, 7, 8, 9}, target: 1, expect: 0},   // Target found at start
		{arr: []int{1, 2, 3, 4, 5, 6, 7, 8, 9}, target: 9, expect: 8},   // Target found at end
		{arr: []int{1, 2, 3, 4, 5, 6, 7, 8, 9}, target: 10, expect: -1}, // Target not found
		{arr: []int{1, 2, 3, 4, 5, 6, 7, 8, 9}, target: 0, expect: -1},  // Target less than min
		{arr: []int{1, 2, 3, 4, 5, 6, 7, 8, 9}, target: -1, expect: -1}, // Target negative
	}

	for _, test := range tests {
		result := binary_search(test.arr, 0, len(test.arr)-1, test.target)
		if result != test.expect {
			t.Errorf("binary_search(%v, %d) = %d; expected %d", test.arr, test.target, result, test.expect)
		}
	}
}
