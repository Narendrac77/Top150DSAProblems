package ArrayProblems.ArraysRevision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
public static void main(String[] args) {
    int nums[] = { 1, 2, 3, 4};
    int result[] = sum(nums, 5);
    System.out.println(Arrays.toString(result));
}

public static int[] sum(int nums[], int target){
    Map<Integer, Integer> map = new HashMap<>();

    for(int i = 0; i < nums.length; i++){
        int diff = target - nums[i];
        if(map.containsKey(diff)){
            return new int[]{map.get(diff), i};
        }
        map.put(nums[i], i);
    }

    return new int[]{-1, -1};
}
}
