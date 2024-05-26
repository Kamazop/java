package com.example.zoppjavafx;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private ToggleGroup Valik1;
    @FXML
    private TextArea sisend;
    @FXML
    private RadioButton valik1;
    @FXML
    private RadioButton valik2;
    @FXML
    private RadioButton valik3;
    @FXML
    private RadioButton valik4;
    @FXML
    private Button vastus1;
    @FXML
    private Button vastus2;
    @FXML
    private Text vastustext1;
    @FXML
    private Text vastustext2;
    @FXML
    void vastus1(ActionEvent event) {
        if (valik3.isSelected()) {
            vastustext1.setText("Õige");
            vastustext1.setFill(Color.BLUE);
        } else {
            vastustext1.setText("Vale");
            vastustext1.setFill(Color.RED);
        }
    }
    @FXML
    void vastus2(ActionEvent event) {
        if (sisend.getText().equals("Objektorienteeritud programmeerimine")) {
            vastustext2.setText("Õige");
            vastustext2.setFill(Color.BLUE);
        } else {
            vastustext2.setText("Vale");
            vastustext2.setFill(Color.RED);
        }
    }
}
