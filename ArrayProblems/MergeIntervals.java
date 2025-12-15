package ArrayProblems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(intervals);

        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static int[][] merge(int intervals[][]){
        if(intervals == null || intervals.length == 0){
            return new int[0][0];
        }
        // Sort intervals by start time
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        //merge overlapping intervals
        for(int i = 1; i < intervals.length; i++){
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if(currentStart <= end){
                //Overlapping intervals -> merge
                end = Math.max(end, currentEnd);
            }

            else{
                //Non-overlapping -> add pervious and reset
                merged.add(new int[]{start, end});
                start = currentStart;
                end = currentEnd;
            }
        }

        //Add the last interval
        merged.add(new int[]{start, end});

        return merged.toArray(new int[merged.size()][]);

    }
}
