package com.example.zoppjavafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class zoppT8 extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Peaaken
        primaryStage.setTitle("Küsimustele Vastamine");

        // Pealdised
        Label pealdis1 = createHeaderLabel("Küsimus 1 - Mis tähega algab tähestik?");
        Label pealdis2 = createHeaderLabel("Küsimus 2 - Mis kukkus väidetavalt Newtonile pähe?");

        // Küsimused
        VBox küsimus1Kast = createQuestionBox("Vali õige vastus:", "A", "B", "C", "D");

        // Vastuse nupud
        VBox küsimus2Kast = createQuestionBox("Sisesta vastus:");
        Button vastuseNupp1 = createAnswerButton("Vasta", küsimus1Kast);
        Button vastuseNupp2 = createAnswerButton("Vasta", küsimus2Kast);

        // Peaakna paigutus
        VBox mainLayout = new VBox(20);
        mainLayout.setAlignment(Pos.CENTER);
        mainLayout.setPadding(new Insets(20));
        mainLayout.getChildren().addAll(pealdis1, küsimus1Kast, vastuseNupp1, pealdis2, küsimus2Kast, vastuseNupp2);

        // Stseeni loomine
        Scene stseen = new Scene(mainLayout, 800, 800);
        primaryStage.setScene(stseen);
        primaryStage.show();
    }

    // Pealdised loomine
    private Label createHeaderLabel(String text) {
        Label pealdis = new Label(text);
        pealdis.setFont(Font.font("Arial", 30));
        pealdis.setTextFill(Color.GREEN);
        return pealdis;
    }

    // Küsimuste kast
    private VBox createQuestionBox(String prompt, String... choices) {
        VBox questionBox = new VBox(10);
        Label promptLabel = new Label(prompt);
        promptLabel.setFont(Font.font("Arial", 20));
        if (choices.length > 0) {
            ComboBox<String> choiceBox = new ComboBox<>();
            choiceBox.getItems().addAll(choices);
            questionBox.getChildren().addAll(promptLabel, choiceBox);
        } else {
            TextField answerField = new TextField();
            questionBox.getChildren().addAll(promptLabel, answerField);
        }
        return questionBox;
    }

    // Vastuse nupp
    private Button createAnswerButton(String text, VBox questionBox) {
        Button button = new Button(text);
        button.setOnAction(e -> {
            // Kontrolli vastust
            boolean correct = checkAnswer(questionBox);
            // Lisa vastuse kuvamine
            Label resultLabel = new Label(correct ? "Õige" : "Vale");
            resultLabel.setFont(Font.font("Arial", 30));
            resultLabel.setTextFill(correct ? Color.BLUE : Color.RED);
            questionBox.getChildren().add(resultLabel);
        });
        return button;
    }

    // Vastuse kontroll
    private boolean checkAnswer(VBox questionBox) {
        // Kui küsimuse tüüp on valikvastus
        if (questionBox.getChildren().size() == 2 && questionBox.getChildren().get(1) instanceof ComboBox) {
            ComboBox<String> choiceBox = (ComboBox<String>) questionBox.getChildren().get(1);
            String selectedAnswer = choiceBox.getSelectionModel().getSelectedItem();
            return selectedAnswer != null && selectedAnswer.equals("A"); // Kontrollib antud vastust
        }
        // Kui küsimuse tüüp on tekstivastus
        if (questionBox.getChildren().size() == 2 && questionBox.getChildren().get(1) instanceof TextField) {
            TextField answerField = (TextField) questionBox.getChildren().get(1);
            String givenAnswer = answerField.getText();
            String correctAnswer = "õun"; // Teise küsimuse õige vastus määramine
            boolean correct = givenAnswer != null && givenAnswer.equalsIgnoreCase(correctAnswer); // Kontrollib antud vastust
            return correct;
        }
        return false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
