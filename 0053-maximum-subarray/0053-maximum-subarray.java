class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // int i  = 0;
        int bestending  = nums[0];
        int ans  = nums[0];
        for(int i =1 ; i < n; i++ ){
            int v1 = bestending + nums[i];
            int v2 = nums[i];
            bestending = Math.max(v1, v2);
            ans  = Math.max(ans, bestending);
        }
        return ans;
    }
}