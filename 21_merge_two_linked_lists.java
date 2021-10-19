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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if(l1==null)return l2;
      if(l2==null)return l1;

      if(l1.val<l2.val){
        l1.next = mergeTwoLists(l1.next,l2);
        return l1;
      } else {
        l2.next = mergeTwoLists(l1,l2.next);
        return l2;
      }
    }
}

/*


O(1) memory
O(n) time

Recursive Solution
    if(l2==null)return l1;
    if(l1==null)return l2;
    if(l1.val<l2.val) {
        l1.next = mergeTwoLists(l1.next, l2);
        return l1;
    } else {
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }

O(n) memory
O(n) complexity

Readable Iterative Solution
    if(l1==null)return l2;
    if(l2==null)return l1;
    ListNode ref = new ListNode(0);
    ListNode curr = ref;
    while(l1!=null && l2!=null){
        if(l1.val<=l2.val){
            curr.next = l1;
            l1 = l1.next;
        } else {
            curr.next = l2;
            l2 = l2.next;
        }
        curr = curr.next;
    }
    if(l1==null)
        curr.next = l2;
    else
        curr.next = l1;

    return ref.next;
*/
