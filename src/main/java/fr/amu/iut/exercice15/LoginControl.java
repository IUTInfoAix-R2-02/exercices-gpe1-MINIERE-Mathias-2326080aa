package fr.amu.iut.exercice15;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginControl extends GridPane {
    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;

    private void createBindings() {
        BooleanProperty moinsDeSixCarac = new SimpleBooleanProperty();
        moinsDeSixCarac.bind(Bindings.greaterThanOrEqual(6, userId.lengthProperty()));
        pwd.textProperty().bind(Bindings.when(moinsDeSixCarac).then("").otherwise(pwd.getText()));
    }

    @FXML
    private void okClicked() {
        System.out.print(userId.getText() + " ");
        for (char c : pwd.getText().toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        userId.setText("");
        pwd.setText("");
    }
}