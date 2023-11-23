class Solution {

    static boolean check(int arr[]){
        int n = arr.length;

        if(n==1) return true;

        Arrays.sort(arr);

        int diff = arr[1]-arr[0];

        for(int i=1; i<n; i++){
            if(arr[i]-arr[i-1]!=diff) return false;
        }

        return true;
    }
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {

        ArrayList<Boolean> ans = new ArrayList<>();
        
        for(int i=0; i<l.length; i++){
            int n = r[i]-l[i]+1;
            int arr[] = new int[n];
            int idx = 0;

            for(int j=l[i]; j<=r[i]; j++){
                arr[idx++] = nums[j];
            }
            if(check(arr)) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
}
