package LinkedListProblems;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        int nums[] = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int nums[]){
        int slowPointer = 0;
        int fastPointer = 0;

        while(true){
            slowPointer = nums[slowPointer];
            fastPointer = nums[nums[fastPointer]];

            if(slowPointer == fastPointer){
                break;
            }
        }

        slowPointer = 0;

        while (slowPointer != fastPointer) {
            slowPointer = nums[slowPointer];
            fastPointer = nums[fastPointer];
        }
        return slowPointer;
    }
}
