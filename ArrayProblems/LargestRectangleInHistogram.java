package ArrayProblems;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/largest-rectangle-in-histogram/description/
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int heights[] = { 2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int heights[]){
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>();

        int maxArea = 0;

        for(int i = 0; i <= n; i++){
            int currheight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && currheight < heights[stack.peek()]) {
                int heightIdx = stack.pop();
                int height = heights[heightIdx];

                int right = i;

                int left = stack.isEmpty() ? -1 : stack.peek();

                int width = right - left - 1;

                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}
