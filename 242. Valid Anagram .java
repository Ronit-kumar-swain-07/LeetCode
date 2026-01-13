/*
242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
*/

//CODE
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] res = new int[26];

        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a']++;
            res[t.charAt(i) - 'a']--;
        }

        for (int count : res) {
            if (count != 0) return false;
        }
        return true;
    }
}