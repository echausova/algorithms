package week1;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[][] result = new int[intervals.length][2];
        int[][] cur = new int[1][2];
        cur[0] = intervals[0];

        int k = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (cur[0][1] >= intervals[i][0] && cur[0][1] <= intervals[i][1]) { //  intervals[i][0] <= cur[0][1] < intervals[i][1]
                cur[0][1] = intervals[i][1];  // merge intervals
            } else if (cur[0][1] < intervals[i][0]) {
                // add curr to the result array and set curr to the next interval value
                result[k] = cur[0];
                cur[0] = intervals[i];
                k++;
            }
        }

        result[k] = cur[0];

        int[][] res = new int[k + 1][2];
        for (int i = 0; i < k + 1; i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = result[i][j];
            }
        }
        return res;
    }
}
