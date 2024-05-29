package fr.amu.iut.exercice13;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

@SuppressWarnings("Duplicates")
public class MainPersonnes  {

    private static ObservableList<Personne> lesPersonnes;

    private static ListChangeListener<Personne> unChangementListener;

    public static void main(String[] args) {

        lesPersonnes = FXCollections.observableArrayList(personne -> new Observable[]{personne.ageProperty()});

        unChangementListener = new ListChangeListener<Personne>() {
            @Override
            public void onChanged(Change<? extends Personne> change) {
                while (change.next()) {
                    if (change.wasAdded()) {
                        for (Personne addPersonne : change.getAddedSubList())
                            System.out.println(addPersonne.getNom());
                    } else if (change.wasRemoved()){
                        for (Personne remPersonne : change.getRemoved())
                            System.out.println(remPersonne.getNom());
                    } else if (change.wasUpdated()) {
                        Personne updPersonne = change.getList().get(change.getFrom());
                        System.out.println(updPersonne.getNom()+ " a maintenant "+ updPersonne.getAge()+ " ans.");
                    }
                }
                System.out.println("Fin");
            }
        };

        ListChangeListener<Personne> plusieursChangementListener = new ListChangeListener<Personne>() {
            @Override
            public void onChanged(Change<? extends Personne> change) {
                while (change.next()) {
                    if (change.wasAdded()) {
                        for (Personne addPersonne : change.getAddedSubList())
                            System.out.println(addPersonne.getNom());
                    }
                    if (change.wasRemoved()) {
                        for (Personne remPersonne : change.getRemoved())
                            System.out.println(remPersonne.getNom());
                    }
                    if (change.wasUpdated()) {
                        Personne updPersonne = change.getList().get(change.getFrom());
                        System.out.println(updPersonne.getNom() + " a maintenant " + updPersonne.getAge() + " ans.");
                    }
                }
                System.out.println("Fin");
            }
        };


        lesPersonnes.addListener(plusieursChangementListener);
        question5();
    }

    public static void question1() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
    }

    public static void question2() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        lesPersonnes.remove(paul);
    }

    public static void question3() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        paul.setAge(5);
    }

    public static void question5() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.addAll(pierre, paul, jacques);
        for (Personne p : lesPersonnes)
            p.setAge(p.getAge()+10);
        lesPersonnes.removeAll(paul, pierre);
    }
}

