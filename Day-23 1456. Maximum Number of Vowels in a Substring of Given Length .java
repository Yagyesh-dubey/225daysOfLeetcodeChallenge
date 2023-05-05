class Solution {
    public int maxVowels(String s, int k) {
        int vowel = 0;
        int count = 0;
        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        vowel = count;
        for (int i = k; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
            char prev = s.charAt(i - k);
            if (prev == 'a' || prev == 'e' || prev == 'i' || prev == 'o' || prev == 'u') {
                count--;
            }
            if (count > vowel) {
                vowel = count;
            }
        }
        return vowel;
    }
}
