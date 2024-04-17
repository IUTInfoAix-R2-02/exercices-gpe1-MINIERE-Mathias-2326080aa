package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Timer;

public class JeuMain extends Application {
    private static ArrayList<Obstacle> obstacles = new ArrayList<>();
    private Scene scene;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {
        obstacles.add(new Obstacle(5,2,2,20));
        obstacles.add(new Obstacle(10,10,10,1));

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);

        jeu.getChildren().addAll(obstacles);

        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            double j1_X=j1.getLayoutX();
            double j1_Y=j1.getLayoutY();
            double j2_X=j2.getLayoutX();
            double j2_Y=j2.getLayoutY();
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;

            }
            for (int i=0; i < obstacles.size(); ++i){
                if (j1.estEnCollision(obstacles.get(i))){
                    j1.setLayoutX(j1_X);
                    j1.setLayoutY(j1_Y);
                }
                if (j2.estEnCollision(obstacles.get(i))){
                    j2.setLayoutX(j2_X);
                    j2.setLayoutY(j2_Y);
                }
            }
            if (j1.estEnCollision(j2))
                System.exit(0);
        });
    }


}
