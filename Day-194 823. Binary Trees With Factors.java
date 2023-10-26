class Solution {
    public int nextFact(int[] arr, int numI, int prevI){
        int limit = (int)Math.sqrt(arr[numI]);
        for(int i = prevI + 1; i < numI; i++){
            if(arr[i] > limit) break;
            if(arr[numI] % arr[i] == 0) return i;
        }
        return -1;
    }
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
            map.put(arr[i], i);
        long[] res = new long[n];
        Arrays.fill(res, 1);
        int F1 = -1, F2; // F1 and F2 are index of factors
        int k, mod = 1000000007;
        long sum = 1;
        for(int i = 1; i < n; i++, F1 = -1){
            while((F1 = nextFact(arr, i, F1)) != -1){
                F2 = arr[i] / arr[F1];
                if(!map.containsKey(F2)) continue;
                F2 = map.get(F2);
                k = F1 == F2? 1 : 2;
                res[i] = (res[i] + res[F1] * res[F2] * k)%mod;
            }
            sum = (long)(sum + res[i]) % mod;
        }
        return (int)sum;
    }
}
