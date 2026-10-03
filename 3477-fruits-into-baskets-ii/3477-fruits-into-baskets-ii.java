class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {

        int n = fruits.length;
        int res = 0;

        for (int high = 0; high < n; high++) {

            boolean placed = false;

            for (int low = 0; low < n; low++) {

                if (baskets[low] >= fruits[high]) {

                    baskets[low] = -1;
                    placed = true;
                    break;
                }
            }

            if (!placed) {
                res++;
            }
        }

        return res;
    }
}