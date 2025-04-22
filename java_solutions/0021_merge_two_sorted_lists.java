/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made 
by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]

Constraints:
The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // return iterative(list1, list2);
        return recursive(list1, list2);
    }

    private ListNode recursive(ListNode list1, ListNode list2) {
        // Case 1: List1 is null/empty
        if (list1 == null) {
            return list2;
        }
        // Case 2: List 2 is null/empty
        if (list2 == null) {
            return list1;
        }

        // Case 3: List1 head < list2 head
        if (list1.val < list2.val) {
            list1.next = recursive(list1.next, list2);
            return list1;
        // Case 4: List2 head < list1 head
        } else {
            list2.next = recursive(list1, list2.next);
            return list2;
        }

        /**
        First Try on Recursive Algo:

            if (list1 != null && list2 != null) {
                return list1.val < list2.val ?
                    recursive(list1.next, list2) :
                    recursive(list1, list2.next);
            }

            if (list1 != null) {
                return recursive(list1.next, list2);
            } else if (list2 != null) {
                return recursive(list1, list2.next);
            } else {
                return null;
            }
        **/
    }

    private ListNode iterative(ListNode list1, ListNode list2) {
        // Working pointer
        ListNode curr = new ListNode();
        // Pointer of beginning of list to return later
        ListNode res = curr;

        // Iterate while both lists are NON-null
        while(list1 != null || list2 != null) {

            // Case 1: Both lists have NON-null heads
            if (list1 != null && list2 != null) {
                // Case 1A: List1 head is < List2 head
                if (list1.val < list2.val) {
                    curr.next = new ListNode(list1.val);
                    list1 = list1.next;
                // Case 1B: List2 head is < List1 head
                } else {
                    curr.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
            }

            // Case 2: List1 is NULL
            else if (list1 == null) {
                curr.next = new ListNode(list2.val);
                list2 = list2.next;

            // Case 3: List 2 is NULL
            } else {
                curr.next = new ListNode(list1.val);
                list1 = list1.next;
            }

            // Iterate curr pointer
            curr = curr.next;
        }

        // Return pointer of the beginning of the new merged list 
        return res.next;
    }
}
