import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class Ecran_Arene extends JFrame {
    private JButton retour; 
    private JButton [] stage; 
    private static int num_stage = 1; 
    
    public Ecran_Arene(){
        setTitle("Choix du Stage"); 
        setSize(1000, 600); 
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
    
            //BOUTON RETOUR; 
        retour = new JButton(); 
        ImageIcon imageIcon = new ImageIcon("src/main/java/Bouton/bouton_retour.png"); 
        Image image = imageIcon.getImage().getScaledInstance(72, 40, Image.SCALE_SMOOTH);
        retour.setIcon(new ImageIcon(image));
        retour.setBackground(c[0]);
        retour.setBorder(new LineBorder(c[0]));
        JPanel panel_retour = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0)); 
        panel_retour.setBackground(c[0]);
        panel_retour.add(retour); 
            //IMAGE CHOIX DU STAGE; 
        imageIcon = new ImageIcon("src/main/java/Stage/choix_stage.png"); 
        image = imageIcon.getImage().getScaledInstance(300, 55, Image.SCALE_SMOOTH);
        JLabel choix_stage = new JLabel(new ImageIcon(image)); 
        choix_stage.setAlignmentX(Component.CENTER_ALIGNMENT);
        
            //PANEL NORTH PRINCIPAL; 
        JPanel panel_nord = new JPanel(); 
        panel_nord.setLayout(new BoxLayout(panel_nord, BoxLayout.Y_AXIS));
        panel_nord.setBackground(c[0]);
        panel_nord.add(panel_retour);
        panel_nord.add(choix_stage); 
        panel_nord.add(Box.createRigidArea(new Dimension(0, 60)));
    
            //CREATION DES STAGES; 
        stage = new JButton[6]; 
        int nb = 5; 
        stage[0] = new JButton(); 
            imageIcon = new ImageIcon("src/main/java/Stage/vert.png"); 
            image = imageIcon.getImage().getScaledInstance(53*nb, 32*nb, Image.SCALE_SMOOTH);
            stage[0].setIcon(new ImageIcon(image));
        stage[1] = new JButton(); 
            imageIcon = new ImageIcon("src/main/java/Stage/bleu.png"); 
            image = imageIcon.getImage().getScaledInstance(53*nb, 32*nb, Image.SCALE_SMOOTH);
            stage[1].setIcon(new ImageIcon(image));
        stage[2] = new JButton(); 
            imageIcon = new ImageIcon("src/main/java/Stage/rouge.png"); 
            image = imageIcon.getImage().getScaledInstance(53*nb, 32*nb, Image.SCALE_SMOOTH);
            stage[2].setIcon(new ImageIcon(image));
        stage[3] = new JButton(); 
            imageIcon = new ImageIcon("src/main/java/Stage/gris.png"); 
            image = imageIcon.getImage().getScaledInstance(53*nb, 32*nb, Image.SCALE_SMOOTH);
            stage[3].setIcon(new ImageIcon(image));
        stage[4] = new JButton(); 
            imageIcon = new ImageIcon("src/main/java/Stage/jaune.png"); 
            image = imageIcon.getImage().getScaledInstance(53*nb, 32*nb, Image.SCALE_SMOOTH);
            stage[4].setIcon(new ImageIcon(image));
        stage[5] = new JButton(); 
            imageIcon = new ImageIcon("src/main/java/Stage/violet.png"); 
            image = imageIcon.getImage().getScaledInstance(53*nb, 32*nb, Image.SCALE_SMOOTH);
            stage[5].setIcon(new ImageIcon(image));
        for(int i=0; i<stage.length; i++){
            stage[i].setBackground(c[0]);
            stage[i].setBorder(new LineBorder(c[0]));
        }

        JPanel panel_centre = new JPanel(new GridLayout(2, 3, 0, 0)); 
        panel_centre.setBackground(c[0]);
            for(int i=0; i<stage.length; i++){
                panel_centre.add(stage[i]); 
            }

        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(c[0]);
        getContentPane().add(panel_nord, BorderLayout.NORTH); 
        getContentPane().add(panel_centre, BorderLayout.CENTER); 
        
        Bouton(); 
    }
    public void Bouton(){
        retour.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false); 
                new Ecran_Personnalisation().setVisible(true); 
            }
        }); 
        stage[0].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                num_stage = 1; 
                setVisible(false); 
                new Ecran_Combat().setVisible(true); 
            }
        }); 
        stage[1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                num_stage = 2; 
                setVisible(false); 
                new Ecran_Combat().setVisible(true); 
            }
        }); 
        stage[2].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                num_stage = 3; 
                setVisible(false); 
                new Ecran_Combat().setVisible(true); 
            }
        }); 
        stage[3].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                num_stage = 4; 
                setVisible(false); 
                new Ecran_Combat().setVisible(true); 
            }
        }); 
        stage[4].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                num_stage = 5; 
                setVisible(false); 
                new Ecran_Combat().setVisible(true); 
            }
        }); 
        stage[5].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                num_stage = 6; 
                setVisible(false); 
                new Ecran_Combat().setVisible(true); 
            }
        }); 
    }
    public int getNumStage(){
        return this.num_stage; 
    }
    public void setNumStage(){
        this.num_stage = 1; 
    } 
}