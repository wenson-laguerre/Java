package Joueurs;

import Casinos.CasinoIndien;
import Casinos.CasinoLegal;

public class JoueurRiche extends Joueur {
    JoueurRiche() {
        super();
    }
    JoueurRiche(String nom, int capital){
        super(nom,capital);

    }


public void banqueRoute(){
        if(getCasino()instanceof CasinoLegal ||getCasino()instanceof CasinoIndien) {
            quitterCasino();
            setCapital(0);
        }else
            System.out.println("Vous n'etes presentement pas dans un Casino");
}
    @Override
    public int compareTo(Object o) {
        Joueur autrejoueur = (Joueur) o;
        if (this.getCapital() > autrejoueur.getCapital()) {
            return 1;
        } else if (this.getCapital() < autrejoueur.getCapital()) {
            return -1;
        } else if (this.getCapital() == autrejoueur.getCapital()) {
            int compare = this.getNom().compareTo(autrejoueur.getNom());
            if (compare < 0) {
                return -1;
            } else if (compare > 0) {
                return 1;
            }
        }

        return 0;
    }
}