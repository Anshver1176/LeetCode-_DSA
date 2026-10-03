class Solution {
    public String minWindow(String s, String t) {

        int low = 0;
        int high = 0;

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        int count = t.length();

        int[] freq = new int[128];

        for (int i = 0; i < t.length(); i++) {
            freq[t.charAt(i)]++;
        }

        while (high < s.length()) {

            char ch = s.charAt(high);

            if (freq[ch] > 0) {
                count--;
            }

            freq[ch]--;
            high++;

            while (count == 0) {

                if (high - low < minLen) {
                    minLen = high - low;
                    start = low;
                }

                char leftChar = s.charAt(low);

                freq[leftChar]++;

                if (freq[leftChar] > 0) {
                    count++;
                }

                low++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}