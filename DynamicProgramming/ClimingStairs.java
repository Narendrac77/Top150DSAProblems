package DynamicProgramming;

public class ClimingStairs {
    public static void main(String[] args) {
      int n = 5;
      System.out.println(climbStairs(n));  
    }

    public static int climbStairs(int n){
        if(n <= 2) return n;

        int previous = 1, previous_2 = 1;

        int i = 2;

        while( i <= n){
            int current = previous + previous_2;
            previous_2 = previous;
            previous = current;
            i++;
        }
        return previous;
    }
}
