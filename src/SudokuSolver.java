public class SudokuSolver {
    public static void main(String[] args) {
        String[][] board = {
                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6",".",".","1","9","5",".",".","."},
                {".","9","8",".",".",".",".","6","."},
                {"8",".",".",".","6",".",".",".","3"},
                {"4",".",".","8",".","3",".",".","1"},
                {"7",".",".",".","2",".",".",".","6"},
                {".","6",".",".",".",".","2","8","."},
                {".",".",".","4","1","9",".",".","5"},
                {".",".",".",".","8",".",".","7","9"}};

        printBoard(board);
        solveSudoku(board);
        printBoard(board);
    }

    public static void solveSudoku(String[][] board) {
        solve(board);
    }

    private static boolean solve(String[][] board) {
        //printBoard(board);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(".")) {
                    for (int k = 1; k <= 9; k++) {
                        if (isValid(board, i, j, k)) {
                            board[i][j] = ""+k;
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = ".";
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(String[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i].equals(""+num)  || board[i][col].equals(""+num)) {
                return false;
            }
        }
        return true;
    }

    private static void printBoard(String[][] board) {
        System.out.println();
        for (String[] row : board) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}