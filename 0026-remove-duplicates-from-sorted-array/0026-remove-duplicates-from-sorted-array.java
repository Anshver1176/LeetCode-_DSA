class Solution {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        int i = 0;
        int j = 1;
        int k = 1;

        while (k < n) {
            if (nums[k] == nums[k - 1]) {
                k++;
                continue;
            }

            nums[i + 1] = nums[k];
            i++;
            j++;
            k++;
        }

        return j;
    }
}