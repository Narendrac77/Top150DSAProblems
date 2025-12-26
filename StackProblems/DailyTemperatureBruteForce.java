package StackProblems;

import java.util.Arrays;

public class DailyTemperatureBruteForce {
    public static void main(String[] args) {
        int temperatures[] = { 73, 74, 75, 71, 69, 72, 76, 73};
        int result[] = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result));
    }

    public static int[] dailyTemperatures(int[] temperatures){
        int n = temperatures.length;
        int result[] = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(temperatures[j] > temperatures[i]){
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }
}
