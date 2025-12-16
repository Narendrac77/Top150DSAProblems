package ArrayProblems.SlidingWindowProblems;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubString(s));
    }

    public static int lengthOfLongestSubString(String s){
        if(s == null || s.length() == 0 ) return 0; // Order is important to handle this input s = null && s = "";

        Map<Character, Integer> map = new HashMap<>();

        int left = 0, right = 0, max = 0;

        while(right < s.length()){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)) + 1, left); // We use math.max to ensue the left ponter never moves backward when handling duplicates, keeping the window valid.
            }
            map.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
