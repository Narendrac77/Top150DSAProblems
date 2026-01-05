package ArrayProblems.ArraysRevision;

public class ValidPalindome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char leftCh = s.charAt(left);
            char rightCh = s.charAt(right);
            if (!Character.isLetterOrDigit(leftCh)) {
                left++;
                continue;
            } else if (!Character.isLetterOrDigit(rightCh)) {
                right--;
                continue;
            } else if (Character.toLowerCase(leftCh) != Character.toLowerCase(rightCh))
                return false;

            left++;
            right--;
        }
        return true;
    }
}
