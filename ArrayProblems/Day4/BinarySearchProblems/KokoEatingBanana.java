package ArrayProblems.Day4.BinarySearchProblems;

//https://leetcode.com/problems/koko-eating-bananas/description/
public class KokoEatingBanana {
    public static void main(String[] args) {
        int piles[] = { 30, 11, 23, 4, 20};
        int h = 6;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int piles[], int h){
        int left = 1, right = 0;

        for(int pile : piles){
            right = Math.max(right, pile);
        }
        while(left < right){
            int mid = left + (right -left)/ 2;

            if(canFinish(piles, h, mid)){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean canFinish(int piles[], int h, int k){
        int hours = 0;
        for(int pile : piles){
            hours = hours + (pile + k - 1) / k;
            if(hours > h) return false;
        }
        return true;
    }
}
