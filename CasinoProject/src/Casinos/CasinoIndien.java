package Casinos;

import Jeux.Jeu;
import Joueurs.Joueur;

import java.util.Arrays;

public class CasinoIndien extends Casino {


    public CasinoIndien(String nom, int nbMaxJoueurs, Jeu jeu) {
        super(nom, nbMaxJoueurs, jeu);

    }

    public CasinoIndien(String nom, int nbMaxJoueurs, int joueursPresents, Jeu jeu) {
        super(nom, nbMaxJoueurs, joueursPresents, jeu);

    }

    @Override
    public String toString() {
        String chaine = "---------------------------------------------------------------------------\n" +
                "Le nom du Casino: " + this.getNom() + "\n"
                + "Le nombre de joueurs presents est: " + this.getJoueursPresents() + "\n" +
                "Le capital du casino est presentment: " + this.getCapital() + "$ \n";

        if (this.getJoueursPresents() > 0) {
            for (int i = 0; i < this.getJoueurs().length; i++) {
                chaine += "- " + this.getJoueurs()[i];
            }
        }
        chaine += "---------------------------------------------------------------------------";

        return chaine;
    }
    public int payerImpots () {
        int impots = 0;
        if (Math.random() > 0.99) {
           int revenuQuebec= getCapital()/2;
           setCapital(getCapital()-revenuQuebec);
           impots = revenuQuebec;
           System.out.println("Vous vous etes fait prendre par RevenuQuebec!");
        }

        return impots;
    }
    public void decenteDePolice() {
        for (int i = 0; i < getJoueursPresents(); i++) {
            this.getJoueurs()[i].quitterCasino();
        }

    }
    /*public void trierEtExpulser(int n){

    }*/






}