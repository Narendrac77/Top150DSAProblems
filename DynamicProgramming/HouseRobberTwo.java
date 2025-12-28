package DynamicProgramming;

public class HouseRobberTwo {
    public static void main(String[] args) {
        int nums[] = { 2, 3, 2 };
        rob(nums);
    }

    // Most Optimized version
    public static void rob(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            // return nums[0];
            System.out.println(nums[0]);
            return;
        }
        if (n == 2) {
            // return Math.max(nums[0], nums[1]);
            System.out.println(Math.max(nums[0], nums[1]));
            return;
        }

        int result = Math.max(
                robLinear(nums, 0, n - 2),
                robLinear(nums, 1, n - 1));
        System.out.println(result);
    }

    public static int robLinear(int[] nums, int start, int end) {
        int prev = 0, curr = 0;

        for (int i = start; i <= end; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + nums[i]);
            prev = temp;
        }
        return curr;
    }

    /*
     * public static void rob(int nums[]){
     * int n = nums.length;
     * int solution1 = spaceOptimization(n - 1, nums);
     * for(int i = 1; i < nums.length; i++){
     * nums[i - 1] = nums[i];
     * }
     * int solution2 = spaceOptimization(n - 1, nums);
     * System.out.println(Math.max(solution1, solution2));
     * }
     * 
     * public static int spaceOptimization(int n, int nums[]){
     * int previous = nums[0];
     * int previous_2 = 0;
     * 
     * for(int i = 1; i < n; i++){
     * int dontRob = previous;
     * int rob = nums[i];
     * if(i > 1){
     * rob = rob + previous_2;
     * }
     * 
     * int current = Math.max(rob, dontRob);
     * previous_2 = previous;
     * previous = current;
     * }
     * return previous;
     * }
     */
}
