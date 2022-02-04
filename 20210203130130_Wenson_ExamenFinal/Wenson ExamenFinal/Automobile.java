package Moteur;

public class Automobile extends Vehicule {

    private String model ;
   public Automobile(){
       super();
   }
   public Automobile(String model,String marque,Moteur moteur){
       super(marque,moteur);
       this.model= model;

   }
   public Automobile(Automobile autre){
       super(autre);
       this.model = autre.model;
   }

   public String toString(){

String chaine;
chaine="Le model du vehicule est "+ model +"\n"+super.toString();
return chaine;
   }


public void deplacement(){
    System.out.println("Une automobile se deplace sur la terre a une vitesse moyenne de 100 km/h");
}


public String getModel(){return model;}

public void setModel(String model){
       this.model= model;
}

}
