
public class Membre {
    private String identifiant; 
    private String mdp; 
    private boolean [] monstre_vaincu; 
    public Membre(String identifiant, String mdp){
        this.identifiant = identifiant; 
        this.mdp = mdp; 
        monstre_vaincu = new boolean[5]; 
        for(int i=0; i<monstre_vaincu.length; i++){
            monstre_vaincu[0] = false; 
        }
    }
    
    public String getIdentifiant(){
        return this.identifiant;
    }
    public String getMDP(){
        return this.mdp; 
    }
}