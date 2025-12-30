package ArrayProblems.ArraysRevision;

import java.util.ArrayList;
import java.util.List;

/*Given an integer array nums and an integer k,
return the number of continuous subarrays whose sum equals k.

Example
nums = [1, 2, 3]
k = 3
Output: 2
Explanation: [1,2] and [3]

Constraints

1 <= nums.length <= 2 * 10^5

-10^4 <= nums[i] <= 10^4

-10^7 <= k <= 10^7
 */
public class SubArrayProblem {

    public static void main(String[] args) {
        int nums[] = { 1, 2, 1 };
        List<List<Integer>> result = subArraysEqualToK(nums, 3);
        for (List<Integer> l : result) {
            System.out.println(l);
        }
    }

    public static List<List<Integer>> subArraysEqualToK(int nums[], int k) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    List<Integer> subArray = new ArrayList<>();
                    for (int m = i; m <= j; m++) {
                        subArray.add(nums[m]);
                    }
                    list.add(subArray);
                }
            }
        }
        return list;
    }

}
