class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int  n = nums.length;
        int res = 0;
        int maxend= 0;
        int minend= 0;
        for(int i =0 ; i < n; i++){
            maxend = Math.max(0, maxend + nums[i]);
            minend = Math.min(0, minend + nums[i]);

            res = Math.max(res, Math.max(maxend,-minend));
        }
        return res;
    }
}