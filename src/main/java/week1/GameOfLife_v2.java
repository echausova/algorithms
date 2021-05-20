package week1;

public class GameOfLife_v2 {
    public void gameOfLife(int[][] board) {
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

                updateState(board, count, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private void updateState(int[][] board, int count, int i, int j) {
        // 2 = 0 -> 1
        // 3 = 1 -> 0
        if ((board[i][j] == 1 || board[i][j] == 3) && (count < 2 || count > 3)) {
            board[i][j] = 3;
        } else if ((board[i][j] == 0 || board[i][j] == 2) && count == 3) {
            board[i][j] = 2;
        }
    }

    private int findLiveNeighbors(int[][] board, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (i >= board.length || j >= board[0].length) {
            return 0;
        }

        if (board[i][j] == 1 || board[i][j] == 3) {
            return 1;
        }
        return 0;
    }
}
