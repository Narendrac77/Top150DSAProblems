package ArrayProblems.ArraysRevision;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        
    }

    public static int mostWater(int nums[]){
        int left = 0, right = nums.length - 1;
        int maxWater = 0;

        while (left < right) {
            int minHeight = Math.min(nums[left],  nums[right]);
            int distance = right - left;
            int currWater = minHeight * distance;
            maxWater = Math.max(maxWater, currWater);
            if(nums[left] < nums[right]) left++;
            else right--;
        }

        return maxWater;
    }
}
