class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int wStart = 0;
        // There are `nums.length - k + 1` of size k window so assign the space in begining
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> window = new ArrayDeque<>();
        
for(int wEnd = 0 ; wEnd < nums.length; wEnd++) {
            // pop from last all elemnts which are shorter then current elements.
            while(!window.isEmpty() && window.peekLast() < nums[wEnd]) {
                window.removeLast();
            }
            window.add(nums[wEnd]);

            // Window size is K and size is maintained
            if(wEnd >= k - 1) {
                // Alway peek is Max of current window
                result[wStart] = window.peekFirst();
                // When leaving elemet (wStart) is same as Max, make sure to to pop it
                if(window.peekFirst() == nums[wStart]) {
                    window.removeFirst();
                }

                wStart++;
            }


        }

        return result;
    }
}
