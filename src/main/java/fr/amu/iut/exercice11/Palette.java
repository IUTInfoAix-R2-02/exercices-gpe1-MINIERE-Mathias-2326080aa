package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;
    private IntegerProperty nbFois;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;

    private StringProperty nomDuBouton;
    private StringProperty couleurPanneau;

    public Palette(){
        nbFois = new SimpleIntegerProperty();
        nomDuBouton = new SimpleStringProperty();
        couleurPanneau = new SimpleStringProperty("#000000");
    }
    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();

        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");

        /* VOTRE CODE ICI */
        vert.setOnAction(event -> {
            nbVert+=1;
            nbFois.set(nbVert);
            nomDuBouton.set(vert.getText());
            couleurPanneau.set("#008000");
        });
        rouge.setOnAction(event -> {
            nbRouge += 1;
            nbFois.set(nbRouge);
            nomDuBouton.set(rouge.getText());
            couleurPanneau.set("#FF0000");
        });
        bleu.setOnAction(event -> {
            nbBleu += 1;
            nbFois.set(nbBleu);
            nomDuBouton.set(bleu.getText());
            couleurPanneau.set("#0000FF");
        });
        createBindings();

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void createBindings(){
        BooleanProperty pasEncoreDeClick = new SimpleBooleanProperty();
        pasEncoreDeClick.bind(Bindings.equal(0,nbFois));
        texteDuHaut.textProperty().bind(Bindings.when(pasEncoreDeClick)
                .then("Cliquez sur un bouton")
                .otherwise(Bindings.concat(nomDuBouton, " choisi ", nbFois, " fois")));
        panneau.styleProperty().bind(couleurPanneau);
        texteDuBas.styleProperty().bind(couleurPanneau);
        texteDuBas.textProperty().bind(Bindings.when(pasEncoreDeClick)
                .then("")
                .otherwise(Bindings.concat("Le ", nomDuBouton, " est une jolie couleur !")));
    }
}

