package ArrayProblems.ArraysRevision.Day3;
//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum, and return its sum.
public class LargestSum {
    public static void main(String[] args) {
        int nums[] = { -4, -3};
        System.out.println(findlargestSum(nums));
    }

    public static int findlargestSum(int nums[]){
        int maxSum = nums[0];
        int currSum = 0;
        for(int i = 0; i < nums.length;i++){
            currSum = currSum + nums[i];
            maxSum = Math.max(maxSum, currSum);

            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }
}
