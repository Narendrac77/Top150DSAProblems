package ArrayProblems;

//https://leetcode.com/problems/remove-element/description/
public class RemoveElement {
    
    public static void main(String[] args) {
       int nums[] ={3, 2, 2, 3};
       int n = removeElement(nums, 3);
       for(int i = 0; i < n; i++){
        System.out.print(nums[i] + " ");
       } 
    }

    public static int removeElement(int nums[], int val){
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

}
