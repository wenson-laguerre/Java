package com;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Moteur {
private int cylindres;
private int kilometrage;

public Moteur(){}

public Moteur(int cylindres,int kilometrage){
this.cylindres = cylindres;
this.kilometrage = kilometrage;
}

public Moteur(Moteur autre){
this.cylindres =autre.cylindres;
this.kilometrage=autre.kilometrage;

}

public String toString(){
String infoMoteur;

infoMoteur = "Le moteur roule sur "+cylindres+" cylindres\n"
        + "Il a presentement "+kilometrage+"km de kilometrage";
return infoMoteur;
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
        
        final Moteur other = (Moteur) obj;
 
        if (this.cylindres != other.cylindres) {
            return false;
        }
        if(this.kilometrage != other.kilometrage){
            return false;
        }
                
        return true;
    }

public int getCylindre(){return cylindres;}

public int getKilometrage(){return kilometrage;}
        
public void setCylindre(int cylindres){this.cylindres = cylindres;}

public void setKilometrage(int kilometrage){this.kilometrage = kilometrage;}

}
