class Solution {
    public int arraySign(int[] nums) {
        int product=1;

        int size=nums.length;

        for(int i=0;i<size;i++)
        {
            if(nums[i]<0) product*=-1;
            if(nums[i]==0) product*=0;
        }
        return product;
    }
}
