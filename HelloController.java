package com.example.memorygame;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.*;

public class HelloController implements Initializable {

    @FXML
    private Label a0;

    @FXML
    private Label a1;

    @FXML
    private Label a2;

    @FXML
    private Label a3;

    @FXML
    private Label b0;

    @FXML
    private Label b1;

    @FXML
    private Label b2;

    @FXML
    private Label b3;

    @FXML
    private Label c0;

    @FXML
    private Label c1;

    @FXML
    private Label c2;

    @FXML
    private Label c3;
    ArrayList<Label> labels;
    ArrayList<Label> felforditott = new ArrayList<>();
    @FXML
    void kivalaszt(MouseEvent event) {
        if (felforditott.size() < 2) {
            Label clicked = (Label) event.getSource();
            felforditott.add(clicked);
            clicked.setTextFill(Paint.valueOf("#000000"));
        } else {
            if (ugyanolyan(felforditott.get(0),felforditott.get(1))) {
                eltuntet();
            } else {
                lefordit();
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labels = new ArrayList<>(Arrays.asList(a0,a1,a2,a3,b0,b1,b2,b3,c0,c1,c2,c3));
        newGame();
    }

    private void newGame() {
        ArrayList<Character> chars = new ArrayList<>(Arrays.asList('%','%','!','!','#','#','/','/','=','=','*','*'));
        Collections.shuffle(chars);
        for (int i = 0; i < labels.size(); i++) {
            labels.get(i).setText(String.valueOf(chars.get(i)));
            labels.get(i).setTextFill(Paint.valueOf("#808080"));
        }
    }
    private boolean ugyanolyan(Label l1, Label l2) {
        if (Objects.equals(l1.getText(), l2.getText())) {
            return true;
        } else {
            return false;
        }
    }
    private void eltuntet() {
        felforditott.get(0).setVisible(false);
        felforditott.get(1).setVisible(false);
        felforditott.clear();
    }
    private void lefordit() {
        felforditott.get(0).setTextFill(Paint.valueOf("#808080"));
        felforditott.get(1).setTextFill(Paint.valueOf("#808080"));
        felforditott.clear();
    }
}
