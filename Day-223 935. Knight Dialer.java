class Solution {
    public int knightDialer(int n) {
        if (n == 1) return 10;

        Map<Integer, int[]> moves = new HashMap<>();
        moves.put(0, new int[]{4, 6});
        moves.put(1, new int[]{6, 8});
        moves.put(2, new int[]{7, 9});
        moves.put(3, new int[]{4, 8});
        moves.put(4, new int[]{0, 3, 9});
        moves.put(6, new int[]{0, 1, 7});
        moves.put(7, new int[]{2, 6});
        moves.put(8, new int[]{1, 3});
        moves.put(9, new int[]{2, 4});

        int[] v = new int[10];
        for (int i = 0; i < 10; i++) {
            v[i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            int[] tmp = new int[10];
            for (Map.Entry<Integer, int[]> entry : moves.entrySet()) {
                int key = entry.getKey();
                int[] val = entry.getValue();
                for (int j : val) {
                    tmp[key] = (tmp[key] + v[j]) % 1000000007;
                }
            }
            v = tmp;
        }

        int ans = 0;
        for (int i : v) {
            ans = (ans + i) % 1000000007;
        }
        return ans;
    }
}
