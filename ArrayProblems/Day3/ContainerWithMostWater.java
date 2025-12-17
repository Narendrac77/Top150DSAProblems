package ArrayProblems.Day3;

//https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int height[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height)); 
    }

    public static int maxArea(int height[]){
        if(height == null || height.length == 0) return 0;

        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int distance = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = distance * minHeight;

            maxArea = Math.max(maxArea, area);

            if(height[left] < height[right]){
                left++;
            } else right--;
        }

        return maxArea;
    }
}
