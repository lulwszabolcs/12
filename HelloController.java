package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    @FXML
    private Label lbl5;

    @FXML
    private Label lbl6;

    @FXML
    private Label lbl7;

    @FXML
    private Label lbl8;

    @FXML
    private Label lblKattintas;

    @FXML
    private Label lblUzenet;
    private ArrayList<Label> kartyak;
    private ArrayList<Label> felforditottKartyak;
    private ArrayList<Label> marKitalalt;
    private ArrayList<String> ertekek;
    @FXML
    void felfordit(MouseEvent event) {
        if (felforditottKartyak.size() < 2) {
            Label clicked = (Label) event.getSource();
            if (!felforditottKartyak.contains(clicked)) {
                felforditottKartyak.add(clicked);
            }
            showCards();
            //showCards(felforditottKartyak.get(1));
            if (felforditottKartyak.size() == 2 && (felforditottKartyak.get(0).getText().equals(ertekek.get(0)))) {
                felforditottKartyak.get(0).setTextFill(Paint.valueOf("008000"));
                marKitalalt.add(felforditottKartyak.get(1));
                felforditottKartyak.remove(0);
                ertekek.remove(0);
                hideCards();

            } else if (felforditottKartyak.size() == 2 && felforditottKartyak.get(1).getText().equals(ertekek.get(0))) {
                felforditottKartyak.get(1).setTextFill(Paint.valueOf("008000"));
                marKitalalt.add(felforditottKartyak.get(1));
                felforditottKartyak.remove(1);
                ertekek.remove(0);
                hideCards();
            } else if (felforditottKartyak.size() == 2 && !felforditottKartyak.get(0).getText().equals(ertekek.get(0)) &&!felforditottKartyak.get(1).getText().equals(ertekek.get(0)) ) {
                felforditottKartyak.get(0).setTextFill(Paint.valueOf("#000000"));
                felforditottKartyak.remove(0);
            }
            if (marKitalalt.size() == 7) {
                lblUzenet.setText("NYertel");
                felforditottKartyak.get(0).setTextFill(Paint.valueOf("#008000"));
            }
        }

        /*
        if (felforditottKartyak.get(0).getText().equals(ertekek.get(0))) {
        } else if (felforditottKartyak.get(1).getText().equals(ertekek.get(0))) {
            ertekek.remove(0);
            felforditottKartyak.remove(0);
        }*/
        System.out.println(felforditottKartyak);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        felforditottKartyak = new ArrayList<>();
        marKitalalt = new ArrayList<>();
        ertekek = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8"));
        kartyak = new ArrayList<>(Arrays.asList(lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8));
        newGame();
        System.out.println(felforditottKartyak);

    }
    private void newGame() {
        for (Label label : kartyak) {
            label.setTextFill(Paint.valueOf("#000000"));
        }
        felforditottKartyak.clear();
    }
    private void showCards() {
        for (Label label : felforditottKartyak) {
            label.setTextFill(Paint.valueOf("#FFFFFF"));
        }
    }
    private void hideCards() {
        for (Label label : felforditottKartyak) {
            label.setTextFill(Paint.valueOf("#000000"));
        }
        felforditottKartyak.clear();
    }
}
