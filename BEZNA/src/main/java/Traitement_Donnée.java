import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Traitement_Donnée {
    ArrayList<String> liste; 
    private Scanner fic;
    
    //CONSTRUCTEUR; 
    public Traitement_Donnée(){
        liste = new ArrayList<>(); 
        try{
            fic = new Scanner(new FileInputStream("src/main/java/Base_de_Donnée.txt"));
        }catch(IOException e){
            e.printStackTrace();
        }
        while(fic.hasNext()){
            liste.add(fic.nextLine()); 
        }
    }
    
    public void Afficher(){
        for(int i=0; i<liste.size(); i++){
            System.out.println(liste.get(i));
        }
    }
    public void Remplir(Catalogue_Membre c){
        for(int i=0; i<liste.size(); i++){
            String [] str = liste.get(i).split(";"); 
            Membre m = new Membre(str[0], str[1]); 
            c.ajDoc(m); 
        }
    }
    public void Ecrire(String id, String mdp){
        try{
            FileWriter fw = new FileWriter("src/main/java/Base_de_Donnée.txt");
            BufferedWriter buffer = new BufferedWriter(fw); 
            for(int i=0; i<liste.size(); i++){
                buffer.write(liste.get(i));
                buffer.newLine();
            }
            buffer.write(id.concat(";").concat(mdp));
            buffer.newLine();
            buffer.close();
        }catch(IOException pb){
            pb.printStackTrace();
        }
    }
}

