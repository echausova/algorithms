package week1;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_v2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int right = matrix[0].length - 1;
        int left = 0;
        int top = 0;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++) {  // left to right
                result.add(matrix[top][i]);
            }

            for (int i = top + 1; i <= bottom; i++) { //top to bottom
                result.add(matrix[i][right]);
            }

            if (left < right && top < bottom) {
                for (int i = right - 1; i >= left; i--) { // right to left
                    result.add(matrix[bottom][i]);
                }

                for (int i = bottom - 1; i > top; i--) { // bottom to up
                    result.add(matrix[i][left]);
                }
            }

            top++;
            left++;
            bottom--;
            right--;

        }
        return result;
    }
}
