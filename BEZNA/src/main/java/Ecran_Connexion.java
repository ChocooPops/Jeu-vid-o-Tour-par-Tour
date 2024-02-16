import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class Ecran_Connexion extends JFrame {
    private JTextArea id; 
    private JTextArea mdp; 
    private JButton connexion; 
    private JButton compte; 
    private JButton retour; 
    private JLabel text; 
    private ImageIcon [] expression; 
    private JLabel [] picture;
    private Image [] tmp; 
    
    public Ecran_Connexion(){
        //REINITIALISATION DE L EXPRESSION CHOISIS; 
        Ecran_Personnalisation réinitialiser = new Ecran_Personnalisation();
        réinitialiser.setNum_Choix(6);
        
        setTitle("Connexion"); 
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
        //TEXTE; 
        Border bordure = new LineBorder(Color.BLACK);
        Border bordure2 = new LineBorder(c[0]);
        expression = new ImageIcon[6]; 
        picture = new JLabel[6]; 
        tmp = new Image[6]; 
        
        id = new JTextArea("Identifiant"); 
        mdp = new JTextArea("Mots de Passe"); 
        connexion = new JButton(); 
        compte = new JButton(); 
        retour = new JButton(); 
        id.setBorder(bordure);
        mdp.setBorder(bordure);
        text = new JLabel(""); 
        text.setFont(new Font ("Arial", Font.BOLD, 14));
        text.setForeground(c[6]);
        //AJOUT D'UNE ACTION POUR SUPPRIMER LE TEXTE LORSQUE LE JTEXTAREA EST CLIQUE; 
        id.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                id.setText("");
            }
        });
        mdp.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                mdp.setText("");
            }
        });
        
        ImageIcon imageIcon = new ImageIcon("src/main/java/Bouton/bouton_connexion.png"); 
        Image image = imageIcon.getImage().getScaledInstance(216, 60, Image.SCALE_SMOOTH);
        connexion.setIcon(new ImageIcon(image));
        connexion.setBackground(c[0]);
        connexion.setBorder(bordure2);
        
        imageIcon = new ImageIcon("src/main/java/Bouton/bouton_creerUnCompte.png"); 
        image = imageIcon.getImage().getScaledInstance(144, 40, Image.SCALE_SMOOTH);
        compte.setIcon(new ImageIcon(image));
        compte.setBackground(c[0]);
        compte.setBorder(bordure2);
        
        imageIcon = new ImageIcon("src/main/java/Bouton/bouton_retour.png"); 
        image = imageIcon.getImage().getScaledInstance(72, 40, Image.SCALE_SMOOTH);
        retour.setIcon(new ImageIcon(image));
        retour.setBackground(c[0]);
        retour.setBorder(bordure2);
        
        expression[0] = new ImageIcon("src/main/java/expression/expression1.png"); 
        expression[1] = new ImageIcon("src/main/java/expression/expression2.png"); 
        expression[2] = new ImageIcon("src/main/java/expression/expression3.png"); 
        expression[3] = new ImageIcon("src/main/java/expression/expression4.png"); 
        expression[4] = new ImageIcon("src/main/java/expression/expression5.png"); 
        expression[5] = new ImageIcon("src/main/java/expression/expression6.png"); 
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
       
        id.setColumns(15);
        mdp.setColumns(10);
        id.setBackground(c[5]);
        mdp.setBackground(c[5]);
        id.setFont(new Font ("Arial", Font.BOLD, 14));
        mdp.setFont(new Font ("Arial", Font.BOLD, 14));
       
        JPanel ecran = new JPanel(new GridLayout (4, 3)); 
        ecran.setBackground(c[0]);
        
        JPanel ligne1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        ligne1.setBackground(c[0]);
        JPanel ligne11 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        ligne11.setBackground(c[0]);
        JPanel ligne2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        ligne2.setBackground(c[0]);
        JPanel ligne3 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 16)); 
        ligne3.setBackground(c[0]);
        JPanel ligne4 = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
        ligne4.setBackground(c[0]);
        
        ligne1.add(retour); 
        ligne2.add(connexion); 
        ligne3.add(id); 
        ligne4.add(mdp); 
        ligne11.add(compte); 
        
        ecran.add(ligne1); 
        ecran.add(text); 
        ecran.add(ligne11); 
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
       connexion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Traitement_Donnée fichier = new Traitement_Donnée(); 
                Catalogue_Membre c = new Catalogue_Membre(); 
                fichier.Remplir(c);
                Ecran_Personnalisation ecran = new Ecran_Personnalisation(); 
                String i = id.getText(); 
                String p = mdp.getText(); 
                Membre m = new Membre(i, p); 
                if(c.ExisteMembre(m)){
                    setVisible(false); 
                    ecran.setVisible(true); 
                }else{
                    text.setText("Identifiant ou mots de passe incorrect.");
                }
            }
        }); 
        compte.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Ecran_CreationCompte f = new Ecran_CreationCompte(); 
                f.setVisible(true);
                setVisible(false);  
            }
        }); 
        retour.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false); 
                Ecran_Accueil f = new Ecran_Accueil(); 
                f.setVisible(true);
            }
        }); 
    }
}
