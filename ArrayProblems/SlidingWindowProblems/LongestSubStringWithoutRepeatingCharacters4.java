package ArrayProblems.SlidingWindowProblems;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters4 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        Set<String> result = longestUniqueSubString(s);
        for(String st : result){
            System.out.print(st + " ");
        }
    }

    public static Set<String> longestUniqueSubString(String s){
        if(s == null || s.length() < 0) return null;
        int lastSeen[] = new int[128];
        Set<String> result = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);

            //move left pointer if character was seen inside window

            left = Math.max(left, lastSeen[ch]);

            int currentLength = right - left + 1;

            if(currentLength > maxLength){
                maxLength = currentLength;
                result.clear();
                result.add(s.substring(left, right + 1));
            } else if(currentLength == maxLength){
               result.add(s.substring(left, right + 1)); 
            }
            lastSeen[ch] = right + 1;
            right++;
        }

        return result;
    }
}
