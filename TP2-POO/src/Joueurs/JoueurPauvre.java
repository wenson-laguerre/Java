package Joueurs;
import java.util.*;
public class JoueurPauvre extends Joueur {
    public JoueurPauvre(){
        super();

    }
    public JoueurPauvre(String nom, int capital){
        super(nom,capital);

    }
     public JoueurPauvre(JoueurPauvre autre){

         this(autre.nom, autre.capital);
     }
    public boolean isFirstDayOfTheMonth(Date dateToday){
        Calendar c = new GregorianCalendar();
        c.setTime(dateToday );

        if (c.get(Calendar.DAY_OF_MONTH) == 1) {
            return true;
        }
        return false;
    }

    public void collecterCheque(){
        if(isFirstDayOfTheMonth(Calendar.getInstance().getTime()) == true){
            setCapital(getCapital()+700);
        }

    }
    @Override
    public String toString() {

        return super.toString()+"\n je suis aussi un pauvre joueur.";
    }

    @Override
    public int compareTo(Object o) {
        Joueur autrejoueur = (Joueur) o;
        if(this.getCapital()>autrejoueur.getCapital()){
            return 1;
        } else if (this.getCapital()< autrejoueur.getCapital()){
            return -1;
        }else if (this.getCapital() == autrejoueur.getCapital()){
            int compare = this.getNom().compareTo(autrejoueur.getNom());
            if (compare < 0) {
                return -1;
            }
            else if (compare > 0) {
                return 1;
            }
        }

        return 0;
    }
}
