package ArrayProblems.ArraysRevision.Day2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int nums[] = { 1, 1, 1, 2, 2, 3, 4, 4, 4 };
        int result[] = topkFrequentEle(nums, 2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] topkFrequentEle(int nums[], int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int val : nums) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }

        // PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a,
        // b) -> a.getValue() - b.getValue());

        //Comparator polished
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int result[] = new int[k];
        int i = 0;

        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.poll().getKey();
        }

        return result;
    }
}
