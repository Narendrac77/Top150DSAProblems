package StackProblems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElement {
    public static void main(String[] args) {
        int nums1[] = { 4, 1, 2};
        int nums2[] = { 1, 3, 4, 2, 5};
        int result[] = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    public  static int[] nextGreaterElement(int[] nums1, int[] nums2){
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for(int num : nums2){
            while (!stack.isEmpty() && num > stack.peek()) {
                nextGreater.put(stack.pop(), num);
            }   
            stack.push(num);
        }

        //Elements left in stack have no next greater
        while (!stack.isEmpty()) {
            nextGreater.put(stack.pop(), -1);
        }

        //Build results for nums1

        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            result[i] = nextGreater.get(nums1[i]);
        }

        return result;
    }
}
