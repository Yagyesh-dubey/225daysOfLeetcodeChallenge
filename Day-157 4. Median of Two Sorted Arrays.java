class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m =nums2.length;
        int k=0;int j=0;
        int arr[]=new int [n+m];
        for(int i=0;i<n+m;i++){
            if(k<n&&j<m){
                if(nums1[k]<nums2[j]){
                    arr[i]=nums1[k];
                    k++;
                }else{
                    arr[i]=nums2[j];
                    j++;
                }
            }else if(k<n){
                arr[i]=nums1[k];
                k++;
            }else if(j<m){
                arr[i]=nums2[j];
                j++;
            }
        }
        double ans=0.0;
        if((m+n)%2==0){
            ans=(double)(arr[(n+m)/2]+arr[((n+m)/2)-1])/2;
        }else{
            ans=(double)(arr[(n+m)/2]);
        }
        return ans;
    }
}
