package ArrayProblems.Day5.Hashing;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        int freq[] = new int[26];

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for(int c : freq){
            if(c != 0) return false;
        }
        return true;
    }
}
