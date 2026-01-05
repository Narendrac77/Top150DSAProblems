package ArrayProblems.ArraysRevision;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        //String s = "pwwkew";
        String s = "peekew";
        int result = maxLeng(s);
        System.out.println(result);
    }

    public static int maxLeng(String s){
        Map<Character, Integer> map = new HashMap<>();

        int left = 0, right = 0,  maxLen = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if(map.containsKey(ch)){
                left = Math.max(map.get(ch) + 1, left);
            }
            if(right - left + 1 > maxLen){
                maxLen = right - left + 1;
            }
            map.put(ch, right);
            right++;
        }
        return maxLen;
    }
}
