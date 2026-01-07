package ArrayProblems.ArraysRevision.Day3;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumDivisibleByK {
    public static void main(String[] args) {
        int nums[] = { 4, 5, 0, -2, -3, 1};
        System.out.println(subArrayDivisibleByK(nums, 5));
    }

    public static int subArrayDivisibleByK(int nums[], int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int prefixSum = 0;

        for(int n : nums){
            prefixSum = prefixSum + n;
            int rem = (prefixSum % k + k) % k; //normalization
            if(map.containsKey(rem)){
                count = count + map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
    
}
