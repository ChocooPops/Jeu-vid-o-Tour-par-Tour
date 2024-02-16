import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class Ecran_Accueil extends JFrame {
    private JButton commencer; 
    
    public Ecran_Accueil(){
        setTitle("Accueil"); 
        setSize(900, 300); 
        setLocationRelativeTo(null); 
        setResizable(false); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //COULEUR #A8d7FA       Vert     Orange      OrangeCl    Blanc     marron   JauneClaire
        String [] couleur = {"#297444", "#d36d08", "#eb9800", "#ffffff", "#884705", "#ffda6e", "#000000"};      
        Color [] c = new Color[couleur.length]; 
        for (int i=0; i<couleur.length; i++){
            c[i] = Color.decode(couleur[i]); 
        } 
        getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, c[1])); 
        JPanel ecran = new JPanel(new GridLayout (1, 3)); 
        Border bordure = new LineBorder(c[6]);
        Border bordure2 = new LineBorder(c[0]); 
        
        //Texte
        ImageIcon icon = new ImageIcon("src/main/java/Bouton/Bienvenue.png"); 
        Image imageicon = icon.getImage().getScaledInstance(230, 55, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(imageicon); 
        JLabel bienvenue = new JLabel(icon2);
       
        ImageIcon i = new ImageIcon("src/main/java/Bouton/BEZNA.png"); 
        Image bezna = i.getImage().getScaledInstance(264, 20, Image.SCALE_SMOOTH);
        ImageIcon i2 = new ImageIcon(bezna); 
        JLabel text2 = new JLabel(i2);
        
        text2.setAlignmentX(Component.CENTER_ALIGNMENT); 
        bienvenue.setAlignmentX(Component.CENTER_ALIGNMENT); 

        commencer = new JButton(); 
        ImageIcon imageIcon = new ImageIcon("src/main/java/Bouton/bouton_commencer.png"); 
        Image image = imageIcon.getImage().getScaledInstance(237, 60, Image.SCALE_SMOOTH);
        commencer.setIcon(new ImageIcon(image));
        commencer.setAlignmentX(Component.CENTER_ALIGNMENT); 
        commencer.setBackground(c[0]);
        commencer.setBorder(bordure2);
        
        //AJOUT AU PANEL 
        JPanel panel = new JPanel(); 
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(c[0]);
        panel.add(Box.createRigidArea(new Dimension(0, 15))); //Ajoute un saut de ligne; 
        panel.add(bienvenue); 
        panel.add(Box.createRigidArea(new Dimension(0, 40))); //Ajoute un saut de ligne; 
        panel.add(text2); 
        panel.add(Box.createRigidArea(new Dimension(0, 40))); //Ajoute un saut de ligne; 
        panel.add(commencer); 
        
        //GIF;
        JPanel p1 = new JPanel(new GridLayout(1,1));
        JPanel p2 = new JPanel(new GridLayout(1,1));
        p1.setBackground(c[0]);
        p2.setBackground(c[0]);
        ImageIcon gif = new ImageIcon("src/main/java/Attaque/marche.gif"); 
        
        //DIMENSION; 
        Image nouv_image = gif.getImage(); 
        nouv_image = nouv_image.getScaledInstance(117, 195, Image.SCALE_DEFAULT); 
        JLabel image1 = new JLabel(new ImageIcon(nouv_image));
        JLabel image2 = new JLabel(new ImageIcon(nouv_image));
        
        //AJOUT PANEL PRINCIPAL; 
        p1.add(image1);
        p2.add(image2); 
        ecran.add(p1); 
        ecran.add(panel); 
        ecran.add(p2); 
 
        getContentPane().add(ecran); 
        Bouton(); 
    }
     public void Bouton(){
        commencer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false); 
                Ecran_Connexion f = new Ecran_Connexion(); 
                f.setVisible(true);
            }
        }); 
    }
}
