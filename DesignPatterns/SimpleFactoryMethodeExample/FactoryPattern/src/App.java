public class App {
    public static void main(String[] args)  {
        EtudiantFactory etudiantFactory = new EtudiantFactory();
                    /* TOUT CA SE PASSE DANS UN UI */

      //prendre de l'objet de Etudiant 
      Professeur employee_niv1 = etudiantFactory.getEtudiantNotes("60%");

      //call note method EtudiantPassable
      employee_niv1.note();

      Professeur employee_niv2 = etudiantFactory.getEtudiantNotes("75%");
      employee_niv2.note();

      Professeur employee_niv3 = etudiantFactory.getEtudiantNotes("90%");
      employee_niv3.note();
    }
}
