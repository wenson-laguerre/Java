package com.company;

import iofichiertab.*;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
   static String fichier = "dataTableaux.txt"; //nom du fichier de données
   static final String SEPARATEUR = ";"; //Separateur des champs de le fichier

    //*****************************************************
    //STRUCTURES DE DONNES DÉFINIES AU NIVEAU DE LA CLASSE
    //*****************************************************
    static Scanner input = new Scanner(System.in);
    static int ctr = 0; // Compteur
    static int fabCtr = 0;//compteur des nouveaux fabricants
    static int idx;// l'index
    static int nbrItems = 25;

    static int[] itemNo = new int[nbrItems];//les numéros d'item
    static String[] itemDescription = new String[nbrItems];//  les descriptions des items
    static int[] sexe = new int[nbrItems];// Sexe associe a l'item
    static int[] idfabricant = new int[25];
    static String[] toutLesNomsDesFabriacants = new String[nbrItems];//nom du fabriquant de l'item
    static String[] noDuFabriquant = new String[nbrItems];// le numéro des fabricants
    static double[] prixDeRevient = new double[nbrItems];//Tableau pour stocker les prix de revient de chaque article
    static double[] prixDeVente = new double[nbrItems]; // Tableau pour stocker  les prix de vente de chaque article
    static int[] minQte = new int[nbrItems]; // Tableau pour le seuil minimal à maintenir d'article
    static int[] quantite = new int[nbrItems];// Tableau pour tout les quantités pour chaque article
    static int[] itemStatut = new int[nbrItems];// Tableau pour le statut de l'article

    static String[]nomDuFournisseur = new String[nbrItems];
    static String[] sexOption = new String[]{"Homme", "Femme", "Unisexe"};

    static String msgErreurItem = "Ce numéro d'item est deja dans notre inventaire, veuillez choisir un autre";
    static String msgErreurIdFab = "Ce numéro d'identification de fournisseur exist deja est deja dans notre inventaire, veuillez choisir un autre";

    public static void main(String[] args) {
        // write your code here
        boolean fin = false;
        String choix;
        afficherEntete();
        do {
            if (new File(fichier).exists()){
                nbrItems = IOFichierTab.lireFichier(fichier, SEPARATEUR, itemNo, itemDescription,sexOption,noDuFabriquant,toutLesNomsDesFabriacants,noDuFabriquant,quantite,minQte,prixDeRevient,prixDeVente,itemStatut);
            }

            afficherMenuPrincipal();

            choix = input.nextLine();


            switch (choix) {
                case "1":// Ajouter un article
                    ajouterUnArticle();

                    break;
                case "2":// Modifier un article
                    modifierUnItem();
                    break;
                case "3":// Supprimer un article
                    supprimerUnItem();
                    break;
                case "4":// Les listes d'inventaire
                        listerInventaire();
                    break;
                case "5":// Les finances du magasin
                    statistics();
                    break;
                case "6":// Quitter le program
                    fin = true;
                    break;
                default:
                    System.out.println("Choix invalid, Veuillez réessayer de nouveau avec un chiffre entre 1-6");
                    fin = false;
                    break;
            }
            IOFichierTab.ecrireFichier(fichier, SEPARATEUR,itemNo, itemDescription,sexOption,noDuFabriquant,toutLesNomsDesFabriacants,noDuFabriquant,quantite,minQte,prixDeRevient,prixDeVente,itemStatut);
        } while (!fin);

    }
    //*****************************************************
    // Procédure permettant d'afficher le menu principal
    //*****************************************************
    public static void afficherMenuPrincipal() {

        String menuPQ = "*******************************************************\n"
                + "               Program d'inventaire \n"
                + "*******************************************************\n"
                + "Voici vos choix d'action: \n"
                + "1. Ajouter un vêtement \n"
                + "2. Modifier les attributs suivants d’un vêtement : quantité en inventaire, prix de revient, prix de vente, statut.\n"
                + "3. Supprimer un vêtement \n"
                + "4. Obtenir les different listes d’inventaire. \n"
                + "5. Les finances de l'inventaire \n"
                + "6. Pour quitter le program \n"
                + "Veuillez entrer votre choix ici:";

        System.out.println(menuPQ);
    }

    //*****************************************************
    //Procédure permettant d'ajouter un item a l'inventaire
    //*****************************************************
    public static void ajouterUnArticle() {

        System.out.println("Vous avez choisi d'ajouter un nouvel article: \n");

        // Numéro d'article
        System.out.println("C'est quoi le numéro d'identification du nouveau item:");
        itemNo[ctr] = verificationDeEntier(itemNo, msgErreurItem);

        // Description de l'article
        System.out.println("Veuillez laisser une description de l'article ajouté :");
        itemDescription[ctr] = verificationDeString();

        // Le sexe que l'article a été fait
        System.out.println("Cet article appartient à quel sexe?(choisissez un chiffre entre 0-2)\n"
                + "0. Homme\n"
                + "1. Femme\n"
                + "2. Unisexe");
        sexe[ctr] = Integer.decode(sexeChoice());

        // traitement des donnees du fournisseur
        traitementDeFournisseur();

        //Prix de revient
        System.out.println("Quel est le cout de fabrication de cet article?");
        prixDeRevient[ctr] = input.nextDouble();
        //Prix de vente
        System.out.println("Quel est le prix de vente de cet article ?");
        prixDeVente[ctr] = input.nextDouble();

        // Pour inserer la quantité des article
        System.out.println("Quantite de l'article");
        quantite[ctr] = input.nextInt();

        // Quantité minimale à maintenir en stock
        System.out.println("Quel est la quantité minimale à maintenir en stock");
        minQte[ctr] = input.nextInt();

        //Voir les informations Entrees
        confirmationDesDonnees();
        ctr++;

    }

    //*****************************************************
    //Procédure permettant de modify les donnees d'un item
    // dans l'inventaire
    //*****************************************************
    public static void modifierUnItem(){
        boolean modValide = false;

        boolean choixValide ;
        int modChoix; // Choix de l'usager une fois qu'il a choisi de modifier un attribue d'un article
        String modMenu = "Choissisez entre les chiffres 1-4: \n"
                + "1. Quantite en inventaire\n"
                + "2. Prix de revient\n"
                + "3. Prix de vente\n"
                + "4. Statut";

        while (!modValide) {
            System.out.println("------------------------------------------");
            System.out.println("Vous voulez modifier quel article ? (Par le numero d'item))");
            int modValue = input.nextInt();
            for (int i : itemNo) {
                if (i == modValue) {
                    modValide = true;
                    break;
                }
            }
            if (modValide) {
                choixValide = true;
                while (choixValide) {

                    System.out.println("Quel information de l'article " + modValue + " que vous voulez modifier:");
                    System.out.println(modMenu);
                    modChoix = input.nextInt();

                    // Verifier qu'il choisi en 1 a 4
                    if (modChoix < 1 || modChoix > 4) {
                        System.out.println("Choix invalid, Veuillez reessayer de nouveau");
                        choixValide = true;
                    }

                    switch (modChoix) {
                        case 1:
                            //Qte en inventaire
                            System.out.println("il y a presentement " + quantite[localiser(itemNo, modValue)] + " dans l'article " + modValue);
                            System.out.println(" Veuillez entrer la nouvelle quantite de cet article:");
                            quantite[localiser(itemNo, modValue)] = input.nextInt();

                            System.out.println("La quantite de l'article " + modValue + " est maintenant: " + quantite[localiser(itemNo, modValue)]);
                            choixValide = false;// Ca te sort de la boucle pour retourner au Menu principale
                            break;//Ca te sort du Switch et evite que tu passe a chaque case
                        case 2:
                            //Prix de Revient
                            System.out.println("Le prix de revient est presentement " + prixDeRevient[localiser(itemNo, modValue)] + " dans l'article " + modValue);
                            System.out.println(" Veuillez entrer le nouveau prix de revient de cet article:");
                            prixDeRevient[localiser(itemNo, modValue)] = input.nextDouble();

                            System.out.println("Le prix de revient de l'article " + modValue + " est maintenant: " + prixDeRevient[localiser(itemNo, modValue)]);
                            choixValide = false;// Ca te sort de la boucle pour retourner au Menu principale
                            break;
                        case 3:
                            //Prix de Vente
                            System.out.println("Le prix de vente est presentement " + prixDeVente[localiser(itemNo, modValue)] + "$ dans l'article " + modValue);
                            System.out.println(" Veuillez entrer le nouveau prix de Vente de cet article:");
                            prixDeVente[localiser(itemNo, modValue)] = input.nextDouble();

                            System.out.println("Le prix de vente de l'article " + modValue + " est maintenant: " + prixDeVente[localiser(itemNo, modValue)] + "$");
                            choixValide = false;// Ca te sort de la boucle pour retourner au Menu principale
                            break;
                        case 4:
                            // Statut de l'article
                            if (itemStatut[localiser(itemNo, modValue)] == 1 || itemStatut[localiser(itemNo, modValue)] == 2) {
                                if (itemStatut[localiser(itemNo, modValue)] == 1) {
                                    System.out.println("Le statut de ton article est presentement: Actif");
                                    itemStatut[localiser(itemNo, modValue)] = 2;

                                    System.out.println(" Le statut de ton article est maintenant inactif");
                                } else {
                                    System.out.println("Le statut de ton article est maintenant: Actif");
                                    itemStatut[localiser(itemNo, modValue)] = 1;
                                }

                            }

                            choixValide = false;// Ca te sort de la boucle pour retourner au Menu principale
                            break;
                    }
                }

            } else {
                System.out.println("Choix invalid, Veuillez reessayer de nouveau");
                modValide = false;
            }

        }


    }

    //*****************************************************
    //Procédure permettant de supprimer un item
    // dans l'inventaire
    //*****************************************************
    public static void supprimerUnItem(){

        int suppChoix; // Choix de l'usager une fois qu'il a chosii de supprimer un article
        boolean supprimeValide;
        boolean choixValide= false ;
        if (ctr <= 0) {
            System.out.println("Il n'a pas d'article dans l'item veuillez, ajouter ou rendre actif un item avant de pouvoir le supprimer ou rendre inactif un article!!");



        } else {

            System.out.println("List des articles");
            System.out.println("Numero d'item \t Description \t\t Sexe \t\t Prix de revient \t Prix de vente\t Qte \t Qte Minimum \t Fabricant \t Statut");


        }

        // Section fait pour verfifer le numero d'item
        supprimeValide = false;
        while (!supprimeValide) {

            System.out.println("------------------------------------------");
            System.out.println("Vous voulez Supprimer quel article ? (Par le numero d'item))");
            int suppValue = input.nextInt();
            for (int i : itemNo) {
                if (i == suppValue) {
                    supprimeValide = true;
                    break;
                }
            }
            while(!choixValide) {
                if (supprimeValide) {
                    // pour reset la valeur  de choix valide et reutiliser la variable
                    while (true) {

                        System.out.println("Vous voulez enlever l'article " + suppValue + " de l'inventaire ou simplement le rendre inactif (Choissisez 1 ou 2)");
                        System.out.println("1.Rendre l'article inactif\n"
                                + "2.Enlever l'article de l'inventaire");
                        suppChoix = input.nextInt();

                        // Verifier qu'il choisi en 1 ou 2
                        if (suppChoix < 1 || suppChoix > 2) {
                            System.out.println("Choix invalid, Veuillez reessayer de nouveau");
                        }
                        // Si l'usager choisi 1. rendre l'article inactif
                        if (suppChoix != 2) {
                            System.out.println("Vous avez choisi de rendre l'article inactif au lieu de le supprimer.\n");
                            if (itemStatut[localiser(itemNo, suppValue)] == 1 || itemStatut[localiser(itemNo, suppValue)] == 2) {
                                if (itemStatut[localiser(itemNo, suppValue)] == 1) {
                                    System.out.println("Le statut de ton article est presentement: Actif");
                                    itemStatut[localiser(itemNo, suppValue)] = 2;

                                    System.out.println(" Le statut de ton article est maintenant inactif");
                                }
                                choixValide = true;
                                break;
                            }
                            //Supprimer un article
                            if (suppChoix != 1) {
                                System.out.println("Vous avez choisi de supprimer l'article " + suppValue);

                                int skipPosition = 0;
                                for (int i = 0; i < itemNo.length; i++) {
                                    if (itemNo[i] != suppValue) {
                                        itemNo[skipPosition++] = itemNo[i];
                                    }

                                }
                                ctr--;
                                System.out.println("List des articles");
                                System.out.println("Numero d'item \t Description \t\t Sexe \t\t Prix de revient \t Prix de vente\t Qte \t Qte Minimum \t Fabricant \t Statut");


                            }
                        }

                    }
                } else {
                    System.out.println("Choix invalid, Veuillez reessayer de nouveau");
                    supprimeValide = false;
                }
            }
        }
    }


    public static void statistics(){
        double articleVente;
        double articleRevient;
        double prixDeVenteTotal = 0;
        double prixDeRevientTotal = 0;
        //Calcul pour aller chercher la somme de valeur pour tout les articles en magazin
        for (int i = 0; i < ctr; i++) {
            articleRevient = (quantite[i] * prixDeRevient[i]);
            articleVente = (quantite[i] * prixDeVente[i]);

            prixDeRevientTotal = prixDeRevientTotal + articleRevient;
            prixDeVenteTotal = prixDeVenteTotal + articleVente;
        }
        double   profit = (prixDeVenteTotal - prixDeRevientTotal);

        System.out.println("Le prix de revient de tout tes articles en stock est de " + prixDeRevientTotal + "$");
        System.out.println("Le prix de vente de tout tes articles en stock est de " + prixDeVenteTotal + "$");
        System.out.println("Le profit potentiel de ton inventaire au complet est de " + profit + "$");
    }






    public static double formaterPrix(){
        String valeurSaisi="";
        double prixFormate= 0;
    do {

        //valeurSaisi = emptyCond();
        valeurSaisi = input.nextLine();
        double valeurTraitee;
        valeurTraitee = Double.parseDouble(valeurSaisi);
        prixFormate = monFormater(valeurTraitee);
        if(prixFormate>1000||prixFormate<0) {
            System.out.println("Veuillez donner un prix plus bas que 1000$");}
    }while(prixFormate<1000);
    return prixFormate;
}

    public static double monFormater(double d) {
        String prixS;
        int idx;

        prixS = Double.toString(d);  //Transformons le nombre réel en string
        prixS = prixS + "00";  //il me faut au moins 2 chiffres après le point pour plus tard
        idx = prixS.indexOf('.'); //trouvons l'emplacement du point
        if (idx > 0) {
            prixS = prixS.substring(0, idx) + "." + prixS.substring(idx + 1, idx + 3);
        }
       double prixSorti =Double.parseDouble(prixS);
        return prixSorti;
    }



    //****************************************************
    public static void traitementDeFournisseur() {
        String entree;


        boolean fin = false;

        System.out.println("Est ce que c'est que cette article a ete fabrique par nous?\n" +
                "1.Oui\n" +
                "2.Non,par un autre fournisseur\n" +
                "(Veuillez choisir entre 1 et 2)");
        while (!fin) {
            entree = input.nextLine();

                switch (entree){
                    case "1":

                        idfabricant[ctr] = 1;
                        toutLesNomsDesFabriacants[ctr] = "Nous";
                        noDuFabriquant[ctr] = "-";
                        fin = true;
                        break;
                    case "2":
                        System.out.println("Est ce que c'est un nouveau fournisseur ou un deja dans l'inventaire?\n" +
                                "1.Nouveau Fournisseur\n" +
                                "2.Fournisseur existant\n" +
                                "(Veuillez choisir 1 ou 2)");
                        choixDeFournisseur();
                        fin =true;
                        break;
                    default:
                        System.out.println("Réessayez de nouveau avec un chiffre entre 1 et 2");
                        fin = false;
                }



        }
    }

    //**************************************************
    public static void confirmationDesDonnees() {
        System.out.println("\nItem #" + ctr + " enregistré.");
        System.out.println("------------------------------------------");
        System.out.println("Votre numéro d'item est: " + itemNo[ctr]);
        System.out.println("Votre Description d'item est: " + itemDescription[ctr]);
        System.out.println("Le sexe : " + sexOption[(sexe[ctr])]);
        System.out.println("Le numéro d'identification du fournisseur est: " + idfabricant[ctr]);
        System.out.println("Le nom du fournisseur: " + toutLesNomsDesFabriacants[ctr]);
        System.out.println("Le numéro de Contact du fournisseur est:  " + noDuFabriquant[idfabricant[ctr]]);

    }

    public static int verificationDeEntier(int[] tab, String msgErreur) {

        boolean valeurInvalid = false;
        int valeurTraitee = 0;

        while (!valeurInvalid) {
            String entree = input.nextLine();
            boolean numberCheck = tousDesChiffres(entree);


            if (numberCheck) {
                if (!chercher(tab, entree)) {
                    valeurTraitee = Integer.decode(entree);

                    valeurInvalid = true;
                } else {
                    System.out.println(msgErreur);

                    valeurInvalid = false;
                }
            } else {
                System.out.println("Veuillez entrer un chiffre valid pour continuer");

                valeurInvalid = false;
            }

        }

        return valeurTraitee;
    }

    //*********************************************************************
    //Fonction qui sert a verifier si le string debut avec une lettre
    //********************************************************************
    public static String verificationDeString() {

        String valeurTraitee = null;
        boolean fin;

        do {
            String valeurRecu = input.next();
            char ch1 = valeurRecu.charAt(0);
            if (Character.isAlphabetic(ch1)) {
                valeurTraitee = valeurRecu;
                fin = false;
            } else {
                System.out.println("Veuillez commencer la description par une lettre pour continuer");
                fin = true;
            }

        } while (fin);

        return valeurTraitee;
    }


    //*********************************************************************
    // Fonction qui sert a verifier le sexe choisi
    //*********************************************************************
    public static String sexeChoice() {

        String valeurSaisi;
        boolean isferme;
        String valeurTraitee = "";
        do {
            valeurSaisi = input.nextLine();
            if (!valeurSaisi.equalsIgnoreCase("0") && !valeurSaisi.equalsIgnoreCase("1") && !valeurSaisi.equalsIgnoreCase("2")) {
                System.out.println("Ressayez de nouveau avec un chiffre entre 0-2");
                isferme = false;

            } else {
                valeurTraitee = valeurSaisi;
                isferme = true;
            }

        } while (!isferme);

        return valeurTraitee;
    }
    //*********************************************************************
    //Fonction qui sert à choisir traiter les nouveaux fournisseurs et les
    // fournisseur existants
    //*********************************************************************
    public static  void choixDeFournisseur() {
        String entree2;
        boolean fin = false;
        while (!fin){
            entree2 = input.nextLine();
            switch(entree2){
                case"1":// nouveau fournisseur
                    idNouveau();
                break;
                case"2":
                    idExistant();
                    break;
                default:
                    System.out.println("Veuillez entrer 1 ou 2");
                    fin = true;
            }
    }

    }
    //*********************************************************************
    //Fonction qui sert à verifier si le ID du fournisseur est dans notre Inventaire
    // ou non
    //*********************************************************************
    public static void idExistant() {
        boolean idvalide = false;
        String findID;
        System.out.println("Quel est l'identifiant du fournisseur que vous aimerez associer a cet item?");
        while (!idvalide) {
            findID = input.nextLine();
            if (chercher(idfabricant, findID)) {
                idfabricant[ctr] = idfabricant[idx];
                idvalide = true;
            } else {
                System.out.println("Ce numero d'identifiant n'existe pas dans notre inventaire");
                idvalide = false;
            }
        }

    }

    //********************************************************************
    // Fonction qui sert a entrer les nouveau information du fournisseur
    //*********************************************************************
    public static void idNouveau() {

            System.out.println("Quel est le numéro d'identification pour le nouveau fournisseur ? ");
            idfabricant[ctr] = verificationDeEntier(idfabricant, msgErreurIdFab);

            System.out.println("Quel est le nom du fournisseur?");
            toutLesNomsDesFabriacants[ctr]= input.nextLine();
            nomDuFournisseur[fabCtr] = toutLesNomsDesFabriacants[ctr];
            System.out.println("Quel est le numéro de telephone du fournisseur" +
                    "(en format: 000-000-0000)");
            noDuFabriquant[ctr] = telephone();
            fabCtr++;
    }

    //********************************************************************
    //La fonction valide si le numéro de téléphone est valide
    //********************************************************************
    public static String telephone() {
        String valeurSaisi;
        String noTelephone = "";
        boolean fin = false;
        while (!fin) {
            valeurSaisi = input.nextLine();
            if (validerTelephone(valeurSaisi)) {
                noTelephone = valeurSaisi;
                fin = true;
            } else fin = false;
        }
        return noTelephone;
    }

    //********************************************************************
    //La fonction valide si le numéro de téléphone est valide
    //********************************************************************
    public static boolean validerTelephone(String ch) {
        boolean valide;

        String regexp = "^(\\([0-9]{3}\\)|[0-9]{3})([-| ])?[0-9]{3}(-| )?[0-9]{4}$";


        valide = ch.matches(regexp);

        return valide;
    }


    //*********************************************************************
    //Fonction qui sert à verifier si la valeur saisi est un entier ou non
    // Ca retourne true ou false
    //*********************************************************************
    public static boolean tousDesChiffres(String chaine) {
        boolean tousDesChiffres = true;
        int i = 0;

        while (tousDesChiffres && i < chaine.length()) {
            if (!Character.isDigit(chaine.charAt(i))) {
                tousDesChiffres = false;
            } else {
                i++;
            }
        }
        return tousDesChiffres;
    }

    public static boolean estCeUnReel2(String chaine) {

        boolean cestUnReel;
        double n;

        try {
            n = Double.parseDouble(chaine);
            cestUnReel = true;
        } catch (NumberFormatException e) {
            cestUnReel = false;
        }
        return cestUnReel;
    }
    //******************************************************
    // Fonction qui sert a chercher dans un tableau pour une valeur
    //*********************************************************
    public static boolean chercher(int[] tablo, String valeurEntree) {
        boolean trouve;

        trouve = false;
        idx = 0;
        while ((!trouve) && (idx < nbrItems)) {
            String equiv = Integer.toString(tablo[idx]);
            if (valeurEntree.equalsIgnoreCase(equiv)) {
                trouve = true;
            } else {
                idx++;
            }
        }

        return trouve;
    }
    // trouver le index d'une valeur
    public static int localiser(int[] tablo, int valeurSaisi){
        boolean trouve;
        int idx;
        String entree = String.valueOf(valeurSaisi);

        System.out.println("***TRACE finction localiser");
        trouve = false;
        idx = 0;
        while((!trouve) && (idx < ctr)){
            if (entree.equalsIgnoreCase(Arrays.toString(tablo))){
                trouve = true;
            } else{
                idx++;
            }
        }
        if (!trouve)
            idx = -1;
        System.out.println("***TRACE fonction localiser; sortie:" + idx);
        return idx;
    }

    //*****************************************************
    //Procédure permettant d'afficher la liste des livres
    //*****************************************************
    public static void listerInventaire() {

        afficherEntete();
        for (int i = 0; i < nbrItems; i++) {
            afficherInventaire(i);
        }
    }
    //*****************************************************
    //Procédure permettant d'affichier l'entête de la liste
    //*****************************************************
    public static void afficherEntete(){
        String ch;
        ch = fixeS("", 100, "--");
        System.out.println(ch);
        ch = fixeS("No. d'item", 10, null) + " | "
                + fixeS(" *****Description***** ", 22, null) + "| "
                + fixeS(" ***Sexe*** ", 12, null) + "| "
                + fixeS("***ID du Fournisseur***", 23, null) + "| "
                + fixeS("Nom du Fournisseur", 20, null) + "| "
                + fixeS("No. du Fournisseur", 20, null) + "| "
                + fixeS("Prix de revient", 15, null) + " | "
                + fixeS("Prix de vente", 15, null) + " | "
                + fixeS("Qté", 4, null) + "| ";
        System.out.println(ch);
        ch = fixeS("", 100, "--");
        System.out.println(ch);
    }

    //*****************************************************
    //Procédure qui permet de formater et d'afficher un item
    //*****************************************************
    public static void afficherInventaire(int indice){
        String ch;
        String sexeA=sexOption[(sexe[indice])];
        String idF=String.valueOf(idfabricant[indice]);

        ch = fixeS(Integer.toString(itemNo[indice]), 8, null) + "| "
                + fixeS(itemDescription[indice], 25, null) + "| "
                + fixeS(sexeA, 7, null) + "| "
                + fixeS(idF, 15, null) + "| ";
                //+ fixeS(), 9, null) + "| "
               // + fixeS(Double.toString(tabPrix[indice]), 5, null) + "$| "
                //+ fixeS(Integer.toString(tabQte[indice]), 4, null) + "| ";
        System.out.println(ch);

    }
    //*****************************************************
    //Fonction qui retourne une chaine de longueur fixe;
    //La chaine initiale est tronquée si trop longue, ou
    //complétée avec le padding si trop courte
    //*****************************************************
    public static String fixeS(String s, int longueur, String pad) {
        StringBuilder chaineFixe = new StringBuilder();
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
                chaineFixe.append(s.charAt(i));
            } else {
                chaineFixe.append(pad);
            }
            i++;
        }
        return chaineFixe.toString();
    }



}//la class main
