class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int minend = nums[0];
        int maxend = nums[0];

        for (int i = 1; i < n; i++) {

            int oldMax = maxend;

            maxend = Math.max(nums[i],
                    Math.max(minend * nums[i], maxend * nums[i]));

            minend = Math.min(nums[i],
                    Math.min(oldMax * nums[i], minend * nums[i]));

            res = Math.max(res, maxend);
        }

        return res;
    }
}