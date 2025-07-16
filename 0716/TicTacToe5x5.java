import java.util.Scanner;

public class TicTacToe5x5 {
    private static final int SIZE = 5;
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';
    private static char[][] board = new char[SIZE][SIZE];
    private static char currentPlayer = PLAYER_X;
    private static boolean gameOver = false;

    public static void main(String[] args) {
        initializeBoard();
        printBoard();
        
        Scanner scanner = new Scanner(System.in);
        
        while (!gameOver) {
            System.out.print("玩家 " + currentPlayer + " 請輸入兩個整數 row col (0-4): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            
            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                System.out.println("玩家 " + currentPlayer + " 在位置 (" + row + ", " + col + ") 放置棋子");
                printBoard();
                
                if (checkWin(row, col)) {
                    System.out.println("玩家 " + currentPlayer + " 獲勝！");
                    gameOver = true;
                } else if (isBoardFull()) {
                    System.out.println("平手！");
                    gameOver = true;
                } else {
                    currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
                }
            } else {
                System.out.println("錯誤訊息：座標超界或位置已被佔用，請重新輸入");
            }
        }
        
        scanner.close();
    }
    
    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }
    
    private static void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE && 
               col >= 0 && col < SIZE && 
               board[row][col] == EMPTY;
    }
    
    private static boolean checkWin(int row, int col) {
        
        boolean win = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] != currentPlayer) {
                win = false;
                break;
            }
        }
        if (win) return true;
        
        
        win = true;
        for (int i = 0; i < SIZE; i++) {
            if (board[i][col] != currentPlayer) {
                win = false;
                break;
            }
        }
        if (win) return true;
        
  
        if (row == col) {
            win = true;
            for (int i = 0; i < SIZE; i++) {
                if (board[i][i] != currentPlayer) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        
      
        if (row + col == SIZE - 1) {
            win = true;
            for (int i = 0; i < SIZE; i++) {
                if (board[i][SIZE - 1 - i] != currentPlayer) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }
        
        return false;
    }
    
    private static boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}