package DynamicProgramming.PalindromicSubStringProblems;

//https://leetcode.com/problems/palindromic-substrings/description/
public class PalindromicSubStrings {
    public static void main(String[] args) {
        //String s = "abc";
        String s = "aaa";
        System.out.println(countSubStrings(s));
    }


    public static int countSubStrings(String s){
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            count += expand(s, i, i); //Odd length;
            count += expand(s, i, i + 1); // even length
        }

        return count;
    }

    private static int expand(String s, int left, int right){
        int cnt = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            cnt++;
            left--;
            right++;
        }
        return cnt;
    }
}
