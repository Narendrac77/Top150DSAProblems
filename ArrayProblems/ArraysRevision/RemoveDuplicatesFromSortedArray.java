package ArrayProblems.ArraysRevision;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int nums[] = { 1, 1, 2, 3, 3, 4, 4};
        int result[] = removeDuplicates(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] removeDuplicates(int nums[]){
        int insertPos = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[insertPos] != nums[i]){
                insertPos++;
                nums[insertPos] = nums[i];
            }
        }

        for(int i = insertPos + 1; i < nums.length; i++){
            nums[i] = 0;
        }

        return nums;
    }
}
