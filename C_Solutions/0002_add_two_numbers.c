#include <stdio.h>
#include <stdlib.h>

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

struct ListNode {
    int val;
    struct ListNode *next;
};

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

// Function to print the linked list
void printList(struct ListNode* head) {
    struct ListNode* temp = head;
    while (temp != NULL) {
        printf("%d ", temp->val);
        temp = temp->next;
    }
    printf("\n");
}

int main() {
    // Test Case 1
    struct ListNode* l1 = newNode(2);
    l1->next = newNode(4);
    l1->next->next = newNode(3);

    struct ListNode* l2 = newNode(5);
    l2->next = newNode(6);
    l2->next->next = newNode(4);

    printf("Test Case 1: ");
    printList(addTwoNumbers(l1, l2));

    // Test Case 2
    struct ListNode* l3 = newNode(0);
    struct ListNode* l4 = newNode(0);

    printf("Test Case 2: ");
    printList(addTwoNumbers(l3, l4));

    // Test Case 3
    struct ListNode* l5 = newNode(9);
    l5->next = newNode(9);
    l5->next->next = newNode(9);
    l5->next->next->next = newNode(9);
    l5->next->next->next->next = newNode(9);
    l5->next->next->next->next->next = newNode(9);
    l5->next->next->next->next->next->next = newNode(9);

    struct ListNode* l6 = newNode(9);
    l6->next = newNode(9);
    l6->next->next = newNode(9);
    l6->next->next->next = newNode(9);

    printf("Test Case 3: ");
    printList(addTwoNumbers(l5, l6));

    return 0;
}
