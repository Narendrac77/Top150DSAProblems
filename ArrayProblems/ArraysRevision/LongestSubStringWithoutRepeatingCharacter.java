package ArrayProblems.ArraysRevision;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

//Approach - Sliding window and  HashMap
//Sliding window to shrink the window size if any duplicate element found, Map is a data structure used to store the character and it posistion. 
// When a duplicate found will be fetching the max of last occurence.
public class LongestSubStringWithoutRepeatingCharacter {

    public static void main(String[] args) {
       // String s = "abcabcbb";
       //String s = "bbbb";
       String s= "pwwkew";
        System.out.println(longestSubString(s));
    }

    public static int longestSubString(String s){
        Map<Character, Integer> map =new HashMap<>();

        int left = 0, right = 0;
        int maxSubArray = 0;

        while(right < s.length()){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)) + 1, left);
            }
            if(right - left + 1 > maxSubArray){
                maxSubArray = right - left + 1;
            }
            map.put(s.charAt(right), right);
            right++;
        }
        return maxSubArray;
    }
    
}
