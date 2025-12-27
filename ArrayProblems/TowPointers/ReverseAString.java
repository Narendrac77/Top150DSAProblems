package ArrayProblems.TowPointers;

import java.util.Arrays;

public class ReverseAString {
    public static void main(String[] args) {
        char c[] = {'h','e','l','l','o'};
        reverse(c);
        System.out.println(Arrays.toString(c));
    }

    public static void reverse(char c[]){
       int left = 0, right = c.length - 1;
       while(left < right){
        char temp = c[left];
        c[left] = c[right];
        c[right] = temp;
        left++;
        right--;
       }
    }

}
