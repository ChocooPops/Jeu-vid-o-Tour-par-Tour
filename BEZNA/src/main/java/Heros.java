import java.util.Random; 
public class Heros {
    private int PV; 
    private int [] puissance_attaque; 

    public Heros(){
        puissance_attaque = new int [5];
        puissance_attaque[0] = CoupPoing(); 
        puissance_attaque[1] = LanceFlamme(); 
        puissance_attaque[2] = Plante(); 
        puissance_attaque[3] = DoubleLanceFlamme(); 
        puissance_attaque[4] = Vomi(); 
        PV = 3000; 
    }
    public int CoupPoing(){
        Random random = new Random(); 
        int att = random.nextInt(10);
        System.out.println(att);
        if(att == 1)
            att = 4000;
        else att = 150;
        return att; 
    }
    public int LanceFlamme(){
        Random random = new Random(); 
       return 280 + (random.nextInt(150)); 
    }
    public int Plante(){
        Random random = new Random(); 
        return 400 + (random.nextInt(200)); 
    }
    public int DoubleLanceFlamme(){
        Random random = new Random(); 
        return 650 + (random.nextInt(150)); 
    }
    public int Vomi(){
        Random random = new Random(); 
        int attaque; 
        int chance = 1+ (random.nextInt(3));
        if(chance == 1 ){
            attaque = 1000; 
        }else{
            attaque = 1; 
        }
        return attaque; 
    }
    public void AugmenterPV(){
        this.PV = this.PV + 1300; 
        if(PV > 3000){
            this.PV = 3000; 
        }
    }
    
    public int getPuissanceAttaque(int indice){
        int puissance = 0; 
        if(indice >= 0 && indice <puissance_attaque.length){
            puissance = puissance_attaque[indice]; 
        }
        return puissance; 
    }
    public void Attaque_Subit(int attaque_heros){
        this.PV = this.PV - attaque_heros; 
        if(PV<0){
           PV = 0; 
        }
    }
    public int getPV(){
        return this.PV; 
    }
}
