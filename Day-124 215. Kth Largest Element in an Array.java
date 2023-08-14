class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int fromLast = nums.length - k;
        return nums[fromLast];

    }
}
