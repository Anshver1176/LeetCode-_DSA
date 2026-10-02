class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left  =-1;
        int right = -1;

        for(int i=1 ; i < nums.length ; i++ ){
            if(nums[i] < nums[i - 1]){
                left = i -1;
                break;
            }

        }
           if(left == -1){
                return 0;
            }
           for (int i = n - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                right = i + 1;
                break;
            }
        }
         int min = nums[left];
        int max = nums[left];

        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        // Extend left
        while (left > 0 && nums[left - 1] > min) {
            left--;
        }

        // Extend right
        while (right < n - 1 && nums[right + 1] < max) {
            right++;
        }

        return right - left + 1;
    
    }
}