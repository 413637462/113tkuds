public class TicTacToe5x5{
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    static char[][] initializeBoard() {
        char[][] board = new char[5][5]

        for (int row = 0 ;row < 5;row++) {
            for (int col= 0;col<5 ;col++){
                board[row][col] = EMPTY ;
            }
        }
        return board;
    }



}