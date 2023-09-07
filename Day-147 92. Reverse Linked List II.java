class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int[] arr = new int[right-left+1];
        int i = 0;
        int j = 0;
        ListNode temp = head;
        // move temp to start (below code is used again)
        while(j < left-1){
            temp = temp.next;
            j++;
        }
        // add values from start to end to arr
        while(j < right){
            arr[i] = temp.val;
            temp = temp.next;
            i++;
            j++;
        }
        // Now arr has [2,3,4] and reset temp and j
        temp = head;
        j = 0;
        // here i=3 arr[3] gives array index out of bounds
        i--;   // so it is i-- now arr[i] is last element in array
        while(j < left-1){
            temp = temp.next;
            j++;
        }
        // time to update values with array elements
        while(j < right){
            temp.val = arr[i];
            temp = temp.next;
            i--;
            j++;
        }
        return head;
    }
}
