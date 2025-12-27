package ArrayProblems.SlidingWindowProblems;

public class MinimumSizeSubArray {
    public static void main(String[] args) {
      //  int nums[] = { 2, 3, 1, 2, 4, 3};
       // System.out.println(minSubArrayLen(7, nums));
        int nums[] = { 1, 4, 4};
        System.out.println(minSubArrayLen(4, nums));
    }

    public static int minSubArrayLen(int target, int nums[]){
        int left = 0, right = 0;

        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while(right < nums.length){
            sum = sum + nums[right];
            if(sum >= target){
                while(sum >= target && left <= right){
                    int currlen = right - left + 1;
                    minLen = Math.min(currlen, minLen);
                    sum = sum - nums[left];
                    left++;
                }
            }
            right++;
        }
        return minLen;
    }
}
