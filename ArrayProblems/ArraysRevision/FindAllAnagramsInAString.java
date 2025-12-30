package ArrayProblems.ArraysRevision;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
//Approach - freq array of size 26- Problem description it has mentioned that the input String cointain only lower case characters.
//Time Complexity - O(N) - One iteration from index 0 to length - 1.
//Space complexity - Taken space of frequency array of size 26 which is equivalent to O(1).
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        
    }

    public static List<Integer> findAnagrams(String s, String p){
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()) return result;

        int freq[] = new int[26];

        for(char ch : p.toCharArray()){
            freq[ch - 'a']++;
        }

        int left = 0, right = 0;

        int count = p.length();

        while (right < s.length()) {
            if(freq[s.charAt(right++) - 'a']-- > 0) count--;

            while(count == 0){
                if(right - left == p.length()) result.add(left);
                if(freq[s.charAt(left++) - 'a']++ == 0) count++;
            }
        }
        return result;
    }
}
