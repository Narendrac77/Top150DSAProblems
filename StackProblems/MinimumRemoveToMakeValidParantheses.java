package StackProblems;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
public class MinimumRemoveToMakeValidParantheses {
    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s){
        Deque<Integer> stack = new ArrayDeque<>();

        Set<Integer> remove = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);;
            } else  if(s.charAt(i) == ')') {
                if(stack.isEmpty()){
                    remove.add(i);
                } else{
                    stack.pop();
                }
            }
        }

        while(!stack.isEmpty()){
            remove.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(!remove.contains(i)){
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}
