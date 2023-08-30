class Solution {
    public long minimumReplacement(int[] nums) 
    {
        long ans = 0, limit = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--)
        {
            if (nums[i] <= lim)
                limit = nums[i];
            else
            {
                long partitions = nums[i] / limit + ((nums[i] % limit != 0) ? 1 : 0);
                limit = nums[i] / partitions;
                ans += partitions - 1;
            }
        }
        return ans;
    }
}
