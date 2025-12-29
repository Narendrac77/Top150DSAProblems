package ArrayProblems;

public class PivotIndex {
    public static void main(String[] args) {
        int nums[] = { 2, 1, -1};
        System.out.println(pivotIndes(nums));
    }

    public static int pivotIndes(int nums[]){
        int totalSum = 0;

        for(int num : nums){
            totalSum = totalSum + num;
        }

        int leftSum = 0;

        for(int i = 0; i < nums.length; i++){
            if(leftSum == totalSum - leftSum - nums[i]){
                return i;
            }
            leftSum = leftSum + nums[i];
        }
        return -1;
    }
}
