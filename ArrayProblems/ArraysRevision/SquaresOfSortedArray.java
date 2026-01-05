package ArrayProblems.ArraysRevision;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        //int nums[] = { -4, -1, 0, 3, 10 };
        int nums[] = { -7,-3,2,3,11};
        int result[] = squaresOfSortedArray(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] squaresOfSortedArray(int nums[]) {
        int result[] = new int[nums.length];
        

        int left = 0, right = nums.length - 1;
        int insertPos = nums.length - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare < rightSquare) {
                result[insertPos--] = rightSquare;
                right--;
            } else {
                result[insertPos--] = leftSquare;
                left++;
            }
        }
        return result;
    }
}
