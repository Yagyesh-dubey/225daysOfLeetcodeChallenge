public class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int totalCoins = 0;
        int pair = piles.length / 3;
        for (int i = pair; i < piles.length; i += 2) {
            totalCoins += piles[i];
        }
        return totalCoins;
    }
}
