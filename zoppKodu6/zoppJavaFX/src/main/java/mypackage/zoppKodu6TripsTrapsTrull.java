package mypackage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.Optional;
import java.util.Random;

public class zoppKodu6TripsTrapsTrull extends Application {

    private char[][] board = new char[4][4]; // Kahemõõtmeline massiiv, mängulaud
    private Button[][] buttons = new Button[4][4]; // Sisaldab mänguväljal olevaid nuppe
    private char currentPlayer = 'X';

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane(); // Loob mänguvälja objekti
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                Button button = new Button();
                button.setPrefSize(100, 100);
                button.setOnAction(event -> { // Määrab tegevused nuppudele klikkides
                    int rowIndex = GridPane.getRowIndex(button);
                    int colIndex = GridPane.getColumnIndex(button);
                    if (board[rowIndex][colIndex] == 0) {
                        makeMove(button, rowIndex, colIndex);
                        if (!checkForWin()) {
                            computerMove();
                            if (!checkForWin()) {
                                checkForDraw();
                            }
                        }
                    }
                });
                buttons[row][col] = button;
                grid.add(button, col, row);
            }
        }
        // Kasutaja liidese andmed
        Scene scene = new Scene(grid, 420, 420);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Trips-Traps-Trull");
        primaryStage.show();
    }

    // Mängijate mänguvälja tähised
    private void makeMove(Button button, int row, int col) {
        if (board[row][col] == 0) {
            board[row][col] = currentPlayer;
            button.setText(currentPlayer + "");
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    // Arvuti käigu loogika
    private void computerMove() { // Eelis järjekorras püüab võita, seejärel takistada, muul juhul teeb suvalise käigu
        if (makeWinningMove() || makeBlockingMove()) {
            return;
        }
        // Suvalise käigu tegemine
        Random random = new Random();
        int row, col;
        do {
            row = random.nextInt(4);
            col = random.nextInt(4);
        } while (board[row][col] != 0); // Kuni leitakse vaba ruut

        board[row][col] = currentPlayer;
        buttons[row][col].setText(currentPlayer + "");
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Arvuti võitmis loogika
    private boolean makeWinningMove() {
        // Ridade kontroll võimalikuks võiduks
        for (int i = 0; i < 4; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer && board[i][3] == 0) {
                board[i][3] = currentPlayer;
                buttons[i][3].setText(currentPlayer + "");
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                return true;
            }
        }
        // Veergude kontroll võimalikuks võiduks
        for (int i = 0; i < 4; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer && board[3][i] == 0) {
                board[3][i] = currentPlayer;
                buttons[3][i].setText(currentPlayer + "");
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                return true;
            }
        }
        // Diagonaalide kontroll võimalikuks võiduks
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer && board[3][3] == 0) {
            board[3][3] = currentPlayer;
            buttons[3][3].setText(currentPlayer + "");
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            return true;
        }
        if (board[0][3] == currentPlayer && board[1][2] == currentPlayer && board[2][1] == currentPlayer && board[3][0] == 0) {
            board[3][0] = currentPlayer;
            buttons[3][0].setText(currentPlayer + "");
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            return true;
        }
        return false;
    }

    // Mängija blokeerimis loogika
    private boolean makeBlockingMove() {
        // Ridade kontroll võimalikuks blokeerimiseks
        for (int i = 0; i < 4; i++) {
            if (board[i][0] == 'X' && board[i][1] == 'X' && board[i][2] == 'X' && board[i][3] == 0) {
                board[i][3] = currentPlayer;
                buttons[i][3].setText(currentPlayer + "");
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                return true;
            }
        }
        // Veergude kontroll võimalikuks blokeerimiseks
        for (int i = 0; i < 4; i++) {
            if (board[0][i] == 'X' && board[1][i] == 'X' && board[2][i] == 'X' && board[3][i] == 0) {
                board[3][i] = currentPlayer;
                buttons[3][i].setText(currentPlayer + "");
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                return true;
            }
        }
        // Diagonaalide kontroll võimalikuks blokeerimiseks
        if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X' && board[3][3] == 0) {
            board[3][3] = currentPlayer;
            buttons[3][3].setText(currentPlayer + "");
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            return true;
        }
        if (board[0][3] == 'X' && board[1][2] == 'X' && board[2][1] == 'X' && board[3][0] == 0) {
            board[3][0] = currentPlayer;
            buttons[3][0].setText(currentPlayer + "");
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            return true;
        }
        return false;
    }

    // Mängu võitja kontroll
    private boolean checkForWin() {
        // Ridade kontroll
        for (int i = 0; i < 4; i++) {
            if (board[i][0] != 0 && board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][2] == board[i][3]) {
                announceWinner(board[i][0]);
                return true;
            }
        }

        // Veergude kontroll
        for (int i = 0; i < 4; i++) {
            if (board[0][i] != 0 && board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[2][i] == board[3][i]) {
                announceWinner(board[0][i]);
                return true;
            }
        }

        // Diagonaalide kontroll
        if (board[0][0] != 0 && board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] == board[3][3]) {
            announceWinner(board[0][0]);
            return true;
        }
        if (board[0][3] != 0 && board[0][3] == board[1][2] && board[1][2] == board[2][1] && board[2][1] == board[3][0]) {
            announceWinner(board[0][3]);
            return true;
        }

        return false;
    }

    // Mängu võitja teavitus
    private void announceWinner(char winner) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Trips-Traps-Trull");
        alert.setHeaderText(null);
        alert.setContentText("Mängu võitis mängija " + winner);
        alert.showAndWait();
        askForNewGame();
    }
    // Viigi kontroll
    private void checkForDraw() {
        boolean isDraw = true;
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col] == 0) {
                    isDraw = false;
                    break;
                }
            }
        }
        if (isDraw) {
            announceDraw();
        }
    }
    // Viigi teavitus
    private void announceDraw() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Trips-Traps-Trull");
        alert.setHeaderText(null);
        alert.setContentText("Mäng lõppes viigiga!");
        alert.showAndWait();
        askForNewGame();
    }
    // Uue mängu küsimine
    private void askForNewGame() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Trips-Traps-Trull");
        alert.setHeaderText(null);
        alert.setContentText("Kas soovid uuesti mängida?");

        ButtonType yesButton = new ButtonType("Jah");
        ButtonType noButton = new ButtonType("Ei");

        alert.getButtonTypes().setAll(yesButton, noButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == yesButton) {
            startNewGame();
        } else {
            Platform.exit(); // Sulgeb rakenduse
        }
    }
    // Alustab uue mängu
    private void startNewGame() {
        // Nullib mängulaua ja alustab uue mänguga
        board = new char[4][4];
        currentPlayer = 'X';
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j].setText("");
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
