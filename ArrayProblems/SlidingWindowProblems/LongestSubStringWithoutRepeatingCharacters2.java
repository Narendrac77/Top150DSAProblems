package ArrayProblems.SlidingWindowProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters2 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(longestSubStringWithoutReapeating(s));
    }

    public static String longestSubStringWithoutReapeating(String s){
        if(s == null || s.length() == 0) return "";

        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, maxSubString = 0, startIndex = 0;

        while(right < s.length()){
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                left = Math.max(map.get(ch) + 1, left);
            }
            map.put(ch, right);

            if(right - left + 1 > maxSubString){
                maxSubString = right - left + 1;
                startIndex = left;
            }
            right++;
        }
        return s.substring(startIndex, startIndex + maxSubString);
    }
}
