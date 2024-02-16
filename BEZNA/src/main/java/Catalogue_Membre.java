import java.util.ArrayList;
import java.util.List;

public class Catalogue_Membre {
    private List<Membre> membre; 
    
    public Catalogue_Membre(){
        membre = new ArrayList<>();
    }
    
    public boolean ajDoc(Membre m){
        boolean op = false; 
        membre.add(m);
        if(membre.contains(membre)){
            op = true; 
        }
        return op; 
    }
    public boolean suppDoc(Membre m){
        boolean op = false; 
        membre.remove(m); 
        if(!membre.contains(m)){
            op = true;
        }
        return op; 
    }
    
    public Membre getMembre(int i){
        Membre m = null; 
        if(i>=0 && i<membre.size()){
            m = membre.get(i); 
        }
        return m; 
    }
    public boolean ExisteMembre(Membre m){
        boolean op = false; 
        for(int i=0; i<membre.size(); i++){
            if(membre.get(i).getIdentifiant().equals(m.getIdentifiant()) && membre.get(i).getMDP().equals(m.getMDP())){
                op = true; 
            }
        }
        return op; 
    }   
     public boolean ExisteID(String id){
        boolean op = false; 
        for(int i=0; i<membre.size(); i++){
            if(membre.get(i).getIdentifiant().equals(id)){
                op = true; 
            }
        }
        return op; 
    }   

    public void AfficherMembre(){
        for(int i=0; i<membre.size(); i++){
            System.out.println(membre.get(i).getIdentifiant() + " " + membre.get(i).getMDP());
        }
    }
}