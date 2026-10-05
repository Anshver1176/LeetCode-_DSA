class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int count = s1.length();

        if (count > s2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq1[s1.charAt(i) - 'a']++;
        }

        // First window
        for (int i = 0; i < count; i++) {
            freq2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freq1, freq2)) {
            return true;
        }

        int low = 0;

        // Sliding window
        for (int high = count; high < s2.length(); high++) {

            freq2[s2.charAt(high) - 'a']++;
            freq2[s2.charAt(low) - 'a']--;

            low++;

            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
        }

        return false;
    }
}