package ArrayProblems.ArraysRevision;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
         int nums1[] = { 1, 2, 3, 0, 0, 0};
        int nums2[] = {2, 5, 6};
        int m = 3,  n = 3;
        mergeArray(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
        
    }

    public static void mergeArray(int nums1[], int m, int nums2[], int n){

        int i = m - 1; int j = n - 1;
        int end = nums1.length - 1;
        while ( i >= 0 && j >= 0) {
            if(nums1[i] >= nums2[j]){
                nums1[end--] = nums1[i--];
            } else {
                nums1[end--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[end--] = nums2[j--];
        }
    }

    //Classic Sorted array Merge Problem
   /*  public static void main(String[] args) {
        int nums1[] = { 1, 2, 3};
        int nums2[] = {2, 5, 6};
        int result[] = mergeArray(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] mergeArray(int nums1[], int nums2[]){
        
        int m = nums1.length;
        int n =  nums2.length;
        int result[] = new int[m + n];

        int i = 0; int j = 0;
        int start = 0;
        while ( i < m && j < n) {
            if(nums1[i] <= nums2[j]){
                result[start++] = nums1[i++];
            } else {
                result[start++] = nums2[j++];
            }
        }

        while (i < m) {
            result[start++] = nums1[i++];
        }

        while (j < n) {
            result[start++] = nums2[j++];
        }

        return result;
    } */
}
