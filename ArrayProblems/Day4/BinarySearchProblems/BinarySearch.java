package ArrayProblems.Day4.BinarySearchProblems;

public class BinarySearch {
    public static void main(String[] args) {
        int nums[] = { -1, 0, 3, 4, 9, 12};
        int target = 9;
        System.out.println(search(nums, target));
    }

    public static int search(int nums[], int target){
        if(nums == null || nums.length == 0) return -1;

        int n = nums.length;

        int left = 0, right = n - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(nums[mid] == target) return mid;

            else if(nums[mid] < target) left = mid + 1;

            else if(nums[mid] > target) right = mid - 1;
        }

        return -1;
    }
}
