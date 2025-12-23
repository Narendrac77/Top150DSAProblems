package ArrayProblems.SlidingWindowProblems;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString {
    public static void main(String[] args) {
       //String s = "cbaebabacd", p = "abc";
        String s = "abab", p = "ab";
        List<Integer> result = findAnagrams(s, p);
        System.out.println(result.toString());
    }

    public static List<Integer> findAnagrams(String s, String p){
        List<Integer> result = new ArrayList<>();
        if(s.length() < p.length()) return new ArrayList<>();
        int freq[] = new int[26];

        for(char c : p.toCharArray()){
            freq[c - 'a']++;
        }

        int start = 0, end = 0;

        int count = p.length();

        while(end < s.length()){
            if(freq[s.charAt(end++) - 'a']-- > 0) count--;

            while(count == 0){
                if(end - start == p.length()) result.add(start);
                if(freq[s.charAt(start++) - 'a']++ == 0) count++;
            }
        }

        return result;
    }
}
