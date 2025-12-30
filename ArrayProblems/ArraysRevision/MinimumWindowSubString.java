package ArrayProblems.ArraysRevision;

//https://leetcode.com/problems/minimum-window-substring/description/
public class MinimumWindowSubString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t){
        if(t.length() > s.length()) return "";

        int freq[] = new int[128];

        for(char ch : t.toCharArray()){
            freq[ch]++;
        }

        int count = t.length();

        int left = 0, right = 0, minWindow = Integer.MAX_VALUE;
        int startIndex = 0;

        while (right < s.length()) {
            if(freq[s.charAt(right++)]-- > 0) count--;

            while(count == 0){
                if(right - left < minWindow){
                minWindow =  right - left;
                startIndex = left;
                }
                if(freq[s.charAt(left++)]++ == 0) count++;
            }
        }

        return minWindow == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minWindow);

    }
}
