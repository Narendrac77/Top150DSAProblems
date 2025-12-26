package StackProblems;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/remove-duplicate-letters/description/
public class RemoveDuplicateElements {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }

    public static String removeDuplicateLetters(String s){
        int freq[] = new int[26];
        boolean visited[] = new boolean[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()){
            int idx = c - 'a';
            freq[idx]--;

            if(visited[idx]) continue;

            while (!stack.isEmpty() && stack.peek() > c && freq[stack.peek() - 'a'] > 0) {
                visited[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            visited[idx] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
