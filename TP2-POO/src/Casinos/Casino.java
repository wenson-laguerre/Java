package Casinos;

import Jeux.*;
import Joueurs.*;

public abstract class Casino implements Comparable {
    private int joueursPresents;
    private int capital = 100000;
    private int nbMaxJoueurs;

    protected String nom;
    protected boolean Spectacle = false ;
    private Joueur[] joueurs;
    private Jeu jeu;

    public Casino(String nom, int nbMaxJoueurs, Jeu jeu) {
        this.nom = nom;
        this.joueurs =  new Joueur[nbMaxJoueurs];
        this.joueursPresents = 0;
        this.jeu = jeu;
    }
    public Casino(String nom, int nbMaxJoueurs,int joueursPresents, Jeu jeu) {
        this.nom = nom;
        this.joueurs =  new Joueur[nbMaxJoueurs];
        this.joueursPresents = joueursPresents;
        this.jeu = jeu;
    }
    public Casino(Casino autre){
        this(autre.nom, autre.joueurs.length,autre.jeu);

    }

    public boolean ajouterJoueur(Joueur joueur){
         if(joueur instanceof JoueurPauvre&& joueur.getCapital()>= 10||joueur instanceof JoueurRiche &&joueur.getCapital()>=1000) {
            if (joueursPresents == this.joueurs.length) {
                System.out.println("Il n'y a plus de place dans le casino");
                return false;
            } else if (joueur.getCapital() <= 0) {
                System.out.println("Le joueur n'a pas assez d'argent pour entrer au casino");
                return false;
            }
        }

        joueurs[joueursPresents] = joueur;
        joueursPresents++;

        return true;
    }

    public void enleverJoueur(Joueur joueur){
        for(int i = 0; i < this.joueursPresents; i++){
            if(joueur.equals(joueurs[i])){
                joueurs[i] = joueurs[joueursPresents -1];
                joueurs[joueursPresents -1] = null;
                break;
            }
        }
        joueursPresents--;
    }
    public int jouer(int mise){
        int gain =jeu.calculerGains(mise);
        if(Spectacle = true) {
            capital = capital + mise;
             gain = -mise;
            gain += this.jeu.calculerGains(mise);

            if (gain >= 0) {
                capital = (capital - mise) - gain;
            }
        }else {
            System.out.println("Vous devez Attendre la fin du spectacle!");
                gain = 0;
        }
            return gain;
    }

    public int evaluationMunicipal(int joueursPresents){

        int valeurCasino= joueursPresents*1000;

        return valeurCasino;
    }

    @Override
    public String toString() {
        String chaine;

        chaine = "Bienvenue au casino " + this.nom;
        chaine += " Il y a un seul jeu disponbile au casino, dont les règles sont\n " + this.jeu ;
        chaine += "\nSur un maximum de " + this.joueurs.length + ", il y a " + this.joueursPresents  + " joueurs présents dans le casino.";
        for(int i = 0; i < joueursPresents; i++ ){
            chaine +="\n" + joueurs[i].getNom();
        }

        return chaine;
    }

    @Override
    public boolean equals(Object obj) {
        //Est-ce que c'est le même objet?
        if (this == obj) {
            return true;
        }
        //Est-ce qu'on compare le casino courant à un pointeur null
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Casino other = (Casino) obj;

        if (!this.nom.equals(other.nom)) {
            return false;
        }
        if(this.joueurs.length != other.joueurs.length){
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

    public Joueur[] getJoueurs() {
        return joueurs;
    }
    public void setJoueurs(Joueur [] joueurs){
        this.joueurs = joueurs;
    }

    public int getJoueursPresents() {
        return joueursPresents;
    }
    public void setJoueursPresents(int joueursPresents){
        this.joueursPresents = joueursPresents;
    }
    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }



    public int getCapital(){return capital;}
    public void setCapital(int capital){
        this.capital = capital;
    }

    public int compareTo(Object o){
        Casino autre = (Casino) o;
        int capitalJoueurs = 0;
        int capitalAutreJoueurs= 0;
        for(int i = 0; i < this.joueurs.length;i++){

            capitalJoueurs += this.joueurs[i].getCapital();

        }
        for(int i = 0; i < this.joueurs.length;i++){

            capitalAutreJoueurs += autre.joueurs[i].getCapital();

        }
        if(capitalJoueurs < capitalAutreJoueurs){
            return -1;
        }else if(capitalJoueurs > capitalAutreJoueurs){
            return 1;
        }else{
            return 0;
        }
    }


}
