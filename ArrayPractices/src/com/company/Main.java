package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] element = new int[25];
         int nbr = 0;

        Scanner clavier = new Scanner(System.in);
        int tmp;
        String input;
        boolean fin = false;

        //Lire les nombres entiers (remplir le tableau
        do {
            System.out.print("Saisir un entier (retour pour terminer): ");
            input = clavier.nextLine();
            if (input.isEmpty())
                fin = true;
            else{
                element[nbr] = Integer.parseInt(input);
                nbr++;
            }
        } while (!fin);
        System.out.println("Tableau (début): " + afficherTableau());

        //Trier
        for (int i = 0; i < (nbr - 1); i++) {
            for (int j = i + 1; j < nbr; j++) {
                if (element[i] > element[j]) {
                    tmp = element[i];
                    element[i] = element[j];
                    element[j] = tmp;
                    System.out.println("Après permutation de element[" + i + "] avec element[" + j + "]: "
                            + afficherTableau());
                }
            }
        }
        System.out.println("Tableau (final): " + afficherTableau());

        public static String afficherTableau(){
            String resultat = "Tableau: ";
            for (int k = 0; k < nbr; k++)
                resultat = resultat + element[k] + " ";
            return resultat;

    }  //méthode main



}// main class
  /* extrait DemoTriBulles
    Tri à bulles
    Le principe:
        on a une 1ère boucle qui va du 1er élément jusqu'à l'avant-dernier
            on a une 2ème boucle IMBRIQUÉE dans la 1ère qui va de l'élément référencée
            dans boucle #1 jusqu'à la fin
                si l'élément référencé par boucle #1 > élément référencé par boucle #2
                    alors on échange les valeurs
    Ce qui donne:

  static int[] element = new int[25];
    static int nbr = 0;

        Scanner clavier = new Scanner(System.in);
        int tmp;
        String input;
        boolean fin = false;

        //Lire les nombres entiers (remplir le tableau
        do {
            System.out.print("Saisir un entier (retour pour terminer): ");
            input = clavier.nextLine();
            if (input.isEmpty())
                fin = true;
            else{
                element[nbr] = Integer.parseInt(input);
                nbr++;
            }
        } while (!fin);
        System.out.println("Tableau (début): " + afficherTableau());

        //Trier
        for (int i = 0; i < (nbr - 1); i++) {
            for (int j = i + 1; j < nbr; j++) {
                if (element[i] > element[j]) {
                    tmp = element[i];
                    element[i] = element[j];
                    element[j] = tmp;
                    System.out.println("Après permutation de element[" + i + "] avec element[" + j + "]: "
                            + afficherTableau());
                }
            }
        }
        System.out.println("Tableau (final): " + afficherTableau());

        public static String afficherTableau(){
        String resultat = "Tableau: ";
        for (int k = 0; k < nbr; k++)
            resultat = resultat + element[k] + " ";
        return resultat;

    }//main module
*/