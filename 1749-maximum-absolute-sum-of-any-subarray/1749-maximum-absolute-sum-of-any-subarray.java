class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int res = Math.abs(nums[0]);
        int maxend = nums[0];
        int minend = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxend = Math.max(nums[i], maxend + nums[i]);
            minend = Math.min(nums[i], minend + nums[i]);

            res = Math.max(res, Math.max(maxend, -minend));
        }

        return res;
    }
}