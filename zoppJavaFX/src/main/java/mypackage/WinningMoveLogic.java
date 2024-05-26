package mypackage;

import javafx.scene.control.Button;

public class WinningMoveLogic {
    public static boolean makeWinningMove(char[][] board, Button[][] buttons, char currentPlayer) {
        // Ridade kontroll võimaliku võidu saavutamiseks
        for (int i = 0; i < 4; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer && board[i][3] == 0) {
                board[i][3] = currentPlayer;
                buttons[i][3].setText(currentPlayer + "");
                return true;
            }
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][3] == currentPlayer && board[i][2] == 0) {
                board[i][2] = currentPlayer;
                buttons[i][2].setText(currentPlayer + "");
                return true;
            }
            if (board[i][0] == currentPlayer && board[i][2] == currentPlayer && board[i][3] == currentPlayer && board[i][1] == 0) {
                board[i][1] = currentPlayer;
                buttons[i][1].setText(currentPlayer + "");
                return true;
            }
            if (board[i][1] == currentPlayer && board[i][2] == currentPlayer && board[i][3] == currentPlayer && board[i][0] == 0) {
                board[i][0] = currentPlayer;
                buttons[i][0].setText(currentPlayer + "");
                return true;
            }
        }

        // Veergude kontroll võimaliku võidu saavutamiseks
        for (int i = 0; i < 4; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer && board[3][i] == 0) {
                board[3][i] = currentPlayer;
                buttons[3][i].setText(currentPlayer + "");
                return true;
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[3][i] == currentPlayer && board[2][i] == 0) {
                board[2][i] = currentPlayer;
                buttons[2][i].setText(currentPlayer + "");
                return true;
            }
            if (board[0][i] == currentPlayer && board[2][i] == currentPlayer && board[3][i] == currentPlayer && board[1][i] == 0) {
                board[1][i] = currentPlayer;
                buttons[1][i].setText(currentPlayer + "");
                return true;
            }
            if (board[1][i] == currentPlayer && board[2][i] == currentPlayer && board[3][i] == currentPlayer && board[0][i] == 0) {
                board[0][i] = currentPlayer;
                buttons[0][i].setText(currentPlayer + "");
                return true;
            }
        }

        // Diagonaalide kontroll võimaliku võidu saavutamiseks
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer && board[3][3] == 0) {
            board[3][3] = currentPlayer;
            buttons[3][3].setText(currentPlayer + "");
            return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[3][3] == currentPlayer && board[2][2] == 0) {
            board[2][2] = currentPlayer;
            buttons[2][2].setText(currentPlayer + "");
            return true;
        }
        if (board[0][0] == currentPlayer && board[2][2] == currentPlayer && board[3][3] == currentPlayer && board[1][1] == 0) {
            board[1][1] = currentPlayer;
            buttons[1][1].setText(currentPlayer + "");
            return true;
        }
        if (board[1][1] == currentPlayer && board[2][2] == currentPlayer && board[3][3] == currentPlayer && board[0][0] == 0) {
            board[0][0] = currentPlayer;
            buttons[0][0].setText(currentPlayer + "");
            return true;
        }

        if (board[0][3] == currentPlayer && board[1][2] == currentPlayer && board[2][1] == currentPlayer && board[3][0] == 0) {
            board[3][0] = currentPlayer;
            buttons[3][0].setText(currentPlayer + "");
            return true;
        }
        if (board[0][3] == currentPlayer && board[1][2] == currentPlayer && board[3][0] == currentPlayer && board[2][1] == 0) {
            board[2][1] = currentPlayer;
            buttons[2][1].setText(currentPlayer + "");
            return true;
        }
        if (board[0][3] == currentPlayer && board[2][1] == currentPlayer && board[3][0] == currentPlayer && board[1][2] == 0) {
            board[1][2] = currentPlayer;
            buttons[1][2].setText(currentPlayer + "");
            return true;
        }
        if (board[1][2] == currentPlayer && board[2][1] == currentPlayer && board[3][0] == currentPlayer && board[0][3] == 0) {
            board[0][3] = currentPlayer;
            buttons[0][3].setText(currentPlayer + "");
            return true;
        }

        return false;
    }
}