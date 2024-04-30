/**
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Examples:
    Example 1:
    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.
    
    Example 2:
    Input: l1 = [0], l2 = [0]
    Output: [0]
    
    Example 3:
    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]

Big O Notation:
    Time: O(max(m, n))  where m, n are lengths of l1 and l2 respectively
    Space: O(max(m, n))
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* newNode(int sum) {
    struct ListNode* node = (struct ListNode*) malloc(sizeof(struct ListNode));
    node->val = sum;
    node-> next = NULL;

    return node;
}

struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    struct ListNode* head = NULL;
    struct ListNode* curr = NULL;

    int carry = 0;
    while (l1 || l2 || carry != 0) {
        int sum = carry;
        if (l1) {
            sum += l1->val;
            l1 = l1->next;
        }
        if (l2) {
            sum += l2->val;
            l2 = l2->next;
        }

        carry = sum / 10;
        sum %= 10;

        if(!head) {
            head = newNode(sum);
            curr = head;
        } else {
            curr->next = newNode(sum);
            curr = curr->next;
        }
    }
    return head;
}
