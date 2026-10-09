class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        if (m > n) {
            return res;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < m; i++) {
            freq1[p.charAt(i) - 'a']++;
            freq2[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(freq1, freq2)) {
            res.add(0);
        }

        int low = 0;

        for (int high = m; high < n; high++) {
            freq2[s.charAt(high) - 'a']++;

            freq2[s.charAt(low) - 'a']--;
            low++;

            if (Arrays.equals(freq1, freq2)) {
                res.add(low);
            }
        }

        return res;
    }
}