package mypackage;

import javafx.scene.control.Button;

public class BlockingMoveLogic {
    // Mängija blokeerimis loogika
    public static boolean makeBlockingMove(char[][] board, Button[][] buttons, char currentPlayer) {
        // Check rows for potential blocking move
        for (int i = 0; i < 4; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer && board[i][3] == 0) {
                board[i][3] = 'O'; // Arvuti paneb vastu viimase nupu
                buttons[i][3].setText("O");
                return true;
            }
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == 0 && board[i][3] == currentPlayer) {
                board[i][2] = 'O'; // Arvuti paneb vastu viimase nupu
                buttons[i][2].setText("O");
                return true;
            }
            if (board[i][0] == currentPlayer && board[i][1] == 0 && board[i][2] == currentPlayer && board[i][3] == currentPlayer) {
                board[i][1] = 'O'; // Arvuti paneb vastu teise nupu
                buttons[i][1].setText("O");
                return true;
            }
            if (board[i][0] == 0 && board[i][1] == currentPlayer && board[i][2] == currentPlayer && board[i][3] == currentPlayer) {
                board[i][0] = 'O'; // Arvuti paneb vastu esimese nupu
                buttons[i][0].setText("O");
                return true;
            }
        }
        // Check columns for potential blocking move
        for (int i = 0; i < 4; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer && board[3][i] == 0) {
                board[3][i] = 'O';
                buttons[3][i].setText("0");
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == 0 && board[3][i] == currentPlayer) {
                board[2][i] = 'O'; // Arvuti paneb vastu viimase nupu
                buttons[2][i].setText("O");
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == 0 && board[2][i] == currentPlayer && board[3][i] == currentPlayer) {
                board[1][i] = 'O'; // Arvuti paneb vastu teise nupu
                buttons[1][i].setText("O");
                return true;
            }
            if (board[0][i] == 0 && board[1][i] == currentPlayer && board[2][i] == currentPlayer && board[3][i] == currentPlayer) {
                board[0][i] = 'O'; // Arvuti paneb vastu esimese nupu
                buttons[0][i].setText("O");
                return true;
            }
        }
        // Check diagonals for potential blocking move (top-left to bottom-right)
        for (int i = 0; i < 2; i++) {
            if (board[i][i] == currentPlayer && board[i+1][i+1] == currentPlayer && board[i+2][i+2] == currentPlayer && board[i+3][i+3] == 0) {
                board[i+3][i+3] = 'O'; // Arvuti paneb vastu viimase nupu
                buttons[i+3][i+3].setText("O");
                return true;
            }
        }
        // Check diagonals for potential blocking move (top-right to bottom-left)
        for (int i = 0; i < 2; i++) {
            if (board[i][3-i] == currentPlayer && board[i+1][2-i] == currentPlayer && board[i+2][1-i] == currentPlayer && board[i+3][0-i] == 0) {
                board[i+3][0-i] = 'O'; // Arvuti paneb vastu viimase nupu
                buttons[i+3][0-i].setText("O");
                return true;
            }
        }
        return false;
    }
}