class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxLen = 1;

        for (int i = 0; i < s.length(); i++) {

            // Odd length palindrome
            int low = i;
            int high = i;

            while (low >= 0 && high < s.length()
                    && s.charAt(low) == s.charAt(high)) {

                if (high - low + 1 > maxLen) {
                    start = low;
                    maxLen = high - low + 1;
                }

                low--;
                high++;
            }

            // Even length palindrome
            low = i;
            high = i + 1;

            while (low >= 0 && high < s.length()
                    && s.charAt(low) == s.charAt(high)) {

                if (high - low + 1 > maxLen) {
                    start = low;
                    maxLen = high - low + 1;
                }

                low--;
                high++;
            }
        }

        return s.substring(start, start + maxLen);
    }
}