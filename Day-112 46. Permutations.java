class Solution {
    public void fun(List<List<Integer>> ans,ArrayList<Integer> al,int[] arr,int[] vis,int n,int cnt){
        if(al.size()==n){
            ans.add(new ArrayList<>(al));
            return;
        }
        for(int i=0; i<n; i++){
            if(vis[i]==0){
                vis[i] = 1;
                al.add(arr[i]);
                fun(ans,al,arr,vis,n,cnt+1);
                vis[i] = 0;
                al.remove(al.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        int n = nums.length;
        int[] vis = new int[n];
        fun(ans,al,nums,vis,n,0);
        return ans;
        
    }
}
