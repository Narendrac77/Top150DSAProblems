package StackProblems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatureOptimal {
    public static void main(String[] args) {
        int temperatures[] = { 73, 74, 75, 71, 69, 72, 76, 73};
        int result[] = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result));
    }

    public static int[] dailyTemperatures(int temperatures[]){
        int n = temperatures.length;
        int result[] = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }
        return result;
    }
}
