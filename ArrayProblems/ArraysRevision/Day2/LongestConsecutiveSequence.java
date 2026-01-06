package ArrayProblems.ArraysRevision.Day2;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int nums[] = { 100, 4, 200, 1, 3, 2, 50, 51, 53, 55, 54, 56, 52};
        System.out.println(findLongestConsecutiveSequence(nums));
    }

    public static int findLongestConsecutiveSequence(int nums[]){
        Set<Integer> set = new HashSet<>();

        for(int val : nums){
            set.add(val);
        }

        int maxCount = 0;
        int curr = 0;
        for(int val : nums){
            if(!set.contains(val - 1)){
                while (set.contains(val)) {
                    curr++;
                    val++;
                }
                maxCount = Math.max(maxCount, curr);
            }
            curr = 0;
        }

        return maxCount;
    }
}
