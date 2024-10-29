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
	"testing"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

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

func TestReverseList(t *testing.T) {
	testCases := []struct {
		head       *ListNode
		execpected *ListNode
	}
}
