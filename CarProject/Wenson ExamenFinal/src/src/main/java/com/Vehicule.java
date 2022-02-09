package com;

public abstract class Vehicule {
    protected String marque;
    protected Moteur moteur;

    public Vehicule(){
        this.marque = null;
        this.moteur = new Moteur();

    }
    public Vehicule(String marque, Moteur moteur){
        this.marque = marque;
        this.moteur = moteur;
    }
    public Vehicule( Vehicule autre){
        this.marque = autre.marque;
        this.moteur = autre.moteur;

    }
    public String toString(){
        String chaine;
        chaine= "La marque du vehicule est "+marque+".\n"+moteur+".";

        return chaine;
    }
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Vehicule other = (Vehicule) obj;

        if (!this.marque.equals(other.marque)) {
            return false;
        }
        return this.moteur == other.moteur;
    }
    public String getMarque(){return marque;}
    public void setMarque(String marque){ this.marque= marque; }

    abstract void deplacement();

}
