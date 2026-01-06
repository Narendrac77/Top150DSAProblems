package ArrayProblems.ArraysRevision.Day2;

//import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

public class SubArraySumEqualToK {

    public static void main(String[] args) {
        // int nums[] = {1, 2, 3};
        // int nums[] = {1, 1, 1};
        int nums[] = { 1, 4, 2, 3, 5 };
        System.out.println(subArraySumOptimal(nums, 5));
    }

    public static int subArraySumOptimal(int nums[], int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;

        int prefixSum = 0;

        for(int n : nums){
            prefixSum += n;

            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    // Better approach O(N2) Time complexity
    public static int betterApproach(int nums[], int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                 sum =  sum + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    //O(N3) Time complexity
    public static int subArraySum(int nums[], int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int m = i; m <= j; m++) {
                    sum = sum + nums[m];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // Find All SubArrays
    /*
     * public static void main(String[] args) {
     * int nums[] = {1, 2, 3};
     * findAllSubArrays(nums, 0);
     * }
     * 
     * public static void findAllSubArrays(int nums[], int k){
     * int count = 0;
     * List<List<Integer>> list = new ArrayList<>();
     * for(int i = 0; i < nums.length; i++){
     * for(int j = i; j < nums.length; j++){
     * List<Integer> list2 = new ArrayList<>();
     * for(int m = i; m <= j; m++){
     * list2.add(nums[m]);
     * }
     * list.add(list2);
     * }
     * }
     * for(List<Integer> l : list){
     * System.out.println(l.toString());
     * }
     * }
     */
}
