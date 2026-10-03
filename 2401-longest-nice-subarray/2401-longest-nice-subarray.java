class Solution {
    public int longestNiceSubarray(int[] nums) {

        int low = 0;
        int high = 0;
        int used = 0;
        int res = 0;

        while (high < nums.length) {

            while ((used & nums[high]) != 0) {
                used ^= nums[low];
                low++;
            }

            used |= nums[high];

            res = Math.max(res, high - low + 1);

            high++;
        }

        return res;
    }
}