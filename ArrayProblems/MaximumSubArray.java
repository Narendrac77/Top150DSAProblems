package ArrayProblems;

public class MaximumSubArray {
    public static void main(String[] args) {
        int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSum(nums));
    }

    public static int maxSum(int nums[]){
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int currentsum = 0;
        for(int i = 0; i < n; i++){
            currentsum = currentsum + nums[i];
            maxSum = Math.max(maxSum, currentsum);
            if(currentsum < 0) currentsum = 0;
        }
        return maxSum;
    }

}
