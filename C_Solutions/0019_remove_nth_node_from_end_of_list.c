/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

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
