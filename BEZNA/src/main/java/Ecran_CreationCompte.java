import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class Ecran_CreationCompte extends JFrame {
    private JButton bouton1; 
    private JButton bouton2; 
    private JTextArea id; 
    private JTextArea [] mdp; 
    private JLabel text; 
    private ImageIcon [] expression; 
    private JLabel [] picture;
    private Image [] tmp; 
    
    public Ecran_CreationCompte(){
        setTitle("Création d'un compte"); 
        setSize(900, 300); 
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
        
        //TEXTE; 
        Border bordure = new LineBorder(Color.BLACK);
        Border bordure2 = new LineBorder(c[0]);
        text = new JLabel("");
        text.setFont(new Font ("Arial", Font.BOLD, 14));
        text.setForeground(c[6]);
        bouton1 = new JButton(); 
        bouton2 = new JButton(); 
        
        id = new JTextArea("Nouvel identifiant"); 
        mdp = new JTextArea[2]; 
        mdp[0] = new JTextArea("Nouveau mots de passe"); 
        mdp[1] = new JTextArea("Confirmation du mots de passe"); 
        id.setBorder(bordure);
        mdp[0].setBorder(bordure);
        mdp[1].setBorder(bordure);
        id.setColumns(16);
        mdp[0].setColumns(14);
        mdp[1].setColumns(12);
        id.setBackground(c[5]);
        mdp[0].setBackground(c[5]);
        mdp[1].setBackground(c[5]);
        id.setFont(new Font ("Arial", Font.BOLD, 14));
        mdp[0].setFont(new Font ("Arial", Font.BOLD, 14));
        mdp[1].setFont(new Font ("Arial", Font.BOLD, 14));
                //AJOUT D'UNE ACTION POUR SUPPRIMER LE TEXTE LORSQUE LE JTEXTAREA EST CLIQUE; 
        id.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                id.setText("");
            }
        });
        mdp[0].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                mdp[0].setText("");
            }
        });
        mdp[1].addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                mdp[1].setText("");
            }
        });
        
        ImageIcon imageIcon = new ImageIcon("src/main/java/Bouton/bouton_retour.png"); 
        Image image = imageIcon.getImage().getScaledInstance(72, 40, Image.SCALE_SMOOTH);
        bouton1.setIcon(new ImageIcon(image));
        bouton1.setBackground(c[0]);
        bouton1.setBorder(bordure2);
        
        imageIcon = new ImageIcon("src/main/java/Bouton/bouton_creerUnCompte.png"); 
        image = imageIcon.getImage().getScaledInstance(216, 60, Image.SCALE_SMOOTH);
        bouton2.setIcon(new ImageIcon(image));
        bouton2.setBackground(c[0]);
        bouton2.setBorder(bordure2);
        
        expression = new ImageIcon[6]; 
        picture = new JLabel[6]; 
        tmp = new Image[6]; 
        expression[0] = new ImageIcon("src/main/java/expression/expression7.png"); 
        expression[1] = new ImageIcon("src/main/java/expression/expression8.png"); 
        expression[2] = new ImageIcon("src/main/java/expression/expression9.png"); 
        expression[3] = new ImageIcon("src/main/java/expression/expression5.png"); 
        expression[4] = new ImageIcon("src/main/java/expression/expression11.png"); 
        expression[5] = new ImageIcon("src/main/java/expression/expression10.png"); 
        for(int i=0; i<expression.length; i++){
            tmp[i] = expression[i].getImage().getScaledInstance(58, 54, Image.SCALE_DEFAULT); 
            expression[i] = new ImageIcon(tmp[i]); 
            picture[i] = new JLabel(expression[i]);
            picture[i].setVerticalAlignment(SwingConstants.CENTER);
        }
        picture[0].setHorizontalAlignment(SwingConstants.CENTER);
        picture[1].setHorizontalAlignment(SwingConstants.CENTER);
        picture[2].setHorizontalAlignment(SwingConstants.CENTER);
        picture[3].setHorizontalAlignment(SwingConstants.CENTER);
        picture[4].setHorizontalAlignment(SwingConstants.CENTER);
        picture[5].setHorizontalAlignment(SwingConstants.CENTER);
        
        //PANEL; 
        JPanel ecran = new JPanel(new GridLayout(4, 3));
        ecran.setBackground(c[0]);
        JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0)); 
        ligne1.setBackground(c[0]);
        JPanel ligne11 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25)); 
        ligne11.setBackground(c[0]);
        JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER,0, 0)); 
        ligne2.setBackground(c[0]);
        JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 20)); 
        ligne3.setBackground(c[0]);
        JPanel ligne4 = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        ligne4.setBackground(c[0]);
        
        //Ajout dans le panel; 
        ligne1.add(bouton1); 
        ligne11.add(text); 
        ligne2.add(bouton2); 
        ligne3.add(id); 
        ligne4.add(mdp[0]);
        ligne4.add(mdp[1]);
        
        ecran.add(ligne1); 
        ecran.add(ligne11); 
        ecran.add(new JLabel("")); 
        ecran.add(picture[0]); 
        ecran.add(ligne2);
        ecran.add(picture[1]);  
        ecran.add(picture[2]);  
        ecran.add(ligne3); 
        ecran.add(picture[3]); 
        ecran.add(picture[4]); 
        ecran.add(ligne4); 
        ecran.add(picture[5]); 
       
        getContentPane().add(ecran); 
        Bouton(); 
    }
    
    public void Bouton(){
        bouton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Ecran_Connexion f = new Ecran_Connexion(); 
                f.setVisible(true);
                setVisible(false); 
            }
        }); 
        bouton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Traitement_Donnée fichier = new Traitement_Donnée(); 
                Catalogue_Membre c = new Catalogue_Membre(); 
                fichier.Remplir(c);
                String i = id.getText(); 
                String m1 = mdp[0].getText(); 
                String m2 = mdp[1].getText(); 
                if(c.ExisteID(i)){
                    text.setText("Identifiant déjà existant");
                }else if(!m1.equals(m2)){
                    text.setText("Mots de passe incorrects"); 
                }else if(i.contains(";") || m1.contains(";")){
                    text.setText("Caractère incorrect"); 
                }
                else{
                    Ecran_Connexion ecran = new Ecran_Connexion();
                    fichier.Ecrire(i, m2);
                    ecran.setVisible(true); 
                    setVisible(false); 
                }
               
            }
        }); 
    }
}
