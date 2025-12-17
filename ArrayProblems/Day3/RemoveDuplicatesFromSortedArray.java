package ArrayProblems.Day3;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int nums[] = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int index = removeDuplicates(nums);
        for(int i = 0; i < index; i++){
        System.out.println(nums[i]);
        }

    }

    public static int removeDuplicates(int[] nums){
        if(nums == null) return 0;

        int i = 0;

        for(int j = 1; j < nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
