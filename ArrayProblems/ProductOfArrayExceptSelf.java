package ArrayProblems;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int nums[] = {1,2,3,4};
        int result[] = productExceptSelf(nums);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
   
    //Optimised Approach
    public static int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];

    result[0] = 1;
    for (int i = 1; i < n; i++) {
        result[i] = result[i - 1] * nums[i - 1];
    }

    int right = 1;
    for (int i = n - 1; i >= 0; i--) {
        result[i] *= right;
        right *= nums[i];
    }

    return result;
}

/* 
    public static int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int result[] = new int[n];
        int left[] = leftProduct(nums, n);
        int right[] = rightProduct(nums, n);
        for(int i=0; i<n; i++){
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static int[] leftProduct(int nums[], int n){
        int left[] = new int[n];
        left[0] = 1;
        for(int i=1; i<n; i++){
            left[i] = left[i-1] * nums[i-1];
        }
        return left;
    }

    public static int[] rightProduct(int nums[], int n){
        int right[] = new int[n];
        right[n-1] = 1;
        for(int i=n-2; i>=0; i--){
            right[i] = right[i+1] * nums[i+1];
        }
        return right;
    } */
}
