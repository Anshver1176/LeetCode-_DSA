class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int left = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int totalSum = sum;

        for (int i = 0; i < n; i++) {
            int right = totalSum - nums[i] - left;

            if (left == right) {
                return i;
            }

            left += nums[i];
        }

        return -1;
    }
}