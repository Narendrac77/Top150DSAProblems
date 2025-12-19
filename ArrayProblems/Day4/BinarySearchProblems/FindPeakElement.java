package ArrayProblems.Day4.BinarySearchProblems;

public class FindPeakElement {
    public static void main(String[] args) {
       int nums[] = {1, 2, 1, 3, 5, 6, 7};
       System.out.println(findPeakElement(nums)); 
    }

    public static int findPeakElement(int nums[]){
        if(nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid + 1]){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
