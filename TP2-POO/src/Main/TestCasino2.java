package Main;

import Casinos.*;
import Jeux.*;
import Joueurs.*;


public class TestCasino2 {
    public static void main(String[] args) {

        /*************************Jeu de Roulette**********************************************/

        Roulette rouletteRusse = new Roulette();
        //System.out.println(rouletteRusse);  //toString();
        //System.out.println(rouletteRusse.calculerGains(50));
        //System.out.println(rouletteRusse.getNom());

        /**************************Pile ou Face***************************************/

        PileOuFace pileOuFace = new PileOuFace() ;
        //System.out.println(pileOuFace);                         //toString()
        //System.out.println(pileOuFace.calculerGains(30)); // calculergains(mise)
        //System.out.println(pileOuFace.getNom());

        /*****************************Jeu de DÈS*******************************************/
        JeuDeDes diceGame = new JeuDeDes();//jeuDeDes()       //sans argument
        JeuDeDes des2 = new JeuDeDes("NOUVEAU NOM");    // JeuDeDes(nom)
        //System.out.println(diceGame.getNom());
        JeuDeDes copieJeu = new JeuDeDes(diceGame);
        //System.out.println(diceGame);                          //toString()
        //System.out.println(diceGame.equals(copieJeu));        // equals(obj)
        //System.out.println(diceGame.equals(pileOuFace));
        //System.out.println(diceGame.getNom());                // getnom()
        //diceGame.setNom("DICE GAME MODIFIEE");                //setnom()
        //System.out.println(diceGame.getNom());
        //System.out.println(diceGame.calculerGains(50));       // calculergains(mise)
        /***************************************************************************************/


        CasinoLegal wensonCasino = new CasinoLegal("Le Casino de Wenson",5,pileOuFace);
        CasinoLegal copieCasino = new CasinoLegal(wensonCasino);
        copieCasino.setJeu(diceGame);

        CasinoIndien sylvainCasino = new CasinoIndien("Casino de Sylvain",3,rouletteRusse);
        //wensonCasino.jouer(150);

       // wensonCasino.payerImpots();
        //System.out.println(wensonCasino.getCapital());
        //System.out.println(wensonCasino);
        //System.out.println(wensonCasino);

        //wensonCasino.evaluationMunicipal(wensonCasino.getJoueursPresents());
        JoueurPauvre karl = new JoueurPauvre("Karl",300);
        karl.joindreCasino(sylvainCasino);
        karl.jouer(500);// montre une erreur je nai pas assez d'argent
        karl.jouer(250);// le jeu roule
        sylvainCasino.evaluationMunicipal(1);
        JoueurPauvre jr = new JoueurPauvre();

       // jr.setCapital(50);
        //jr.setNom("Junior");
        //jr.joindreCasino(wensonCasino);
        //System.out.println(jr);

        //jr.joindreCasino(wensonCasino);








    }
}
