#include <stdio.h>
#include <stdlib.h>

/**
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]

Constraints:
    The number of nodes in the list is sz.
    1 <= sz <= 30
    0 <= Node.val <= 100
    1 <= n <= sz
**/

struct ListNode {
    int val;
    struct ListNode *next;
};

struct ListNode* newNode(int val) {
    struct ListNode* node = (struct ListNode*) malloc(sizeof(struct ListNode));
    node->val = val;
    node->next = NULL;
    return node;
}

struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    struct ListNode* ptr = newNode(0);
    ptr->next = head;
    struct ListNode* fast = ptr;
    struct ListNode* slow = ptr;

    int i;
    for(i = 0; i < n+1; i++)
        fast = fast->next;

    while(fast) {
        fast = fast->next;
        slow = slow->next;
    }

    slow->next = slow->next->next;

   return ptr->next;
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
    struct ListNode* head1 = newNode(1);
    head1->next = newNode(2);
    head1->next->next = newNode(3);
    head1->next->next->next = newNode(4);
    head1->next->next->next->next = newNode(5);
    int n1 = 2;
    printf("Test Case 1: ");
    printList(removeNthFromEnd(head1, n1));

    // Test Case 2
    struct ListNode* head2 = newNode(1);
    int n2 = 1;
    printf("Test Case 2: ");
    printList(removeNthFromEnd(head2, n2));

    // Test Case 3
    struct ListNode* head3 = newNode(1);
    head3->next = newNode(2);
    int n3 = 1;
    printf("Test Case 3: ");
    printList(removeNthFromEnd(head3, n3));

    return 0;
}
