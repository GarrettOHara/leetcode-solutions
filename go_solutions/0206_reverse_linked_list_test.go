/*
Given the head of a singly linked list, reverse the list, and return
the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []
*/
package main

import (
	"fmt"
	"reflect"
	"testing"
	"time"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

// Reverse the linked list in constant space
func reverseList(head *ListNode) *ListNode {
	var next *ListNode
	var prev *ListNode
	curr := head

	for curr != nil {
		next = curr.Next
		curr.Next = prev
		prev = curr
		curr = next
	}

	return prev
}

// Reverse the linked list in non-constant space
func reverseListLessOptimal(head *ListNode) *ListNode {
	if head == nil {
		return nil
	}

	// Create a slice to hold the values of the original list
	values := []int{}
	curr := head

	// Traverse the linked list and store values in the slice
	for curr != nil {
		values = append(values, curr.Val)
		curr = curr.Next
	}

	// Create a new list with the values in reverse order
	dummyHead := &ListNode{}
	reversedCurr := dummyHead

	// Add values to the new list in reverse order
	for i := len(values) - 1; i >= 0; i-- {
		reversedCurr.Next = &ListNode{Val: values[i]}
		reversedCurr = reversedCurr.Next
	}

	return dummyHead.Next
}

// Helper function to create a linked list from a slice
func createLinkedList(values []int) *ListNode {
	if len(values) == 0 {
		return nil
	}

	head := &ListNode{Val: values[0]}
	current := head
	for _, val := range values[1:] {
		current.Next = &ListNode{Val: val}
		current = current.Next
	}
	return head
}

// Helper function to convert linked list to slice
func linkedListToSlice(head *ListNode) []int {
	result := []int{}
	for current := head; current != nil; current = current.Next {
		result = append(result, current.Val)
	}
	return result
}

// Helper function to generate a sequential list of integers
func generateSequentialList(n int) []int {
	list := make([]int, n)
	for i := 0; i < n; i++ {
		list[i] = i + 1 // Start from 1
	}
	return list
}

// Helper function to generate a reversed list of integers
func generateReversedList(n int) []int {
	list := make([]int, n)
	for i := 0; i < n; i++ {
		list[i] = n - i // Reverse order
	}
	return list
}

func TestReverseList(t *testing.T) {
	tests := []struct {
		input    []int
		expected []int
	}{
		// Test case 1: Multiple nodes
		{input: []int{1, 2, 3, 4, 5}, expected: []int{5, 4, 3, 2, 1}},

		// Test case 2: Two nodes
		{input: []int{1, 2}, expected: []int{2, 1}},

		// Test case 3: Single node
		{input: []int{1}, expected: []int{1}},

		// Test case 4: Empty list
		{input: []int{}, expected: []int{}},

		// Stress test cases
		{input: generateSequentialList(100), expected: generateReversedList(100)},
		{input: generateSequentialList(1000), expected: generateReversedList(1000)},
		{input: generateSequentialList(10000), expected: generateReversedList(10000)},
		{input: generateSequentialList(100000), expected: generateReversedList(100000)},
	}

	fmt.Printf("\n\nConstant space:\n")
	for _, test := range tests {
		inputList := createLinkedList(test.input)
		expectedList := createLinkedList(test.expected)

		start := time.Now()
		reversedList := reverseList(inputList)
		duration := time.Since(start)
		reversedListSlice := linkedListToSlice(reversedList)
		expectedListSlice := linkedListToSlice(expectedList)

		if !reflect.DeepEqual(reversedListSlice, expectedListSlice) {
			t.Errorf("For input %v\n\texpected %v\n\treturned %v", test.input, test.expected, reversedListSlice)
		} else {
			if len(test.input) > 10 {
				// Log duration and input length with aligned formatting
				t.Logf("%-25s %-15s", fmt.Sprintf("Duration: %v", duration), fmt.Sprintf("Input len: %d", len(test.input)))
			} else {
				// Log duration, input, and expected result with aligned formatting
				t.Logf("%-25s %-20s %-25s", fmt.Sprintf("Duration: %v", duration), fmt.Sprintf("For n = %v", test.input), fmt.Sprintf("Expected result: %v", test.expected))
			}
		}
	}

	fmt.Printf("\n\nNon-constant space:\n")
	for _, test := range tests {
		inputList := createLinkedList(test.input)
		expectedList := createLinkedList(test.expected)

		start := time.Now()
		reversedList := reverseListLessOptimal(inputList)
		duration := time.Since(start)
		reversedListSlice := linkedListToSlice(reversedList)
		expectedListSlice := linkedListToSlice(expectedList)

		if !reflect.DeepEqual(reversedListSlice, expectedListSlice) {
			t.Errorf("For input %v\n\texpected %v\n\treturned %v", test.input, test.expected, reversedListSlice)
		} else {
			if len(test.input) > 10 {
				// Log duration and input length with aligned formatting
				t.Logf("%-25s %-15s", fmt.Sprintf("Duration: %v", duration), fmt.Sprintf("Input len: %d", len(test.input)))
			} else {
				// Log duration, input, and expected result with aligned formatting
				t.Logf("%-25s %-20s %-25s", fmt.Sprintf("Duration: %v", duration), fmt.Sprintf("For n = %v", test.input), fmt.Sprintf("Expected result: %v", test.expected))
			}
		}
	}
}
