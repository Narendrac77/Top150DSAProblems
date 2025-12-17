package ArrayProblems.Day3;

public class TrappingRainWater {
    public static void main(String[] args) {
        int height[] = { 0, 1, 0, 2, 1, 0, 1, 2, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int height[]){
        if(height == null || height.length < 2) return 0;

        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, trappedWater = 0;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                } else{
                    trappedWater = trappedWater + (leftMax - height[left]);
                }
                left++;
            } else {
                if(height[right] >= rightMax){
                    rightMax = height[right];
                } else {
                    trappedWater = trappedWater + (rightMax - height[right]);
                }
                right--;
            }
        }
        return trappedWater;
    }
}
