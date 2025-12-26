package StackProblems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//https://leetcode.com/problems/next-greater-element-ii/description/
public class NextGreaterElements2 {

    public static void main(String[] args) {
        int nums[] = { 1, 2, 1};
        int result[] = nextGreaterElement(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] nextGreaterElement(int nums[]){
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int result[] = new int[n];
        Arrays.fill(result, -1);

        for(int i = 0; i < 2 * n; i++){
            int curr = nums[i % n];

            while(!stack.isEmpty() && nums[stack.peek()] < curr){
                result[stack.pop()] = curr;
            }

            if(i < n){
                stack.push(i);
            }
        }

        return result;
    }
    
}
