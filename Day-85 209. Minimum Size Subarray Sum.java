class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int sum =0;
        int res =Integer.MAX_VALUE;
        while(j<nums.length)
        {
            sum=sum+nums[j];
            if(sum<target)
            {
                j++;
            }
            else if(sum==target)
            {
                res=Math.min(res,j-i+1);
                j++;
            }
            else if(sum>target)
            {
                while(sum>target)
                {
                    res=Math.min(res,j-i+1);
                    sum=sum-nums[i];
                    i++;
                }
                if(sum==target)
                {
                    res=Math.min(res,j-i+1);
                }
                j++;
            }
        }
        if(res==Integer.MAX_VALUE)
        {
            return 0;
        }
        return res;
        
    }
}
