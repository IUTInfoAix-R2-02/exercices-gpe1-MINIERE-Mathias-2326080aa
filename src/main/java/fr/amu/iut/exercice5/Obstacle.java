package fr.amu.iut.exercice5;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Obstacle extends Rectangle {
    public Obstacle (double x,double y, double longueurX, double longueurY){
        super(Personnage.LARGEUR_PERSONNAGE*x,Personnage.LARGEUR_PERSONNAGE*y,Personnage.LARGEUR_PERSONNAGE*longueurX,Personnage.LARGEUR_PERSONNAGE*longueurY);
        super.setFill(Color.DARKRED);
    }
}
