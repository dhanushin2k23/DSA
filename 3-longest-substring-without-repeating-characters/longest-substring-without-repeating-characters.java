class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 1;
        int max = 0;

        if (s.length() == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        HashSet<Character> map = new HashSet<>();
        map.add(s.charAt(left));

        while (right < s.length()) {
            if (!map.contains(s.charAt(right))) {
                map.add(s.charAt(right));
                right++;
                max = Math.max(max, right - left);
            } else {
                map.remove(s.charAt(left));
                left++;
            }
        }

        return max;
    }
}