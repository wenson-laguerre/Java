public class EtudiantFactory {

       /*utiliser getEtudiant method pour trouver le
        profile d'etudiant qui permet aux employeur de
        choisir les etudiant en fonction de leur note 
        et non leur informations personnel(ethnie,age etc)*/ 
   public Professeur getEtudiantNotes(String typeEtudiant){
    if(typeEtudiant == null){
       return null;
    }		
    if(typeEtudiant.equalsIgnoreCase("90%")){
       return new ExcellentEtudiant();
       
    } else if(typeEtudiant.equalsIgnoreCase("75%")){
       return new EtudiantMoyen();
       
    } else if(typeEtudiant.equalsIgnoreCase("60%")){
       return  new EtudiantPassable();
    }
    
    return null;
 }
    
}
