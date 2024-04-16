package fr.amu.iut.exercice4;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Label label;
    private Pane panneau;
    private HBox bas;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.vert = new Button("Vert");
        this.rouge = new Button("Rouge");
        this.bleu = new Button("Bleu");
        this.bas = new HBox(vert,rouge,bleu);
        bas.setMinHeight(50);
        bas.setAlignment(Pos.CENTER);
        bas.setSpacing(10.0);

        this.label = new Label();
        label.setFont(Font.font("Courier", FontWeight.NORMAL, 16));
        label.setMaxWidth(400);
        label.setAlignment(Pos.CENTER);

        this.panneau = new Pane();

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent ->{
            nbVert += 1;
            label.setText("Vert choisi "+nbVert+" fois");
            panneau.setStyle("-fx-background-color: green");
        });

        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent ->{
            nbRouge += 1;
            label.setText("Rouge choisi "+nbRouge+" fois");
            panneau.setStyle("-fx-background-color: red");
        });

        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent ->{
            nbBleu += 1;
            label.setText("Bleu choisi "+nbBleu+" fois");
            panneau.setStyle("-fx-background-color: blue");
        });

        this.root = new BorderPane();
        root.setTop(label);
        root.setCenter(panneau);
        root.setBottom(bas);

        Scene scene = new Scene(root,400,200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

