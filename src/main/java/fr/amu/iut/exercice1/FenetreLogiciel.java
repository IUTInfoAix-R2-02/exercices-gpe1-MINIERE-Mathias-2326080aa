package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();

        Menu fichier = new Menu("File");
        MenuItem nouveau = new MenuItem("New");
        MenuItem ouvrir = new MenuItem("Open");
        MenuItem sauvegarder = new MenuItem("Save");
        MenuItem fermer = new MenuItem("Close");
        fichier.getItems().addAll(nouveau,ouvrir,sauvegarder,fermer);
        Menu editer = new Menu("Edit");
        MenuItem couper = new MenuItem("Cut");
        MenuItem copier = new MenuItem("Copy");
        MenuItem coller = new MenuItem("Paste");
        editer.getItems().addAll(couper,copier,coller);
        Menu aide = new Menu("Help");
        MenuBar menubar = new MenuBar(fichier,editer,aide);

        HBox gauche = new HBox();
        VBox bGauche = new VBox();
        Label l1 = new Label("Boutons :");
        Button b1 = new Button("bouton 1");
        Button b2 = new Button("bouton 2");
        Button b3 = new Button("bouton 3");
        bGauche.getChildren().addAll(l1,b1,b2,b3);
        bGauche.setAlignment(Pos.CENTER);
        bGauche.setSpacing(10.0);
        Separator separatorV = new Separator(Orientation.VERTICAL);
        gauche.getChildren().addAll(bGauche,separatorV);

        HBox centre = new HBox();
        VBox centreV = new VBox();
        GridPane form = new GridPane();
        Label nom = new Label("Name:");
        Label email = new Label("Email:");
        Label motDePasse = new Label("Password:");
        TextArea txtAr1 = new TextArea();
        TextArea txtAr2 = new TextArea();
        TextArea txtAr3 = new TextArea();
        txtAr1.setMaxSize(100.0,30.0);
        txtAr2.setMaxSize(100.0,30.0);
        txtAr3.setMaxSize(100.0,30.0);
        form.add(nom,0,0);
        form.add(email,0,1);
        form.add(motDePasse, 0, 2);
        form.add(txtAr1,1,0);
        form.add(txtAr2,1,1);
        form.add(txtAr3,1,2);

        HBox bCentre = new HBox();
        Button envoie = new Button("Submit");
        Button annule = new Button("Cancel");
        bCentre.getChildren().addAll(envoie,annule);

        centreV.setAlignment(Pos.CENTER);
        centreV.getChildren().addAll(form,bCentre);
        HBox.setHgrow(centre,Priority.ALWAYS);
        centre.setAlignment(Pos.CENTER);
        centre.getChildren().add(centreV);

        HBox bas = new HBox();
        VBox lBasEtSeparator = new VBox();
        Separator separatorH = new Separator(Orientation.HORIZONTAL);
        Label lBas = new Label("Ceci est un label de bas de page");
        lBasEtSeparator.getChildren().addAll(separatorH,lBas);
        bas.setAlignment(Pos.CENTER);
        bas.getChildren().addAll(lBasEtSeparator);

        root.setTop(menubar);
        root.setLeft(gauche);
        root.setCenter(centre);
        root.setBottom(bas);

        Scene scene = new Scene(root,700,700);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

