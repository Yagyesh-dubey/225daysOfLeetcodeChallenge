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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode firstNode=head,secondNode=head;

        for(int i=1;i<k;i++)
        {
            firstNode=firstNode.next;
        }

        ListNode curr=firstNode;

        while(curr.next!=null)
        {
            curr=curr.next;
            secondNode=secondNode.next;
        }

        int a=secondNode.val;
        secondNode.val=firstNode.val;
        firstNode.val=a;


        return head;
    }
}
