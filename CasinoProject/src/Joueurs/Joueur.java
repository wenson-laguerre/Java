package Joueurs;
import Casinos.*;
import java.util.Objects;

public abstract class Joueur implements Comparable {
    protected String nom;
    protected int capital;
    private Casino casino;

    public Joueur() {
        this("Anonyme", 1000);
    }

    public Joueur(String nom, int capital) {
        this.nom = nom;
        this.capital = capital;
        this.casino = null;
    }

    public Joueur(Joueur autre) {
        this(autre.nom, autre.capital);
    }

    public void joindreCasino(Casino casino) {

        if (this.casino == null) {
            if (casino.ajouterJoueur(this)) {
                this.casino = casino;
            } else {
                System.out.println("On m'a refusé l'accès au casino :(");
            }
        } else {
            System.out.println("Je suis déjà dans un casino! Je dois le quitter avant d'en rejoindre un autre.");
        }

    }

    public void quitterCasino() {
        if (this.casino == null) {
            System.out.println("Je ne suis pas dans un casino, je ne peux pas en sortir!");
        } else {
            this.casino.enleverJoueur(this);
            this.casino = null;
        }
    }

    public void jouer(int mise) {
        if (this.casino == null) {
            System.out.println("Je ne peux pas jouer, je ne suis pas dans un casino");
        } else if (this.capital < mise) {
            System.out.println("Je n'ai pas assez d'argent pour une telle mise!");
        } else {
            this.capital += this.casino.jouer(mise);
            if (this.capital <= 0) {
                System.out.println("J'ai perdu tout mon argent, je dois quitter le casino!");
                quitterCasino();
            }
        }

    }

    public String toString() {
        String chaine;

        chaine = this.nom + " avec un capital de " + this.capital;

        if (this.casino == null) {
            chaine += " Je ne suis pas dans un casino";
        } else {
            chaine += "Je suis dans le casino " + this.casino.getNom();
        }

        return chaine;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Joueur other = (Joueur) obj;
        if (this.capital != other.capital) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCapital() {
        return capital;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public Casino getCasino() {
        return casino;
    }

    public void setCasino(Casino casino) {
        this.casino = casino;
    }

}
