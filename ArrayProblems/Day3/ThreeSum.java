package ArrayProblems.Day3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {

    // Optimal approach with O(N^2) Time complexity
    public static void main(String[] args) {
        int nums[] = { -1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        for(List<Integer> list : result){
            System.out.println(list.toString());
        }
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) return result;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] > 0) break; // Optimal if nums[i] > 0 sum will never be 0. since array is sorted.
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if(sum > 0){
                    right--;
                } else{
                    left++;
                }
            }
        }

        return result;
    }
    
    
    //BruteForce Approach with time complexity O(N^3).
   /* public static void main(String[] args) {
        int nums[] = { -1, 0, 1, 2, -1, -4};
        Set<List<Integer>> result = threeSum(nums);
        for(List<Integer> list : result){
            System.out.println(list.toString());
        }
    }

    public static Set<List<Integer>> threeSum(int[] nums){
        if(nums.length < 3) return new HashSet<>();
        Set<List<Integer>> list = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        list.add(List.of(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return list;
    }*/
}
