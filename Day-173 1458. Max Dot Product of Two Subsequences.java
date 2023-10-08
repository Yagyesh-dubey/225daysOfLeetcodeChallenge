
import java.util.Arrays;

class Solution {
    int[][] dp;
    int nums1Size, nums2Size;

    public int calculateDotProduct(int[] nums1, int[] nums2, int idx1, int idx2) {
        if (idx1 == nums1Size || idx2 == nums2Size)
            return 0;

        if (dp[idx1][idx2] != -1)
            return dp[idx1][idx2];

        int option1 = nums1[idx1] * nums2[idx2] + calculateDotProduct(nums1, nums2, idx1 + 1, idx2 + 1);
        int option2 = calculateDotProduct(nums1, nums2, idx1, idx2 + 1);
        int option3 = calculateDotProduct(nums1, nums2, idx1 + 1, idx2);

        dp[idx1][idx2] = Math.max(Math.max(option1, option2), option3);
        return dp[idx1][idx2];
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        nums1Size = nums1.length;
        nums2Size = nums2.length;
        dp = new int[nums1Size][nums2Size];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int num : nums1) {
            firstMax = Math.max(firstMax, num);
            firstMin = Math.min(firstMin, num);
        }
        for (int num : nums2) {
            secondMax = Math.max(secondMax, num);
            secondMin = Math.min(secondMin, num);
        }

        if ((firstMax < 0 && secondMin > 0) || (firstMin > 0 && secondMax < 0)) {
            return Math.max(firstMax * secondMin, firstMin * secondMax);
        }

        return calculateDotProduct(nums1, nums2, 0, 0);
    }
}

