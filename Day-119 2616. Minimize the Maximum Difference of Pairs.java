class Solution {
    public int minimizeMax(int[] v, int p) {
        int n=v.length;
        Arrays.sort(v); // sort to get minimum differences
        
		//binary search logic
        int lo=-1,hi=1000000007;
        while(lo<hi-1){
            int mid=lo+(hi-lo)/2;
            int a=0; // to count total possible pairs if mid is the max value
            for(int i=1;i<n;i++){
                if(v[i]-v[i-1]<=mid){ // counting only if difference is <= mid
                    i++;
                    a++;
                }
            }
            if(a>=p){
                hi=mid;// store the last possible value in hi
            }
            else lo=mid;
        }
        return hi;
    }
}
