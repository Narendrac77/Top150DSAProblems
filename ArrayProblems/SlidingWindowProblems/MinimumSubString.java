package ArrayProblems.SlidingWindowProblems;
//https://leetcode.com/problems/minimum-window-substring/description/
public class MinimumSubString {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t){
        if( s == null || t == null || s.length() < t.length()) return "";
        int map[] = new int[128];
        int count = t.length();

        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE;

        for(char c : t.toCharArray()) map[c]++;

        while(end < s.length()){
            if(map[s.charAt(end++)]-- > 0) count--;
            while (count == 0) {
                if(end - start < minLen){
                    minStart = start;
                    minLen = end - start;
                }

                if(map[s.charAt(start++)]++ == 0) count++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }
}
