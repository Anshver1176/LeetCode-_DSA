
class Solution {
    public double myPow(double x, int n) {
        long power = n;
        if (power < 0) {
            power = -power;
        }

        double result = 1.0;

        while (power > 0) {
            if ((power & 1) == 1) {
                result *= x;
            }

            x *= x;
            power >>= 1;
        }

        if (n < 0) {
            result = 1.0 / result;
        }

        return result;
    }
}
