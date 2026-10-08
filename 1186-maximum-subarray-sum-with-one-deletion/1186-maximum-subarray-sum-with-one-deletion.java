class Solution {
    public int maximumSum(int[] arr) {
        int res = arr[0];
        int nodelete = arr[0];
        int onedelete = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {

            int prenodelete = nodelete;
            int preonedelete = onedelete;

            nodelete = Math.max(arr[i], nodelete + arr[i]);

            if (preonedelete == Integer.MIN_VALUE) {
                onedelete = prenodelete;
            } else {
                onedelete = Math.max(preonedelete + arr[i], prenodelete);
            }

            res = Math.max(res, Math.max(nodelete, onedelete));
        }

        return res;
    }
}