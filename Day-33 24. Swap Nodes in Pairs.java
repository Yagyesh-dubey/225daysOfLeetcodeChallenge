class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head; // No need to swap if the list has 0 or 1 node
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        
        while (curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = curr.next.next;
            
            first.next = second.next;
            second.next = first;
            curr.next = second;
            
            curr = first;
        }
        
        return dummy.next;
    }
}
