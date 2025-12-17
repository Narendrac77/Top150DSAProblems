package ArrayProblems.SlidingWindowProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        List<String> result = longestSubString(s);
        for(String st : result){
            System.out.print(st + " ");
        }
    }

    public static List<String> longestSubString(String s){
        if( s == null || s.length() == 0) return null;

        Map<Character, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        int left = 0, right = 0, maxSubString = 0;

        while(right < s.length()){
            char ch = s.charAt(right);

            if(map.containsKey(ch)){
                left = Math.max(map.get(ch) + 1, left);
            }

            map.put(ch, right);

            if((right - left + 1) > maxSubString){
                maxSubString = right - left + 1;
                result.clear();
                result.add(s.substring(left , right + 1));
            }
            else if((right - left + 1) == maxSubString){
                result.add(s.substring(left , right + 1));
            }
            right++;
        }
        return result;
    }
}
