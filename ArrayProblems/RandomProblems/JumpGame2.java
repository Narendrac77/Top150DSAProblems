package ArrayProblems.RandomProblems;

//https://leetcode.com/problems/jump-game-ii/description/
public class JumpGame2 {
    public static void main(String[] args) {
        int nums[] = { 2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    public static int jump(int nums[]){
        int farthest = 0;
        int jump = 0;
        int end = 0;

        for(int i = 0; i < nums.length - 1; i++){
            farthest = Math.max(farthest, i + nums[i]);

            if(i == end){
                jump++;
                end = farthest;
            }
        }
        return jump;
    }
}
