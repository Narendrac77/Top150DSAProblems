package ArrayProblems.ArraysRevision.Day2;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isValidAnagarm(s, t));
    }

    public static boolean isValidAnagarm(String s, String t){
        if(s.length() != t.length()) return false;

        Map<Character, Integer> freq = new HashMap<>();

        for(char ch : s.toCharArray()){
            freq.put(ch , freq.getOrDefault(ch, 0) + 1);
        }

        for(char ch : t.toCharArray()){
            if(!freq.containsKey(ch)) return false;
            freq.put(ch, freq.get(ch) - 1);
            if(freq.get(ch) == 0) freq.remove(ch);
        }

        return freq.isEmpty() ? true : false;

    }
}
