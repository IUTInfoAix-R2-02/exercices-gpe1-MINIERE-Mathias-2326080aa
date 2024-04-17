package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IHMPendu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Dico dico = new Dico();
        String mot = dico.getMot();
        String motCache = "*".repeat(mot.length());

        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        VBox root= new VBox();
        root.setAlignment(Pos.CENTER);

        Label nbVies = new Label("Nombre de vies :");
        Label pendu = new Label(motCache);
        TextField lettre = new TextField();

        root.setStyle("-fx-background-color: #d8fbf6");
        root.getChildren().addAll(nbVies,pendu,lettre);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
