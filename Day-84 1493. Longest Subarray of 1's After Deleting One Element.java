class Solution {
    public int longestSubarray(int[] nums) {
        int num_of_zeros_allowed = 1;
        int left_ptr = 0;
        int right_ptr = 0;

        for (right_ptr = 0; right_ptr < nums.length; right_ptr++) {
            boolean is_zero = nums[right_ptr] == 0;
            num_of_zeros_allowed -= is_zero ? 1 : 0;

            if (num_of_zeros_allowed < 0) {
                boolean is_zero_left = nums[left_ptr] == 0;
                num_of_zeros_allowed += is_zero_left ? 1 : 0;
                left_ptr += 1;
            }
        }

        return right_ptr - left_ptr;
    }
}
