package DynamicProgramming;

public class MaxSubArrayProduct {
    public static void main(String[] args) {
        int nums[] = {2, 3, -2, 4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int nums[]) {
        int maxEnding = nums[0];
        int minEnding = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];

            int tempMax = Math.max(x, Math.max(x * maxEnding, x * minEnding));
            int tempMin = Math.min(x, Math.min(x * maxEnding, x * minEnding));

            maxEnding = tempMax;
            minEnding = tempMin;

            result = Math.max(result, maxEnding);
        }
        return result;
    }
}
