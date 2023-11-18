class Solution {
    public int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        long ans = 0;
        int n = arr.length;

        long sum = 0;
        int l=0,r=0;
        while(r<n){
            sum += arr[r];

            while(arr[r]*(r-l+1)>sum+k){
                sum -= arr[l];
                l++;
            }
            ans = Math.max(ans,r-l+1);
            r++;
        }
        return (int)ans;
    }
}
