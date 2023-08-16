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
    public ListNode partition(ListNode head, int x) {
        // Intuition: Partition the given linked list into two separate lists, one for values less than x and
        // another for values greater than or equal to x. Then combine these two lists while maintaining the order.

        ListNode lessThanXHead = new ListNode();  // Head of the list for values less than x
        ListNode lessThanXTail = lessThanXHead;  // Tail of the list for values less than x
        
        ListNode greaterThanOrEqualXHead = new ListNode();  // Head of the list for values greater than or equal to x
        ListNode greaterThanOrEqualXTail = greaterThanOrEqualXHead;  // Tail of the list for values greater than or equal to x
        
        ListNode temp = head;

        // Traverse the original list and partition nodes into the two separate lists
        while (temp != null) {
            int val = temp.val;

            if (val < x) {
                lessThanXTail.next = temp;
                lessThanXTail = lessThanXTail.next;
            } else {
                greaterThanOrEqualXTail.next = temp;
                greaterThanOrEqualXTail = greaterThanOrEqualXTail.next;
            }

            temp = temp.next;
        }

        // Combine the two lists by linking the tail of the lessThanX list to the head of the greaterThanOrEqualX list
        lessThanXTail.next = greaterThanOrEqualXHead.next;
        greaterThanOrEqualXTail.next = null;

        // Return the head of the partitioned list (list for values less than x)
        return lessThanXHead.next;
    }
}
