package StackProblems;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParantheses {
    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        if (s.length() % 2 != 0)
            return false;
        Deque<Character> stack = new ArrayDeque<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                if ((c == ')' && stack.peek() == '(') || (c == '}' && stack.peek() == '{')
                        || (c == ']' && stack.peek() == '[')) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            i++;
        }
        return stack.isEmpty();
    }
}
