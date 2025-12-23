package StackProblems;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    long min;

    Deque<Long> stack;

    public MinStack() {
        stack = new ArrayDeque<>();
    }

    public void push(int val){
       if(stack.isEmpty()){
        stack.push(0L);
        min = val;
       } else{
        long diff = val - min;
        stack.push(diff);
        if(diff < 0){
            min = val;
        }
       }
    }

    public void pop(){
        long diff = stack.pop();
        if(diff < 0){
            min = min - diff;
        }
    }

    public int top(){
        long diff = stack.peek();
        if(diff >= 0){
            return (int)(min + diff);
        } else{
            return (int) min;
        }
    }

    public int getMin(){
        return (int)min;
    }

}
