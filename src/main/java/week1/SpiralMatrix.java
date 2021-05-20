package week1;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix[0].length - 1; //3
        int m = matrix.length - 1; // 2
        List<Integer> result = new ArrayList<>();

        int right = n;
        int left = 0;
        int top = 0;
        int bottom = m;

        Direction direction = Direction.LEFT;

        while (left <= right && top <= bottom) {
            if (direction == Direction.LEFT) {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[top][i]);
                }
                direction = Direction.DOWN;
                top++;
            } else if (direction == Direction.DOWN) {
                for (int i = top; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                    direction = Direction.RIGHT;
                }
                right--;
            } else if (direction == Direction.RIGHT) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                direction = Direction.UP;
                bottom--;
            } else if (direction == Direction.UP) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                direction = Direction.LEFT;
                left++;
            }
        }
        return result;
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
}