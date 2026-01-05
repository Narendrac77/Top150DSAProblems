package ArrayProblems.ArraysRevision;

import java.util.Arrays;

public class Movezeros {
    public static void main(String[] args) {
        int nums[] = { 1, 0, 3, 2, 0, 4, 0};
        int result[] = moveZeros(nums);
        System.out.println(Arrays.toString(result));
    }

    public static int[] moveZeros(int nums[]){
        int insertPos = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[insertPos++] = nums[i];
            }
        }

        for(int i = insertPos; i < nums.length; i++){
            nums[i] = 0;
        }
        return nums;
    }
    
}
