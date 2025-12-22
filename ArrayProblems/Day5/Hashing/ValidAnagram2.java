package ArrayProblems.Day5.Hashing;

import java.util.HashMap;
import java.util.Map;

/*
Case-Sensitive + Special Characters INCLUDED

👉 "A@b" is NOT an anagram of "a@B"

✅ Best Approach: HashMap<Character, Integer> */
public class ValidAnagram2 {
    public static void main(String[] args) {
        String s = "A@b";
        String t = "b@A";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        Map<Character, Integer> freq = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0 ) + 1);
        }

        for(char c : t.toCharArray()){
            if(!freq.containsKey(c)) return false;
            freq.put(c, freq.get(c) - 1);
            if(freq.get(c) == 0) freq.remove(c);
        }

        return freq.isEmpty();
    }
}
