package StackProblems;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/remove-k-digits/description/
public class RemoveKDigits {
    public static void main(String[] args) {
        String s = "112";
        System.out.println(removeKDigits(s, 1));
    }

    public static String removeKDigits(String s, int k){
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() > c && k > 0){
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        sb.reverse();

        int idx = 0;

        while(idx < sb.length() && sb.charAt(idx) == '0'){
            idx++;
        }

        String result = sb.substring(idx);
        return result.isEmpty() ? "0" : result;
    }
}
