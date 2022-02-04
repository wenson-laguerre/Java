package Moteur;

public class TestMoteur {


    public static void main(String[] args) {
        Moteur v8 = new Moteur();
       v8.setCylindre(8);
       v8.setKilometrage(160);
      //System.out.println( v8.getCylindre());
      //System.out.println(v8.getKilometrage());
      //System.out.println(v8);

      // Moteur v6 = new Moteur(6,120);
       //System.out.println(v6);

       //Moteur copiev6 = new Moteur(v6);
        //System.out.println(copiev6);
        //System.out.println(v8.equals(copiev6));
        //System.out.println(v6.equals(copiev6));

        Automobile yaris = new Automobile();

        yaris.setMarque("Toyota");
        yaris.setModel("Yaris 2012");
        yaris.moteur.setCylindre(4);
        yaris.moteur.setKilometrage(110);
        //yaris.deplacement();
        //System.out.println(yaris);

        Automobile accord = new Automobile(yaris);
        System.out.println(accord);
        accord.setModel("Accord");
        accord.setMarque("Honda");
        System.out.println(accord.getModel());
        System.out.println(accord.getMarque());
        accord.moteur.setKilometrage(125);
        accord.moteur.setCylindre(6);
        System.out.println(accord);

        Automobile civic = new Automobile("Civic","Honda",v8);
        System.out.println(civic);
    }


    
}
