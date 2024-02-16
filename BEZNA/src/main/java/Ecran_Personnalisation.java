import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class Ecran_Personnalisation extends JFrame {
    private JButton [] bouton; 
    private ImageIcon [] choix; 
    private ImageIcon [] expression; 
    private JLabel [] icon; 
    private JButton retour; 
    private JButton confirmation; 
    private static int num_choix = 6; 
    
    public Ecran_Personnalisation(){
        //REINITIALISATION DU MONSTRE CHOISIS;
        Ecran_Monstre réinitialiser = new Ecran_Monstre();
        réinitialiser.setNum_Monstre(0);
        setTitle("Personnalisation du Personnage"); 
        setSize(700, 650); 
        setLocationRelativeTo(null); 
        setResizable(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //COULEUR #A8d7FA       Vert     Orange      OrangeCl    Blanc     marron   JauneClaire  
        String [] couleur = {"#297444", "#d36d08", "#eb9800", "#ffffff", "#884705", "#ffda6e", "#000000"};      
        Color [] c = new Color[couleur.length]; 
        for (int i=0; i<couleur.length; i++){
            c[i] = Color.decode(couleur[i]); 
        } 
        getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, c[1])); 
        Border bordure = new LineBorder(Color.BLACK);
        Border bordure2 = new LineBorder(c[0]);
        
        //BOUTON DE CONFIRMATION; 
        confirmation = new JButton(); 
        ImageIcon imageIcon = new ImageIcon("src/main/java/choix_perso/confirmation.png"); 
        Image image = imageIcon.getImage().getScaledInstance(260, 144, Image.SCALE_SMOOTH);
        confirmation.setIcon(new ImageIcon(image));
        confirmation.setBackground(c[0]);
        confirmation.setBorder(bordure2);
          
        //IMPLEMENTATION DES IMAGES; 
        retour = new JButton(); 
        imageIcon = new ImageIcon("src/main/java/Bouton/bouton_retour.png"); 
        image = imageIcon.getImage().getScaledInstance(72, 40, Image.SCALE_SMOOTH);
        retour.setIcon(new ImageIcon(image));
        retour.setBackground(c[0]);
        retour.setBorder(bordure2);
        
        imageIcon = new ImageIcon("src/main/java/expression/corps.png"); 
        image = imageIcon.getImage().getScaledInstance(115, 170, Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(image); 
        JLabel corps = new JLabel(imageIcon);
        corps.setVerticalAlignment(SwingConstants.NORTH);
        
        imageIcon = new ImageIcon("src/main/java/Bouton/personnalisation.png"); 
        image = imageIcon.getImage().getScaledInstance(308, 44, Image.SCALE_SMOOTH); 
        imageIcon = new ImageIcon(image); 
        JLabel personnalisation = new JLabel(imageIcon); 
        
        //IMAGE DES EXPRESSIONS; 
        expression = new ImageIcon[11]; 
        icon = new JLabel[expression.length+1]; 
        expression[0] = new ImageIcon("src/main/java/expression/expression1.png"); 
        expression[1] = new ImageIcon("src/main/java/expression/expression2.png"); 
        expression[2] = new ImageIcon("src/main/java/expression/expression3.png"); 
        expression[3] = new ImageIcon("src/main/java/expression/expression4.png"); 
        expression[4] = new ImageIcon("src/main/java/expression/expression5.png"); 
        expression[5] = new ImageIcon("src/main/java/expression/expression6.png"); 
        expression[6] = new ImageIcon("src/main/java/expression/expression7.png"); 
        expression[7] = new ImageIcon("src/main/java/expression/expression8.png"); 
        expression[8] = new ImageIcon("src/main/java/expression/expression9.png"); 
        expression[9] = new ImageIcon("src/main/java/expression/expression10.png"); 
        expression[10] = new ImageIcon("src/main/java/expression/expression11.png"); 
        for(int i=0; i<expression.length; i++){
            Image tmp = expression[i].getImage().getScaledInstance(145, 135, Image.SCALE_DEFAULT); 
            expression[i] = new ImageIcon(tmp); 
            icon[i] = new JLabel(expression[i]);
            icon[i].setVerticalAlignment(SwingConstants.BOTTOM);
            icon[i].setHorizontalAlignment(SwingConstants.CENTER);
        }
        Image tmp = expression[5].getImage().getScaledInstance(145, 135, Image.SCALE_DEFAULT); 
        expression[5] = new ImageIcon(tmp); 
        icon[icon.length-1] = new JLabel(expression[5]);
        icon[icon.length-1].setVerticalAlignment(SwingConstants.BOTTOM);
        icon[icon.length-1].setHorizontalAlignment(SwingConstants.CENTER);
        
        //BOUTON DES CHOIX; 
        bouton = new JButton[11]; 
        choix = new ImageIcon[11];  
        choix[0] = new ImageIcon("src/main/java/choix_perso/choix_1.png"); 
        choix[1] = new ImageIcon("src/main/java/choix_perso/choix_2.png");
        choix[2] = new ImageIcon("src/main/java/choix_perso/choix_3.png");
        choix[3] = new ImageIcon("src/main/java/choix_perso/choix_4.png");
        choix[4] = new ImageIcon("src/main/java/choix_perso/choix_5.png");
        choix[5] = new ImageIcon("src/main/java/choix_perso/choix_6.png");
        choix[6] = new ImageIcon("src/main/java/choix_perso/choix_7.png");
        choix[7] = new ImageIcon("src/main/java/choix_perso/choix_8.png");
        choix[8] = new ImageIcon("src/main/java/choix_perso/choix_9.png");
        choix[9] = new ImageIcon("src/main/java/choix_perso/choix_10.png");
        choix[10] = new ImageIcon("src/main/java/choix_perso/choix_11.png");
        for(int i=0; i<bouton.length; i++){
            bouton[i] = new JButton(); 
            image = choix[i].getImage().getScaledInstance(108, 60, Image.SCALE_SMOOTH);
            bouton[i].setIcon(new ImageIcon(image));
            bouton[i].setBackground(c[0]);
            bouton[i].setBorder(bordure2);
        }
        
        //Panel; 
        JPanel ecran = new JPanel(new GridLayout(1, 2)); 
        ecran.setBackground(c[0]);
        
        //PANEL COLONNE 1; 
        JPanel colonne1 = new JPanel(new GridLayout(3, 1,0,0));
        colonne1.setBackground(c[0]);
        JPanel placement_retour = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
        JPanel placement_perso = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel placement = new JPanel(new GridLayout(2, 1)); 
        placement_retour.setBackground(c[0]);
        placement_perso.setBackground(c[0]);
        placement.setBackground(c[0]);
        //Placement; 
        retour.setHorizontalAlignment(SwingConstants.LEFT);
        retour.setVerticalAlignment(SwingConstants.NORTH);
        personnalisation.setHorizontalAlignment(SwingConstants.CENTER);
        placement_retour.add(retour); 
        placement_perso.add(personnalisation); 
        placement.add(placement_retour); 
        placement.add(personnalisation); 
        colonne1.add(placement);
        colonne1.add(icon[icon.length-1]); 
        colonne1.add(corps);
        
        //PANEL COLONNE 2; 
        JPanel colonne2 = new JPanel(new GridLayout(2, 1)); 
        JPanel placement_choix = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10)); 
        JPanel placement_conf = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 80)); 
        placement_choix.setBackground(c[0]);
        placement_conf.setBackground(c[0]);
        placement_conf.add(confirmation); 
        for(int i=0; i<bouton.length; i++){
            placement_choix.add(bouton[i]); 
        }
        colonne2.setBackground(c[0]);
        colonne2.add(placement_conf); 
        colonne2.add(placement_choix); 
      
        //AJOUT au PANEL; 
        ecran.add(colonne1);
        ecran.add(colonne2); 
        getContentPane().add(ecran); 
        Bouton(); 
    }
     public void Bouton(){
        retour.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Ecran_Connexion f = new Ecran_Connexion(); 
                f.setVisible(true);
                setVisible(false);
            }
        }); 
        bouton[0].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               icon[icon.length-1].setIcon(expression[0]);
               num_choix = 1; 
            }
        }); 
       bouton[1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               icon[icon.length-1].setIcon(expression[1]);
               num_choix = 2; 
            }
        }); 
        bouton[2].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               icon[icon.length-1].setIcon(expression[2]);
               num_choix = 3; 
            }
        }); 
        bouton[3].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               icon[icon.length-1].setIcon(expression[3]);
               num_choix = 4; 
            }
        }); 
       bouton[4].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               icon[icon.length-1].setIcon(expression[4]);
               num_choix = 5; 
            }
        }); 
        bouton[5].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               icon[icon.length-1].setIcon(expression[5]);
               num_choix = 6; 
            }
        }); 
        bouton[6].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               icon[icon.length-1].setIcon(expression[6]);
               num_choix = 7; 
            }
        }); 
       bouton[7].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               icon[icon.length-1].setIcon(expression[7]);
               num_choix = 8; 
            }
        }); 
        bouton[8].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               icon[icon.length-1].setIcon(expression[8]);
               num_choix = 9; 
            }
        }); 
        bouton[9].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               icon[icon.length-1].setIcon(expression[9]);
               num_choix = 10; 
            }
        }); 
       bouton[10].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                icon[icon.length-1].setIcon(expression[10]);
                num_choix = 11; 
            }
        }); 
       confirmation.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               Ecran_Monstre f = new Ecran_Monstre(); 
               f.setVisible(true); 
               setVisible(false); 
            }
        }); 
    }
    public int getNum_Choix(){
        return this.num_choix; 
    }
    public void setNum_Choix(int nb){
        num_choix = nb;
    }
}
