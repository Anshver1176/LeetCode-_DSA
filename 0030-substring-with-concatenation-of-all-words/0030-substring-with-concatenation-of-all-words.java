class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> res = new ArrayList<>();

        Map<String, Integer> freq = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            freq.put(words[i], freq.getOrDefault(words[i], 0) + 1);
        }

        int wordlen = words[0].length();
        int totallen = wordlen * words.length;

        for (int offset = 0; offset < wordlen; offset++) {

            int low = offset;
            int high = offset;

            Map<String, Integer> currfreq = new HashMap<>();

            while (high + wordlen <= s.length()) {

                String word = s.substring(high, high + wordlen);
                high += wordlen;

                if (freq.containsKey(word)) {

                    currfreq.put(
                        word,
                        currfreq.getOrDefault(word, 0) + 1
                    );

                    while (currfreq.get(word) > freq.get(word)) {

                        String removeWord =
                            s.substring(low, low + wordlen);

                        currfreq.put(
                            removeWord,
                            currfreq.get(removeWord) - 1
                        );

                        low += wordlen;
                    }

                    if (high - low == totallen) {
                        res.add(low);
                    }

                } else {

                    currfreq.clear();
                    low = high;
                }
            }
        }

        return res;
    }
}