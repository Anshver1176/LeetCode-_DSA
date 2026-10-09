class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int n = arr.length;
         int res = arr[0];
         int maxSum = arr[0];
         int minSum = arr[0];
         int sum = 0;
         for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
         }
          int totalSum = sum;
         for (int i = 1; i < arr.length; i++) {
            maxSum = Math.max(arr[i], maxSum + arr[i]);
            minSum = Math.min(arr[i], minSum + arr[i]);
            res = Math.max(res, maxSum);
            if (minSum != totalSum) {
            res = Math.max(res, totalSum - minSum);
        }
         }
         return res;
    }
}