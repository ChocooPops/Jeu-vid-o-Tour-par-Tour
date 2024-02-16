import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class NewClass extends JFrame {
        private Cercle [] cercle; 
    public NewClass(){
        setTitle("Choix_Monstre"); 
        setSize(1000, 1000); 
        setLocationRelativeTo(null); 
        setResizable(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int x = 0; 
        int y = 0; 
        JPanel ecran = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        cercle = new Cercle[30]; 
        for(int i=0; i<cercle.length; i++){
            cercle[i] = new Cercle(x,y); 
            ecran.add(cercle[i]); 
            x=+20; 
            y=+20; 
        }
        getContentPane().add(ecran); 
       
    }
    public class Cercle extends JPanel{
        Graphics2D g2d;
        private int x; 
        private int y; 
        public Cercle(int x, int y){
            this.x = x;
            this.y = y;
        }
        public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color c = Color.decode("#297444"); 
        setSize(41+x,41+y); 
        g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        int circleDiameter = 40; // Diamètre du cercle (plus petit que la taille du panneau)
        
        g2d.fillOval(x, y, circleDiameter, circleDiameter); // Remplir le cercle avec la couleur rouge      
        }
    }
}
