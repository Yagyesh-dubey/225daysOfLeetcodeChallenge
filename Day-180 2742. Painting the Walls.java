class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n=cost.length;
    Map<Long,Long> mp=new HashMap<>();
    return (int)solve(cost,time,0,n,0,0,mp);
    }
    public long solve(int[] cost,int[] time,int i,int n,int t,int count,Map<Long,Long> mp){
         if(t>=n-count)return 0;
         if(i==n)return Integer.MAX_VALUE;
       // generating unique key for each unique i and t and count.
         long key=(long)(i*10001)+(long)(t*10001)+(long)(count*10001)+i;
         if(mp.containsKey(key))return mp.get(key);

         long ans= Math.min((long)cost[i]+solve(cost,time,i+1,n,t+time[i],count+1,mp),solve(cost,time,i+1,n,t,count,mp));
         mp.put(key,ans);
         return ans;
    }
}
