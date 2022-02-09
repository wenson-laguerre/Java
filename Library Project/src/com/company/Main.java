package com.company;

import java.util.*;
import java.io.File;
import iofichiertab.*;

public class Main {
    //*****************************************************
    //STRUCTURES DE DONNES DEFINIES AU NIVEAU DE LA CLASSE
    //*****************************************************
    static Scanner clavier = new Scanner(System.in);

    static final int DIM = 50;
    static String[] tabNom = new String[DIM]; //Nom de l'auteur
    static int[] tabNum = new int[DIM]; //Numéro du livre
    static String[] tabTitre = new String[DIM];
    static String[] tabEdition = new String[DIM]; //Maison d'édition
    static double[] tabPrix = new double[DIM]; //rix du livre
    static int[] tabQte = new int[DIM]; //Quantité en librairie
    static int[] tabCat = new int[DIM]; //catégorie du livre:
    /*      1: fiction
                2: recit
                3: politique
                4: cuisine
                5: voyage
                6: autre
     */
    static String categories[] = {"Fiction  ", "Récit    ", "Politique", "Cuisine  ",
            "Voyage   ", "Autre    "};

    static int nbrItems = 0;
    static int idx;
    //*****************************************************
    /* *********************MAIN****************/
    //*****************************************************
    public static void main(String[] args) {
        boolean fin = false;
        String input;
        int option;

        String fichier = "finalData.txt";
        String SEPARATEUR = ";"; //Separateur des champs de le fichier

        //Début du traitement
        if (new File(fichier).exists())
            nbrItems = IOFichierTab.lireFichier(fichier, SEPARATEUR, tabNom, tabNum,
                    tabTitre, tabEdition, tabPrix, tabQte, tabCat);

        //Boucle principale de l'application
        while (fin == false) {
            presenterMenu();
            //Lire l'option choisie par l'utilisateur
            System.out.print("Entrez votre choix: ");
            input = clavier.nextLine();
            option = Integer.parseInt(input);

            switch (option) {
                case 0:
                    fin = true;
                    break;
                case 1:
                    ajouterLivre();
                    break;
                case 2:
                    listerLivres();
                    break;
                case 3:
                    modifierQteLivre();
                    break;
                case 4:
                    retirerUnLivre();
                    break;
                case 5:
                    listerCategorie();
                    break;
                case 6:
                    trierLesLivres();
                    break;
                case 7:
                    rapportInventaire();
                    break;
                default:
                    System.out.println("Attention! Vous avez entré une option invalide!");
                    break;
            }
        }

        IOFichierTab.ecrireFichier(fichier, SEPARATEUR, nbrItems, tabNom, tabNum,
                tabTitre, tabEdition, tabPrix, tabQte, tabCat);
    }//module main

    //*****************************************************
    // Procédure permettant d'afficher le menu principal
    //*****************************************************
    public static void presenterMenu() {
        System.out.println("\n=====================================================");
        System.out.println("               Gestion des stocks");
        System.out.println("                 des librairies");
        System.out.println("             R E N A U D   D E P O T");
        System.out.println("=====================================================");
        System.out.println("                     MENU");
        System.out.println("\t\t1: AJOUTER UN LIVRE");
        System.out.println("\t\t2: LISTER LES LIVRES");
        System.out.println("\t\t3: MODIFIER QUANTITE");
        System.out.println("\t\t4: RETIRER UN LIVRE");
        System.out.println("\t\t5: LISTER UNE CATEGORIE");
        System.out.println("\t\t6: TRIER LES LIVRES");
        System.out.println("\t\t7: RAPPORT D’INVENTAIRE");
        System.out.println("\t\t0: SORTIR DE L'APPLICATION");
    }
    //*****************************************************
    // Procédure permettant d'afficher le menu des categories
    //*****************************************************
    public static void presenterCategorieMenu(){
        System.out.println("                     MENU DES CATEGORIES");
        System.out.println("\t\t1: Fiction");
        System.out.println("\t\t2: Recit");
        System.out.println("\t\t3: Politique");
        System.out.println("\t\t4: Cuisine");
        System.out.println("\t\t5: Voyage");
        System.out.println("\t\t6: Autre");
        System.out.println("(Veuillez choisir un chiffre entre 1-6)");

    }
    //*****************************************************
    //Procédure permettant d'ajouter un livre
    //*****************************************************
    public static void ajouterLivre() {

        System.out.print("Prénom de l'auteur: ");
        tabNom[nbrItems] = clavier.nextLine();
        System.out.print("Nom de l'auteur: ");
        tabNom[nbrItems] = clavier.nextLine() + ", " + tabNom[nbrItems];
        System.out.print("Titre: ");
        tabTitre[nbrItems] = clavier.nextLine();
        System.out.print("Numéro du livre: ");
        tabNum[nbrItems] = Integer.decode(clavier.nextLine());
        System.out.print("Maison d'édition: ");
        tabEdition[nbrItems] = clavier.nextLine();
        System.out.print("Prix: ");
        tabPrix[nbrItems] = Double.parseDouble(clavier.nextLine());
        System.out.print("Quantité en librairie: ");
        tabQte[nbrItems] = Integer.decode(clavier.nextLine());
        System.out.print("Catégorie: (1: fiction; 2: récit; 3: Politique; 4: Cuisine; 5: Voyage`6: Autre): ");
        tabCat[nbrItems] = Integer.decode(clavier.nextLine());

        nbrItems++;
    }

    //*****************************************************
    //Procédure permettant d'afficher la liste des livres
    //*****************************************************
    public static void listerLivres() {

        afficherEntete();
        for (int i = 0; i < nbrItems; i++) {
            afficherLivre(i);
        }
    }

    //*****************************************************
    //Procédure permettant de modifier  la quantite des livres
    //*****************************************************
    public static void modifierQteLivre(){
        boolean valide = false;
        do {
            System.out.println("Quel est le numero du livre que vous voulez modifier la quantité");
            if (chercher(tabNum) == true) {
                System.out.println(" Veuillez entrer la nouvelle quantité de cet ce livre:");

                tabQte[idx] = Integer.decode(clavier.nextLine());
                valide = true;
            } else {
                System.out.println("Veuillez entrer un numéro de livre valide pour procéder");
            valide = false;
            }
        }while(!valide);

    }
    //*****************************************************
    //Procédure permettant de retirer un livre de l'inventaire
    //*****************************************************
    public static void retirerUnLivre(){
        boolean valide = false;
        do{
            System.out.println("Quel est le numero du livre que vous voulez retirer de l'inventaire");
            if (chercher(tabNum) == true) {
                int [] proxyArray = new int[tabNum.length-1];
                int suppPosition = 0;
                for (int i = idx; i < nbrItems - 1; i++) {
                   tabNum[i]= tabNum[i+1];
                }
                    valide =true;
            }else{
                System.out.println("Veuillez entrer un numéro de livre valide pour procéder ");
                valide = false;

            }
        }while (!valide);
        nbrItems--;

    }
    //*****************************************************
    //Procédure permettant de lister les livre par categories
    //*****************************************************
    public static void listerCategorie(){
        boolean valide= false;
        do{
            presenterCategorieMenu();
            String cateChoix = clavier.nextLine();
            int optionCat = Integer.parseInt(cateChoix);
            switch(optionCat)
            {
                case 1:// fiction
//
                    afficherEntete();
                    for (int i = 0; i < nbrItems; i++) {
                        String F = "1";
                        if(tabCat[i] ==Integer.parseInt(F) ){
                        afficherLivre(i);
                        }
                    }
                    valide= true;
                    break;
                case 2:// recit
                    afficherEntete();
                    for (int i = 0; i < nbrItems; i++) {
                        String R = "2";
                        if(tabCat[i] ==Integer.parseInt(R) ){
                            afficherLivre(i);
                        }
                    }
                    valide= true;
                    break;
                case 3://  politique
                    afficherEntete();
                    for (int i = 0; i < nbrItems; i++) {
                        String P = "3";
                        if(tabCat[i] ==Integer.parseInt(P) ){
                            afficherLivre(i);
                        }
                    }
                    valide= true;
                    break;
                case 4:// cuisine
                    afficherEntete();
                    for (int i = 0; i < nbrItems; i++) {
                        String C = "4";
                        if(tabCat[i] ==Integer.parseInt(C) ){
                            afficherLivre(i);
                        }
                    }
                    valide= true;
                    break;
                case 5://voyage
                    afficherEntete();
                    for (int i = 0; i < nbrItems; i++) {
                        String V = "5";
                        if(tabCat[i] ==Integer.parseInt(V) ){
                            afficherLivre(i);
                        }
                    }
                    valide= true;
                    break;
                case 6://autres
                    afficherEntete();
                    for (int i = 0; i < nbrItems; i++) {
                        String A = "6";
                        if(tabCat[i] ==Integer.parseInt(A) ){
                            afficherLivre(i);
                        }
                    }
                    valide= true;
                    break;
                default:
                    System.out.println("Veuillez entrer un choix de Categorie valide en entrant leur chiffre respectif");
                    break;
            }

        }while(!valide);
    }
    //*****************************************************
    //Procédure permettant de trier les livres par ordre croissant
    //*****************************************************
    public static void trierLesLivres(){
        int temp;
        for (int i = 0; i < (nbrItems - 1); i++) {
            for (int j = i + 1; j < nbrItems; j++) {
                if (tabNum[i]>tabNum[j]){
                    temp = tabNum[i];
                    tabNum[i] = tabNum[j];
                    tabNum[j]=temp;
                }
            }
        }
        afficherEntete();
        for (int i = 0; i < nbrItems; i++) {
                afficherLivre(i);
        }
    }
    //*****************************************************
    //Procédure permettant de trier les livres par ordre croissant
    //*****************************************************
    public static void rapportInventaire(){
        System.out.println("===================Statistiques===================");
        for(int i=0;i <categories.length;i++){

        }
}
    //*****************************************************
    //Procédure permettant d'affichier l'entête de la liste
    //*****************************************************
    public static void afficherEntete(){
        String ch;
        ch = fixeS("", 110, "-");
        System.out.println(ch);
        ch = fixeS("Numéro", 8, null) + "| "
                + fixeS("*****Auteur*****", 25, null) + "| "
                + fixeS("*********** Titre **********", 30, null) + "| "
                + fixeS("***Edition***", 15, null) + "| "
                + fixeS("Catégorie", 9, null) + "| "
                + fixeS("Prix", 5, null) + " | "
                + fixeS("Qté", 4, null) + "| ";
        System.out.println(ch);
        ch = fixeS("", 110, "-");
        System.out.println(ch);
    }

    //*****************************************************
    //Procédure qui permet de formater et d'afficher un item
    //*****************************************************
    public static void afficherLivre(int indice){
        String ch;
        ch = fixeS(Integer.toString(tabNum[indice]), 8, null) + "| "
                + fixeS(tabNom[indice], 25, null) + "| "
                + fixeS(tabTitre[indice], 30, null) + "| "
                + fixeS(tabEdition[indice], 15, null) + "| "
                + fixeS(categories[tabCat[indice] - 1], 9, null) + "| "
                + fixeS(Double.toString(tabPrix[indice]), 5, null) + "$| "
                + fixeS(Integer.toString(tabQte[indice]), 4, null) + "| ";
        System.out.println(ch);

    }

    //*****************************************************
    //Fonction qui retourne une chaine de longueur fixe;
    //La chaine initiale est tronquée si trop longue, ou
    //complétée avec le padding si trop courte
    //*****************************************************
    public static String fixeS(String s, int longueur, String pad) {
        String chaineFixe = "";
        String espace = " ";
        boolean fin = false;
        int i = 0;

        if (pad == null) {
            pad = espace;
        }

        while (i < longueur) {
            if (i == s.length()) {
                fin = true;
            }
            if (!fin) {
                chaineFixe = chaineFixe + s.charAt(i);
            } else {
                chaineFixe = chaineFixe + pad;
            }
            i++;
        }
        return chaineFixe;
    }

    //******************************************************
    // Fonction qui sert a chercher dans un tableau pour une valeur
    //*********************************************************
    public static boolean chercher(int [] tablo){
        String terme;
        boolean trouve;


        //System.out.print("Saisir terme: ");
        terme = clavier.nextLine();
        trouve = false;
        idx = 0;
        while((trouve == false) && (idx < nbrItems)){
            String equiv =Integer.toString(tablo[idx]) ;
            if (terme.equalsIgnoreCase(equiv)){
                trouve = true;
            } else{
                trouve = false;
                idx++;
            }
        }

       return trouve;
    }


}// class main
