package ArrayProblems.ArraysRevision;

//https://leetcode.com/problems/permutation-in-string/description/

//Approach - freq array of size 26- Problem description it has mentioned that the input String cointain only lower case characters.
//Time Complexity - O(N) - One iteration from index 0 to length - 1.
//Space complexity - Taken space of frequency array of size 26 which is equivalent to O(1).
public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        int freq[] = new int[26];

        int left = 0, right = 0;

        for (char ch : s1.toCharArray()) {
            freq[ch - 'a']++;
        }

        int count = s1.length();

        while (right < s2.length()) {
            if (freq[s2.charAt(right++) - 'a']-- > 0)
                count--;
            while (count == 0) {
                if (right - left == s1.length())
                    return true;
                if (freq[s2.charAt(left++) - 'a']++ == 0)
                    count++;
            }
        }
        return false;
    }
}
