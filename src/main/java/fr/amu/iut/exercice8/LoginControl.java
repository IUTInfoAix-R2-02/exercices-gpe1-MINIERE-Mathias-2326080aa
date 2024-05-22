package fr.amu.iut.exercice8;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {

    @FXML
    private TextField uid;

    @FXML
    private TextField pwd;

    @FXML
    private void okClicked() {
        System.out.println(uid.getCharacters());
        System.out.println("*".repeat(pwd.getLength()));
    }

    @FXML
    private void cancelClicked() {
        uid.setText("");
        pwd.setText("");
    }
}