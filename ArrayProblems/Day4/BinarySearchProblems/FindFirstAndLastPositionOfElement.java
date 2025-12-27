package ArrayProblems.Day4.BinarySearchProblems;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FindFirstAndLastPositionOfElement {

    public static void main(String[] args) {
        int nums[] = { 5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }

    public static int[] searchRange(int nums[], int target){
        int left = findLeft(nums, target);
        if(left == -1){
            return new int[]{-1, -1};
        }

        int right = findRight(nums, target);

        return new int[]{left, right};
    }

    public static int findLeft(int nums[], int target){
        int left = 0;
        int right = nums.length - 1;
        int idx = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] >= target){
                right = mid - 1;
            } else{
                left = mid + 1;
            } if(nums[mid] == target){
                idx = mid;
            }
        }
        return idx;
    }

    public static int findRight(int nums[], int target){
        int left = 0;
        int right = nums.length - 1;

        int idx = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] <= target){
                left = mid + 1;
            } else{
                right = mid - 1;
            }

            if(nums[mid] == target){
                idx = mid;
            }
        }
        return idx;
    }
    
}
