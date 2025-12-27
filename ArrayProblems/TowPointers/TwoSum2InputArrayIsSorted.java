package ArrayProblems.TowPointers;

import java.util.Arrays;

//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class TwoSum2InputArrayIsSorted {
    public static void main(String[] args) {
        int nums[] = { 2, 3, 4};
        int result[] = twoSum(nums, 6);
        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int nums[], int target){
        int left = 0, right = nums.length - 1;

        while(left < right){
            int currSum = nums[left] + nums[right];
            if(currSum == target){
                return new int[]{left +1, right + 1};
            } else if(currSum < target){
                left++;
            } else{
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
