package StackProblems;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/decode-string/description/
public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s){
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();

        StringBuilder curr = new StringBuilder();

        int num = 0;

        for(char c :s.toCharArray()){
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0'); // handle multi-digit
            } else if(c == '['){
                countStack.push(num);
                stringStack.push(curr);

                curr = new StringBuilder();
                num = 0;
            } else if(c == ']'){
                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();

                for(int i = 0; i < repeat; i++){
                    prev.append(curr);
                }
                curr = prev;
            } else{
                curr.append(c);
            }
        }

        return curr.toString();
    }
}
