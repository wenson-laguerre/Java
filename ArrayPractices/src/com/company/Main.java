package com.company;
import java.util.*;
import static com.company.ArrayMethods.*;
/*
    Tri
    Le principe:
        on a une 1ère boucle qui va du 1er élément jusqu'à l'avant-dernier
        on a une 2ᵉ boucle IMBRIQUÉE dans la 1ère qui va de l'élément référencé
        dans boucle #1 jusqu'à la fin si l'élément référencé par boucle #1 > élément
         référencé par boucle #2 alors on échange les valeurs */
public class Main {
   static int nbr = 0;
   static int[] element = new int[25];
    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);
        int tmp=0;
        String input;
        boolean fin = false;

        //Lire les nombres entiers (remplir le tableau)
        do {
            System.out.print("Saisir un entier (retour pour terminer): ");
            input = clavier.nextLine();
            if (input.isEmpty())
                fin = true;
            else {
                element[nbr] = Integer.parseInt(input);
                nbr++;
            }
        } while (!fin);
        System.out.println("Tableau (début): " + afficherTableau(nbr,element));

        //Trier
        ArrayMethods.trier(nbr,element,tmp);

        System.out.println("Tableau (final): " + afficherTableau(nbr,element));

    }



}

