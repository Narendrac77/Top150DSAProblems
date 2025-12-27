package ArrayProblems.RandomProblems;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int nums[] = { 2, 3, -2, -4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int nums[]){
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];

        for(int i = 1; i < nums.length; i++){
            int curr = nums[i];

            //If negative, swap
            if(curr < 0){
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(curr, curr * maxProduct);
            minProduct = Math.min(curr, curr * minProduct);

            result = Math.max(result, maxProduct);
        }
        return result;
        
    }
}
