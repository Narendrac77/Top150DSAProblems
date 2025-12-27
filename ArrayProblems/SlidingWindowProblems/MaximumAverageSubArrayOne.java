package ArrayProblems.SlidingWindowProblems;

//https://leetcode.com/problems/maximum-average-subarray-i/description/
public class MaximumAverageSubArrayOne {

    public static void main(String[] args) {
     //   double avg = (double) 51 / 4;
      //  System.out.println(String.format("%.5f", avg) );
      int nums[] = { 1, 12, -5, -6, 50, 3};
      System.out.println(findMaxAverage(nums, 4));
    }

    public static double findMaxAverage(int nums[], int k) {
    
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum = sum + nums[i];
        }

       double maxSubArray = (double) sum/k;

        for(int i = k; i < nums.length; i++){
            sum = sum + nums[i] - nums[i - k];
            double currentAvg = (double) sum / k;
            maxSubArray = Math.max(currentAvg, maxSubArray);
        }

        return maxSubArray;
    }
    
}
