package Casinos;

import Jeux.Jeu;
import Joueurs.Joueur;

public class CasinoLegal extends Casino implements ImpotsFoncier {
    private double impotsSaisi;

    public CasinoLegal(String nom, int nbMaxJoueurs, Jeu jeu){
        super(nom,nbMaxJoueurs,jeu);

    }
    public CasinoLegal(String nom, int nbMaxJoueurs,int joueursPresents, Jeu jeu){
        super(nom,nbMaxJoueurs,joueursPresents,jeu);

    }
    public CasinoLegal(CasinoLegal autre){
        super(autre);
        this.setJoueurs(autre.getJoueurs());
        this.setCapital(autre.getCapital());


    }


    @Override
    public String toString() {
        String chaine ="---------------------------------------------------------------------------\n" +
                 "Le nom du Casino: "+ this.getNom() +"\n"
                +"Le nombre de joueurs presents est: "+ this.getJoueursPresents()+"\n" +
                 "Le capital du casino est presentment: "+this.getCapital()+"$ \n" +
                "Les impots ramassé des client aujourd'hui "+impotsSaisi +"$";

        if(this.getJoueursPresents() > 0) {
            for (int i = 0; i < this.getJoueurs().length; i++) {
                chaine += "- "+this.getJoueurs()[i];
            }
        }
          chaine+="---------------------------------------------------------------------------";

         return chaine;
    }
    public double collecterImpots(){

        for(int i= 0;i<getJoueursPresents();i++){

            double x = 0.15* Double.valueOf(getJoueurs()[i].getCapital());
            double z = getJoueurs()[i].getCapital() - x;
            impotsSaisi += x;
            getJoueurs()[i].setCapital((int) z);
        }
        System.out.println("Aujourd'hui apres avoir collecter les impots des" +
                "joueurs nous avons ramasse "+impotsSaisi+"$");
        return impotsSaisi;
}
    public boolean debutSpectacle(){
        Spectacle = true;
        return Spectacle;
    }
    public boolean finSpectacle(){
        Spectacle = false;
        return Spectacle;
    }
    public int payerImpots() {
        double impots= 0;
        double gainCasino=100000- getCapital();
        if(gainCasino <= 0){
            System.out.println("Le casino est presentmenet en deficite,alors il n'y a " +
                    "pas de taxe a payer. ");
            impots = 0;
        }else{

           impots = (gainCasino*0.15);
            setCapital(getCapital()- (int)impots);
        }
        return (int) impots;
    }
}
