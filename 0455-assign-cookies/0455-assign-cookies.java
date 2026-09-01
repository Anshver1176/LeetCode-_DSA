import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;
        int count = 0;

        while (child < g.length && cookie < s.length) {

            if (s[cookie] >= g[child]) {
                count++;
                child++;
                cookie++;
            } else {
                cookie++;
            }
        }

        return count;
    }
}