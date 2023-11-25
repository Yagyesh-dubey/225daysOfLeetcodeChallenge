class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n=nums.length;
        int A=0;
        int B=Arrays.stream(nums).sum();
        int [] ans=new int[n];
        int i=0;
        for(int x : nums){
            ans[i]=(2*i-n)*x+B-A;
            A+=x;
            B-=x;
            i++;
        }
        return ans;   
    }
}
