class Solution {

    public boolean sahi(int have[], int needed[]) {
        for (int i = 0; i < 256; i++) {
            if (have[i] < needed[i]) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {

        int n = s.length();

        int low = 0;
        int res = Integer.MAX_VALUE;
        int start = 0;

        int have[] = new int[256];
        int needed[] = new int[256];

        // Store required characters
        for (int i = 0; i < t.length(); i++) {
            needed[t.charAt(i)]++;
        }

        for (int high = 0; high < n; high++) {

            have[s.charAt(high)]++;

            while (sahi(have, needed)) {

                int len = high - low + 1;

                if (len < res) {
                    res = len;
                    start = low;
                }

                have[s.charAt(low)]--;
                low++;
            }
        }

        if (res == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + res);
    }
}