package ArrayProblems;

public class MaximumSubArraySum2 {
    public static void main(String[] args) {
        int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result[] = maxSum(nums);
        int startIndex = result[0];
        int endIndex = result[1];
        for(int i = startIndex; i <= endIndex; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public static int[] maxSum(int nums[]){
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int startIndex = 0, endIndex = 0, tempStart = 0;
        for(int i = 0; i < n; i++){
            currentSum = currentSum + nums[i];
            if(currentSum > maxSum){
                endIndex = i;
                maxSum = currentSum;
                startIndex = tempStart;
            }
            if(currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }
        return new int[]{startIndex, endIndex};
    }
}
