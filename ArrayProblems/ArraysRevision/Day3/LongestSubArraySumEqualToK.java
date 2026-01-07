package ArrayProblems.ArraysRevision.Day3;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArraySumEqualToK {
    public static void main(String[] args) {
        int nums[] = { 1, -1, 5, -2, 3 };
        System.out.println(longestSubString(nums, 3));
    }

    public static int longestSubString(int nums[], int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;

        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum = prefixSum + nums[i];
            if (map.containsKey(prefixSum - k)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - k));
            }
            map.putIfAbsent(prefixSum, i);
        }
        return maxLen;
    }
}
