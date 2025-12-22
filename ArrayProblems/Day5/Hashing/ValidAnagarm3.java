package ArrayProblems.Day5.Hashing;

import java.util.HashMap;
import java.util.Map;

/*
Ignore Special Characters (Very Common Interview Twist)
s = "a@b#c"
t = "cba"
→ true
 */
public class ValidAnagarm3 {
    public static void main(String[] args) {
        String s = "a@b#c";
        String t = "cba";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t){
        Map<Character, Integer> freq = new HashMap<>();

        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                c = Character.toLowerCase(c);
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }

        for(char c : t.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                c = Character.toLowerCase(c);
                if(!freq.containsKey(c)) return false;
                freq.put(c, freq.get(c) - 1);
                if(freq.get(c) == 0) freq.remove(c);
            }
        }

        return freq.isEmpty();
    }
}
