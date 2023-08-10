class Solution {
    public boolean search(int[] nums, int target) {
        int pivot = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i+1]) {
                pivot = i;
                break;
            }
        }
        int a = binarySearch(nums, 0 , pivot, target);
        if(a >= 0)
            return true;
        a = binarySearch(nums, pivot+1, nums.length - 1, target);
        if(a > 0)
            return true;
        return false;
    }
    int binarySearch(int nums[], int l, int r, int target) {

        while(l <= r) {
            int mid = (l + r)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] < target)
                l = mid + 1;
            else
                r = mid - 1; 
        }
        return -1;
    }
}
