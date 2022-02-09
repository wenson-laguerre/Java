package com.company;

public class ArrayMethods {

    public static  void trier(int nbr,int element[],int tmp ){
        for (int i = 0; i < (nbr - 1); i++) {
            for (int j = i + 1; j < nbr; j++) {
                if (element[i] > element[j]) {
                    tmp = element[i];
                    element[i] = element[j];
                    element[j] = tmp;
                  /* Si tu veux voir le processus de replacer les chiffres dans un tableau
                  System.out.println("Après permutation de element[" + i + "] avec element[" + j + "]: "
                            + afficherTableau(nbr,element));*/
                }
            }
        }
    }
    public static String afficherTableau (int nbr,int element[]) {
        String resultat = "Tableau: ";
        for (int k = 0; k < nbr; k++)
            resultat = resultat + element[k] + " ";
        return resultat;

    }
}
