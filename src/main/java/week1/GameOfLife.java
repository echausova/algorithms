package week1;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[][] result = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = 0;
                count += findLiveNeighbors(board, i - 1, j - 1);
                count += findLiveNeighbors(board, i - 1, j);
                count += findLiveNeighbors(board, i - 1, j + 1);


                count += findLiveNeighbors(board, i, j - 1);
                count += findLiveNeighbors(board, i, j + 1);

                count += findLiveNeighbors(board, i + 1, j - 1);
                count += findLiveNeighbors(board, i + 1, j);
                count += findLiveNeighbors(board, i + 1, j + 1);

                updateState(board, result, count, i, j);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = result[i][j];
            }
        }

    }

    private void updateState(int[][] board, int[][] result, int count, int i, int j) {
        if (board[i][j] == 1 && (count < 2 || count > 3)) {
            result[i][j] = 0;
        } else if (board[i][j] == 0 && count == 3) {
            result[i][j] = 1;
        } else {
            result[i][j] = board[i][j];
        }
    }

    private int findLiveNeighbors(int[][] board, int i, int j) {

        if (i < 0 || j < 0) {
            return 0;
        }
        if (i >= board.length || j >= board[0].length) {
            return 0;
        }

        if (board[i][j] == 1) {
            return 1;
        }
        return 0;
    }
}
