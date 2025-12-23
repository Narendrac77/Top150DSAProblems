package ArrayProblems.SlidingWindowProblems;

public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaoo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2){
        if(s2.length() < s1.length()) return false;
        int freq[] = new int[26];

        for(char c : s1.toCharArray()){
            freq[c - 'a']++;
        }

        int start = 0, end = 0;

        int count = s1.length();

        while (end < s2.length()) {
            if(freq[s2.charAt(end++) - 'a']-- > 0) count--;
            while (count == 0) {
                if(end - start == s1.length()){
                    return true;
                }
                if(freq[s2.charAt(start++) - 'a']++ == 0) count++;
            }
        }
        return false;
    }
}
