import java.util.Random; 
public class Monstre {
    private int PV; 
    private int type; 
    private int attaque; 
    public Monstre(int numMonstre){
        type = numMonstre; 
        PV =  Vitalite(); 
    }
    private int Vitalite(){
        int vie; 
        if(type >=1 && type<=3){
            vie = 3500; 
        }else{
            vie = 5000; 
        }
        return vie; 
    }
    public int getAttaqueMonstre(){
        Random random = new Random();  
        if(type >=1 && type<=3){
            attaque = 150 + (random.nextInt(800)); 
        }else{
            attaque = 300 + (random.nextInt(1000)); 
        }
        return attaque; 
    }
    public void Attaque_Subit(int attaque_monstre){
        this.PV = this.PV - attaque_monstre; 
        if(PV<0){
            PV = 0; 
        }
    }
    public int getPV(){
        return this.PV; 
    }
    public int getType(){
        return this.type; 
    }
}
