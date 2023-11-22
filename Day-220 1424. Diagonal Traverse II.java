class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int size=0, maxi=0;
        for(int row = nums.size()-1; row>=0; row--){
            for(int col =0; col<nums.get(row).size(); col++){
                map.putIfAbsent(row+col, new ArrayList<>());
                map.get(row+col).add(nums.get(row).get(col));

                size++;
                maxi = Math.max(maxi, row+col);
            }
        }

        int[] res = new int[size];
        int i=0;
        for(var key=0; key<=maxi; key++){
            List<Integer> l = map.get(key);

            if(l == null) continue;
            for(var x:l) res[i++] = x;
        }
        return res;
    }
}
