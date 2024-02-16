import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class Ecran_Monstre extends JFrame {
    private JButton retour; 
    private JButton [] choix; 
    private JButton confirmation; 
    private JLabel [] monstre; 
    private ImageIcon [] imageIcon; 
    private JButton [] nom_monstre; 
    private JLabel texte; 
    private static int num_monstre = 0; 
    private Cercle [] cercle; 
             
    public Ecran_Monstre(){
        setTitle("Choix du Monstre"); 
        setSize(1050, 900); 
        setLocationRelativeTo(null); 
        setResizable(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //COULEUR #A8d7FA       Vert     Orange      OrangeCl    Blanc     marron   JauneClaire  
        String [] couleur = {"#297444", "#d36d08", "#eb9800", "#ffffff", "#884705", "#ffda6e", "#000000"};      
        Color [] c = new Color[couleur.length]; 
        for (int i=0; i<couleur.length; i++){
            c[i] = Color.decode(couleur[i]); 
        } 
        Border bordure = new LineBorder(Color.BLACK);
        Border bordure2 = new LineBorder(c[0]);
        getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, c[1]));
        imageIcon = new ImageIcon[5];
        new Ecran_Arene().setNumStage();
        //CONFIGURATION DES BOUTONS ET IMAGE; 
            //BOUTON RETOUR; 
        retour = new JButton(); 
        imageIcon[0] = new ImageIcon("src/main/java/Bouton/bouton_retour.png"); 
        Image image = imageIcon[0].getImage().getScaledInstance(72, 40, Image.SCALE_SMOOTH);
        retour.setIcon(new ImageIcon(image));
        retour.setBackground(c[0]);
        retour.setBorder(bordure2);
            //BOUTON DE CONFIRMATION; 
        confirmation = new JButton(); 
        imageIcon[0] = new ImageIcon("src/main/java/choix_perso/confirmation.png"); 
        image = imageIcon[0].getImage().getScaledInstance(260, 144, Image.SCALE_SMOOTH);
        confirmation.setIcon(new ImageIcon(image)); 
        confirmation.setBackground(c[0]);
        confirmation.setBorder(bordure2);
            //IMAGE CHOIX DU MONSTRE; 
        texte = new JLabel(""); 
        texte.setFont(new Font ("Arial", Font.BOLD, 20));
        texte.setForeground(c[6]);
        imageIcon[0] = new ImageIcon("src/main/java/Monstre/Choix.png"); 
        image = imageIcon[0].getImage().getScaledInstance(308, 182, Image.SCALE_SMOOTH);
        JLabel choix_monstre = new JLabel(new ImageIcon(image));
            //IMAGE DES MONSTRES; 
        imageIcon[0] = new ImageIcon("src/main/java/Monstre/demon.png"); 
        imageIcon[1] = new ImageIcon("src/main/java/Monstre/fantome.png"); 
        imageIcon[2] = new ImageIcon("src/main/java/Monstre/lune.png"); 
        imageIcon[3] = new ImageIcon("src/main/java/Monstre/pieuvre.png"); 
        imageIcon[4] = new ImageIcon("src/main/java/Monstre/requin.png"); 
        monstre = new JLabel[5];
        image = imageIcon[0].getImage().getScaledInstance(261, 210, Image.SCALE_SMOOTH);
        monstre[0] = new JLabel(new ImageIcon(image));
        image = imageIcon[1].getImage().getScaledInstance(228, 196, Image.SCALE_SMOOTH);
        monstre[1] = new JLabel(new ImageIcon(image));
        image = imageIcon[2].getImage().getScaledInstance(160, 180, Image.SCALE_SMOOTH);
        monstre[2] = new JLabel(new ImageIcon(image));
        image = imageIcon[3].getImage().getScaledInstance(246, 183, Image.SCALE_SMOOTH);
        monstre[3] = new JLabel(new ImageIcon(image));
        image = imageIcon[4].getImage().getScaledInstance(330, 156, Image.SCALE_SMOOTH);
        monstre[4] = new JLabel(new ImageIcon(image));
            //IMGAGE DES NOMS; 
        imageIcon[0] = new ImageIcon("src/main/java/Monstre/nom_demon.png"); 
        imageIcon[1] = new ImageIcon("src/main/java/Monstre/nom_fantome.png"); 
        imageIcon[2] = new ImageIcon("src/main/java/Monstre/nom_lune.png"); 
        imageIcon[3] = new ImageIcon("src/main/java/Monstre/nom_pieuvre.png"); 
        imageIcon[4] = new ImageIcon("src/main/java/Monstre/nom_requin.png");
        nom_monstre = new JButton[5];
        for (int i=0; i<nom_monstre.length; i++){
            nom_monstre[i] = new JButton(); 
            nom_monstre[i].setBackground(c[0]);
            nom_monstre[i].setBorder(bordure2);
        }
        image = imageIcon[0].getImage().getScaledInstance(184, 44, Image.SCALE_SMOOTH);
        nom_monstre[0].setIcon(new ImageIcon(image));
        image = imageIcon[1].getImage().getScaledInstance(220, 44, Image.SCALE_SMOOTH);
        nom_monstre[1].setIcon(new ImageIcon(image));
        image = imageIcon[2].getImage().getScaledInstance(156, 44, Image.SCALE_SMOOTH);
        nom_monstre[2].setIcon(new ImageIcon(image));
        image = imageIcon[3].getImage().getScaledInstance(240, 44, Image.SCALE_SMOOTH);
        nom_monstre[3].setIcon(new ImageIcon(image));
        image = imageIcon[4].getImage().getScaledInstance(168, 44, Image.SCALE_SMOOTH);
        nom_monstre[4].setIcon(new ImageIcon(image));
         
        //Placement ligne1; 
        JPanel placement_retour = new JPanel (new FlowLayout(FlowLayout.LEFT, 0, 0));
        placement_retour.setBackground(c[0]);
        JPanel placement_choix_monstre = new JPanel (new FlowLayout(FlowLayout.CENTER, 0, 15)); 
        placement_choix_monstre.setBackground(c[0]);
        placement_retour.add(retour); 
        placement_choix_monstre.add(choix_monstre);
        placement_choix_monstre.add(texte); 
        
        //PLacement des monstres avec leur nom; 
        JPanel [] placement_monstre = new JPanel[5];
        placement_monstre[0] = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        placement_monstre[1] = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        placement_monstre[2] = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 22));
        placement_monstre[3] = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        placement_monstre[4] = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 23));
        
        cercle = new Cercle[5]; 
        for(int i=0; i<placement_monstre.length; i++){
            cercle[i] = new Cercle(Color.RED); 
            placement_monstre[i].setBackground(c[0]);
            placement_monstre[i].add(monstre[i]); 
            placement_monstre[i].add(nom_monstre[i]); 
            placement_monstre[i].add(cercle[i]);  
        }
        //Placement bouton; 
        JPanel placement_confirmation = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 100));
        placement_confirmation.add(confirmation); 
        placement_confirmation.setBackground(c[0]); 
   
        //PANEL_PRINCIPAL; 
        JPanel ecran = new JPanel(new GridLayout(3, 3)); 
        ecran.setBackground(c[0]);
        retour.setBackground(c[0]);
        ecran.add(placement_retour); 
        ecran.add(placement_choix_monstre); 
        ecran.add(new JLabel("")); 
        ecran.add(placement_monstre[0]);  
        ecran.add(placement_monstre[1]);   
        ecran.add(placement_monstre[2]);     
        ecran.add(placement_monstre[3]);    
        ecran.add(placement_monstre[4]);     
        ecran.add(placement_confirmation); 
  
        getContentPane().add(ecran); 
        Bouton(); 
    }
     public void Bouton(){
        retour.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Ecran_Personnalisation f = new Ecran_Personnalisation(); 
                f.setVisible(true);
                setVisible(false);
            }
        }); 
        nom_monstre[0].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               num_monstre = 1;
               texte.setFont(new Font ("Arial", Font.BOLD, 20));
               texte.setText("Mondéfire a été choisis");
            }
        }); 
        nom_monstre[1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               num_monstre = 2;
                texte.setFont(new Font ("Arial", Font.BOLD, 20));
                texte.setText("Ghostboxeur a été choisis");
            }
        }); 
        nom_monstre[2].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                num_monstre = 3;
                Ecran_Monstre f = new Ecran_Monstre(); 
                texte.setFont(new Font ("Arial", Font.BOLD, 20));
                texte.setText("Lunatike a été choisis");
            }
        }); 
        nom_monstre[3].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                num_monstre = 4;
                texte.setFont(new Font ("Arial", Font.BOLD, 20));
                texte.setText("Popoulfoudre a été choisis");
            }
        }); 
        nom_monstre[4].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                num_monstre = 5; 
                texte.setFont(new Font ("Arial", Font.BOLD, 20));
                texte.setText("Morquint a été choisis");
            }
        }); 
        confirmation.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(num_monstre == 0){
                    texte.setFont(new Font ("Arial", Font.BOLD, 10));
                    texte.setText("Choisissez un monstre à combattre avant de passer au combat !!!");
                }else{
                    new Ecran_Arene().setVisible(true);
                    setVisible(false); 
                }
            }
        }); 
     }
     public int getNum_Monstre(){
         return this.num_monstre; 
     }
     public void setNum_Monstre(int nb){
        num_monstre = nb;
    }
    //Création d'un cercle; 
    public class Cercle extends JPanel{
        Graphics2D g2d;
        Color couleur; 
        public Cercle(Color new_couleur){
            this.couleur = new_couleur; 
        }
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Color c = Color.decode("#297444"); 
            setSize(25,25); 
            g2d = (Graphics2D) g;
            g2d.setColor(c);
            g2d.fillRect(0, 0, getWidth(), getHeight()); // Remplir le fond en vert
            g2d.setColor(couleur);
            int circleDiameter = 20; // Diamètre du cercle (plus petit que la taille du panneau)
            g2d.drawOval(0, 0, circleDiameter, circleDiameter); // Dessiner le contour du cercle
            g2d.fillOval(0, 0, circleDiameter, circleDiameter); // Remplir le cercle avec la couleur rouge      
        }
    }  
}
