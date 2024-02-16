import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

public class Ecran_Combat extends JFrame {
    private JButton abandonner; 
    private JButton [] attaque;
    private JButton accueil; 
    private JLabel choix_attaque; 
    private JLabel num_monstre; 
    private ImageIcon [] icon; 
    private JLabel [] expression; 
    private JLabel visage; 
    private JLabel corps; 
    private Image [] vie; 
    private JLabel vitalite_h; 
    private JLabel vitalite_m;
    private Image [] animation;
    private JLabel gif; 
    private JPanel panel_animation; 
    private JLabel pv_m; 
    private JLabel pv_h; 
    
    private Heros heros; 
    private Monstre monstre; 
    private int num_attaque; 
    private Color [] c;
    
    public void DefinirMonstre(){
        int nb = new Ecran_Monstre().getNum_Monstre();
        ImageIcon imageIcon = new ImageIcon(); 
        Image image; 
        if(nb == 1){
            imageIcon = new ImageIcon("src/main/java/Ecran_Combat/demon.gif"); 
            image = imageIcon.getImage().getScaledInstance(435, 350,  Image.SCALE_DEFAULT);
        }else if(nb == 2){
            imageIcon = new ImageIcon("src/main/java/Ecran_Combat/fantome.gif"); 
            image = imageIcon.getImage().getScaledInstance(432, 330,  Image.SCALE_DEFAULT);
        }else if(nb == 3){
            imageIcon = new ImageIcon("src/main/java/Ecran_Combat/lune.gif"); 
            image = imageIcon.getImage().getScaledInstance(245, 252,  Image.SCALE_DEFAULT);
        }else if(nb == 4){
            imageIcon = new ImageIcon("src/main/java/Ecran_Combat/pieuvre.gif"); 
            image = imageIcon.getImage().getScaledInstance(410, 335,  Image.SCALE_DEFAULT);
        }else{
            imageIcon = new ImageIcon("src/main/java/Ecran_Combat/requin.gif"); 
            image = imageIcon.getImage().getScaledInstance(440, 240,  Image.SCALE_DEFAULT);
        }
        num_monstre = new JLabel(new ImageIcon(image)); 
        monstre = new Monstre(nb); 
    }
    public void DefinirExpression(){
        int nb_ex = 0; 
        nb_ex = new Ecran_Personnalisation().getNum_Choix(); 
        if(nb_ex <=11 || nb_ex >= 1){
            visage = expression[nb_ex-1];
        }else{
             visage = expression[5];
        }
        heros = new Heros(); 
    }
    public void DefinirCouleur(){
        String [] couleur = {"#297444", "#295974", "#ac3232", "#b0b0b0", "#dcd824", "#70428a"}; 
        c[0] = Color.decode(couleur[new Ecran_Arene().getNumStage()-1]); 
    }
    
    public Ecran_Combat(){
        setTitle("Let the battle begin"); 
        setSize(1500, 920); 
        setLocationRelativeTo(null); 
        setResizable(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //COULEUR #A8d7FA       Vert       
        String [] couleur = {"#d36d08"};      
        c = new Color[couleur.length]; 
        c[0] = Color.decode(couleur[0]); 
        getRootPane().setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, c[0])); 
        DefinirCouleur(); 
        //PANEL PRINCIPAL SOUTH; 
        JPanel panel_nord = new JPanel(); 
        panel_nord.setLayout(new BoxLayout(panel_nord, BoxLayout.Y_AXIS));
        panel_nord.setBackground(c[0]);
            //Bouton abandonner; 
        abandonner = new JButton(); 
        ImageIcon imageIcon = new ImageIcon("src/main/java/Ecran_combat/abandonner.png"); 
        Image image = imageIcon.getImage().getScaledInstance(118, 40, Image.SCALE_SMOOTH);
        abandonner.setIcon(new ImageIcon(image));
        abandonner.setBackground(c[0]);
        abandonner.setBorder(new LineBorder(c[0]));
        JPanel panel_abandon = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0)); 
        panel_abandon.setBackground(c[0]);
        panel_abandon.add(abandonner); 
            //Image de combat; 
        imageIcon = new ImageIcon("src/main/java/Ecran_combat/fight.png"); 
        image = imageIcon.getImage().getScaledInstance(510, 66, Image.SCALE_SMOOTH);
        JLabel fight = new JLabel(new ImageIcon(image));
        fight.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel_nord.add(panel_abandon); 
        panel_nord.add(Box.createRigidArea(new Dimension(0, 15)));
        panel_nord.add(fight);
        panel_nord.add(Box.createRigidArea(new Dimension(0, 20)));
        
        //REPRESENTATION DU PERSONNAGE SU L'ECRAN; 
            //Création des expressions;  
        icon = new ImageIcon[11]; 
        expression = new JLabel[icon.length]; 
        icon[0] = new ImageIcon("src/main/java/expression/expression1.png"); 
        icon[1] = new ImageIcon("src/main/java/expression/expression2.png"); 
        icon[2] = new ImageIcon("src/main/java/expression/expression3.png"); 
        icon[3] = new ImageIcon("src/main/java/expression/expression4.png"); 
        icon[4] = new ImageIcon("src/main/java/expression/expression5.png"); 
        icon[5] = new ImageIcon("src/main/java/expression/expression6.png"); 
        icon[6] = new ImageIcon("src/main/java/expression/expression7.png"); 
        icon[7] = new ImageIcon("src/main/java/expression/expression8.png"); 
        icon[8] = new ImageIcon("src/main/java/expression/expression9.png"); 
        icon[9] = new ImageIcon("src/main/java/expression/expression10.png"); 
        icon[10] = new ImageIcon("src/main/java/expression/expression11.png"); 
        for(int i=0; i<icon.length; i++){
            Image tmp = icon[i].getImage().getScaledInstance(145, 135, Image.SCALE_DEFAULT); 
            icon[i] = new ImageIcon(tmp); 
            expression[i] = new JLabel(icon[i]);
            expression[i].setVerticalAlignment(SwingConstants.BOTTOM);
            expression[i].setHorizontalAlignment(SwingConstants.CENTER);
        }
            //Creation du corps;
        imageIcon = new ImageIcon("src/main/java/expression/corps.png"); 
        image = imageIcon.getImage().getScaledInstance(115, 170, Image.SCALE_SMOOTH);
        corps = new JLabel(new ImageIcon(image)); 
        corps.setVerticalAlignment(SwingConstants.NORTH);   
        
            //Creation des vies; 
        vie = new Image[8]; 
        icon[0] = new ImageIcon("src/main/java/Ecran_Combat/vie1.png"); 
        icon[1] = new ImageIcon("src/main/java/Ecran_Combat/vie2.png"); 
        icon[2] = new ImageIcon("src/main/java/Ecran_Combat/vie3.png"); 
        icon[3] = new ImageIcon("src/main/java/Ecran_Combat/vie4.png"); 
        icon[4] = new ImageIcon("src/main/java/Ecran_Combat/vie5.png"); 
        icon[5] = new ImageIcon("src/main/java/Ecran_Combat/vie6.png"); 
        icon[6] = new ImageIcon("src/main/java/Ecran_Combat/vie7.png"); 
        icon[7] = new ImageIcon("src/main/java/Ecran_Combat/vie8.png"); 
        for(int i=0; i<vie.length; i++){
            Image tmp = icon[i].getImage().getScaledInstance(333, 69, Image.SCALE_DEFAULT);  
            vie[i] = tmp; 
        }
        vitalite_h = new JLabel(new ImageIcon(vie[0])); 
        vitalite_m = new JLabel(new ImageIcon(vie[0])); 
        //Creation des monstres et du visage selon le choix de l'utilisateur;
        DefinirMonstre(); 
        DefinirExpression(); 
        
            //BOUTON RETOUR A L'ECRAN ACCUEIL; 
        accueil = new JButton(); 
        accueil.setBackground(Color.decode("#297444")); 
        accueil.setBorder(new LineBorder(Color.decode("#297444"))); 
        imageIcon = new ImageIcon("src/main/java/Ecran_Combat/accueil.png"); 
        image = imageIcon.getImage().getScaledInstance(70*3, 20*3, Image.SCALE_SMOOTH);
        accueil.setIcon(new ImageIcon(image));
        
        //PANEL OUEST PRINCIPAL; 
        JPanel panel_ouest = new JPanel(new BorderLayout()); 
        panel_ouest.setBackground(c[0]);
           //PLACEMENT CORPS;  
        JPanel panel_tete = new JPanel(new GridLayout(2, 1, 0 , 0)); 
        panel_tete.setBackground(c[0]);
        panel_tete.add(visage); 
        panel_tete.add(corps); 
            //PLACEMENT PV; 
        JPanel panel_heros = new JPanel(); 
            panel_heros.setBackground(c[0]);
            panel_heros.setLayout(new BoxLayout(panel_heros, BoxLayout.Y_AXIS));
        JPanel panel_vie = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0)); 
            panel_vie.setBackground(c[0]);
            panel_vie.add(vitalite_h);
            //PV DU HEROS; 
        pv_h = new JLabel("PV : " + heros.getPV()); 
            pv_h.setFont(new Font("Arial", Font.BOLD, 20));
            pv_h.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel_heros.add(pv_h); 
        panel_heros.add(panel_vie); 
        panel_heros.add(panel_tete); 
        panel_ouest.add(panel_heros, BorderLayout.SOUTH); 
        
        //Panel EAST PRINCPAL; 
        JPanel panel_est = new JPanel(new BorderLayout()); 
        panel_est.setBackground(c[0]);
        JPanel panel_monstre = new JPanel(); 
            panel_monstre.setBackground(c[0]);
            panel_monstre.setLayout(new BoxLayout(panel_monstre, BoxLayout.Y_AXIS));
            //PLACEMENT VIE; 
        JPanel panel_vie_monstre = new JPanel(new GridLayout(1, 1));
            panel_vie_monstre.setBackground(c[0]);
            panel_vie_monstre.add(vitalite_m); 
            //PLACEMENT MONSTRE;
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            panel.setBackground(c[0]);
            panel.add(num_monstre);
            //TEXTE DES PV;
        pv_m = new JLabel("PV : " + monstre.getPV()); 
            pv_m.setFont(new Font("Arial", Font.BOLD, 20));
            pv_m.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel_monstre.add(pv_m);
        panel_monstre.add(panel_vie_monstre);
        panel_monstre.add(Box.createRigidArea(new Dimension(0, 20)));
        panel_monstre.add(panel); 
        panel_est.add(panel_monstre, BorderLayout.NORTH); 
        
            //Creation des bouton; 
        attaque = new JButton[6]; 
        attaque[0] = new JButton(); 
            imageIcon = new ImageIcon("src/main/java/Ecran_combat/poing.png"); 
            image = imageIcon.getImage().getScaledInstance(63*3, 20*3, Image.SCALE_SMOOTH);
            attaque[0].setIcon(new ImageIcon(image));
        attaque[1] = new JButton(); 
            imageIcon = new ImageIcon("src/main/java/Ecran_combat/lance_flamme.png"); 
            image = imageIcon.getImage().getScaledInstance(63*3, 20*3, Image.SCALE_SMOOTH);
            attaque[1].setIcon(new ImageIcon(image));
        attaque[2] = new JButton(); 
            imageIcon = new ImageIcon("src/main/java/Ecran_combat/plante_feroce.png"); 
            image = imageIcon.getImage().getScaledInstance(65*3, 26*3, Image.SCALE_SMOOTH);
            attaque[2].setIcon(new ImageIcon(image));
        attaque[3] = new JButton(); 
            imageIcon = new ImageIcon("src/main/java/Ecran_combat/double_lance_flamme.png"); 
            image = imageIcon.getImage().getScaledInstance(63*3, 26*3, Image.SCALE_SMOOTH);
            attaque[3].setIcon(new ImageIcon(image));
        attaque[4] = new JButton(); 
            imageIcon = new ImageIcon("src/main/java/Ecran_combat/vomi.png"); 
            image = imageIcon.getImage().getScaledInstance(74*4, 26*4, Image.SCALE_SMOOTH);
            attaque[4].setIcon(new ImageIcon(image));
        attaque[5] = new JButton(); 
            imageIcon = new ImageIcon("src/main/java/Ecran_combat/soin.png"); 
            image = imageIcon.getImage().getScaledInstance(66*4, 20*4, Image.SCALE_SMOOTH);
            attaque[5].setIcon(new ImageIcon(image));
        
        for(int i=0; i<attaque.length; i++){
            attaque[i].setBackground(c[0]);
            attaque[i].setBorder(new LineBorder(c[0]));
        }
        
        //PANEL CENTRE PRINCPAL; 
        JPanel panel_centre = new JPanel(new BorderLayout()); 
        panel_centre.setBackground(c[0]);
            //TEXTE INDICATIF; 
        choix_attaque = new JLabel("C'est votre tour, choisissez une attaque."); 
            choix_attaque.setAlignmentX(Component.CENTER_ALIGNMENT);
            choix_attaque.setFont(new Font("Arial", Font.BOLD, 20)); 
            choix_attaque.setForeground(Color.BLACK);
            //PANEL NORD SECONDAIRE DES BOUTONS; 
        JPanel panel_bouton1 = new JPanel(new GridLayout(1, 1)); 
            panel_bouton1.setBackground(c[0]);
            panel_bouton1.add(attaque[0]); 
            panel_bouton1.add(attaque[1]); 
        JPanel panel_bouton2 = new JPanel(new GridLayout(1, 1)); 
            panel_bouton2.setBackground(c[0]);
            panel_bouton2.add(attaque[2]); 
            panel_bouton2.add(attaque[3]); 
            //TEXTE DESCRIPTION DES BOUTONS D'ATTAQUES;
        JLabel [] description_bouton = new JLabel[6];
        JPanel panel_description_1 = new JPanel(new GridLayout(1, 2));  
            panel_description_1.setBackground(c[0]);
        JPanel panel_description_2 = new JPanel(new GridLayout(1, 2));  
            panel_description_2.setBackground(c[0]);
            description_bouton[0] = new JLabel("1 chance sur 10 d'infliger un coup critique à 4000 PA"); 
            description_bouton[1] = new JLabel("Puisance d'attaque entre 280 et 430 PA"); 
            description_bouton[2] = new JLabel("Puisance d'attaque entre 400 et 600 PA"); 
            description_bouton[3] = new JLabel("Puisance d'attaque entre 650 et 800 PA"); 
            description_bouton[4] = new JLabel("Probabilité d'1/3 de faire 1000 PA contre 2/3 d'en faire 1"); 
            description_bouton[5] = new JLabel("Soigner les PV de 1300"); 
            for(int i=0; i< description_bouton.length; i++){
                description_bouton[i].setHorizontalAlignment(SwingConstants.CENTER);
                description_bouton[i].setFont(new Font("Arial", Font.BOLD, 12));
            }
            description_bouton[4].setAlignmentX(Component.CENTER_ALIGNMENT);
            description_bouton[5].setAlignmentX(Component.CENTER_ALIGNMENT);
            panel_description_1.add(description_bouton[0]); 
            panel_description_1.add(description_bouton[1]);
            panel_description_2.add(description_bouton[2]); 
            panel_description_2.add(description_bouton[3]);   
        JPanel panel_bouton_principal = new JPanel();
            panel_bouton_principal.setLayout(new BoxLayout(panel_bouton_principal, BoxLayout.Y_AXIS));
            panel_bouton_principal.setBackground(c[0]);
            panel_bouton_principal.add(choix_attaque); 
            panel_bouton_principal.add(Box.createRigidArea(new Dimension(0, 20)));
            panel_bouton_principal.add(panel_description_1);
            panel_bouton_principal.add(panel_bouton1); 
            panel_bouton_principal.add(Box.createRigidArea(new Dimension(0, 10)));
            panel_bouton_principal.add(panel_description_2);
            panel_bouton_principal.add(panel_bouton2); 
            panel_bouton_principal.add(Box.createRigidArea(new Dimension(0, 15)));
        panel_centre.add(panel_bouton_principal, BorderLayout.SOUTH);
        JPanel panel_attaque_spéciale = new JPanel();
            panel_attaque_spéciale.setLayout(new BoxLayout(panel_attaque_spéciale, BoxLayout.Y_AXIS));
            panel_attaque_spéciale.setBackground(c[0]);
            panel_attaque_spéciale.add(description_bouton[4]);
            panel_attaque_spéciale.add(attaque[4]);
            panel_attaque_spéciale.add(Box.createRigidArea(new Dimension(0, 10)));
            panel_attaque_spéciale.add(description_bouton[5]); 
            panel_attaque_spéciale.add(attaque[5]); 
            panel_attaque_spéciale.add(Box.createRigidArea(new Dimension(0, 15)));
            attaque[4].setAlignmentX(Component.CENTER_ALIGNMENT);
            attaque[4].setAlignmentY(Component.CENTER_ALIGNMENT);
            attaque[5].setAlignmentX(Component.CENTER_ALIGNMENT);
            attaque[5].setAlignmentY(Component.CENTER_ALIGNMENT);
        panel_est.add(panel_attaque_spéciale, BorderLayout.SOUTH);
        
        //ANIMATION D'ATTAQUE; 
        gif = new JLabel(""); 
        gif.setVerticalAlignment(SwingConstants.CENTER);
        gif.setHorizontalAlignment(SwingConstants.CENTER);
        animation = new Image[6]; 
        int t=5; 
        imageIcon = new ImageIcon("src/main/java/Attaque/coup_poing.gif"); 
        Image image1 = imageIcon.getImage().getScaledInstance(54*t, 61*t, Image.SCALE_DEFAULT);
            animation[0] = image1;
        imageIcon = new ImageIcon("src/main/java/Attaque/lance_flamme.gif"); 
        Image image2 = imageIcon.getImage().getScaledInstance(81*t, 62*t, Image.SCALE_DEFAULT);
            animation[1] = image2; 
        imageIcon = new ImageIcon("src/main/java/Attaque/plante_feroce.gif"); 
        Image image3 = imageIcon.getImage().getScaledInstance(57*t, 88*t, Image.SCALE_DEFAULT);
            animation[2] = image3; 
        imageIcon = new ImageIcon("src/main/java/Attaque/double_lance_flamme.gif"); 
        Image image4 = imageIcon.getImage().getScaledInstance(121*t, 72*t, Image.SCALE_DEFAULT);
            animation[3] = image4; 
        imageIcon = new ImageIcon("src/main/java/Attaque/vomi.gif"); 
        Image image5 = imageIcon.getImage().getScaledInstance(76*t, 88*t, Image.SCALE_DEFAULT);
            animation[4] = image5; 
        imageIcon = new ImageIcon("src/main/java/Attaque/soin.gif"); 
        Image image6 = imageIcon.getImage().getScaledInstance(43*6, 65*6, Image.SCALE_DEFAULT);
            animation[5] = image6; 
        panel_animation = new JPanel(new GridLayout(1, 1)); 
        panel_animation.setBackground(c[0]);
        panel_animation.add(gif); 
        panel_centre.add(panel_animation, BorderLayout.CENTER); 
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(c[0]);
        getContentPane().add(panel_ouest, BorderLayout.WEST); 
        getContentPane().add(panel_est, BorderLayout.EAST); 
        getContentPane().add(panel_nord, BorderLayout.NORTH); 
        getContentPane().add(panel_centre, BorderLayout.CENTER); 
        
        Bouton(); 
    }
    public void Bouton(){
        abandonner.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               new Ecran_Monstre().setVisible(true);
               setVisible(false); 
            }
        }); 
        attaque[0].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                num_attaque = 0; 
                gif.setIcon(new ImageIcon(animation[0]));
                Desactivation_Bouton(); 
                int duree = 2060; 
                Timer time = new Timer(duree, Desactivation_animation); //17 images de 60 frames;
                time.setRepeats(false);
                time.start();
            }
        }); 
        attaque[1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                num_attaque = 1;
                gif.setIcon(new ImageIcon(animation[1]));
                Desactivation_Bouton(); 
                int duree = 3600; 
                Timer time = new Timer(duree, Desactivation_animation); //27 images de 60 frames;
                time.setRepeats(false);
                time.start();
            }
        }); 
        attaque[2].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                num_attaque = 2;
                gif.setIcon(new ImageIcon(animation[2]));
                Desactivation_Bouton(); 
                int duree = 3200; 
                Timer time = new Timer(duree, Desactivation_animation); //25 images de 60 frames;
                time.setRepeats(false);
                time.start();
            }
        }); 
        attaque[3].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                num_attaque = 3;
                gif.setIcon(new ImageIcon(animation[3]));
                Desactivation_Bouton(); 
                int duree = 3500; 
                Timer time = new Timer(duree, Desactivation_animation); //26 images de 60 frames;
                time.setRepeats(false);
                time.start();
            }
        }); 
        attaque[4].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                num_attaque = 4;
                gif.setIcon(new ImageIcon(animation[4]));
                Desactivation_Bouton(); 
                int duree = 2890; 
                Timer time = new Timer(duree, Desactivation_animation); //24 images de 60 frames;
                time.setRepeats(false);
                time.start();
            }
        }); 
        attaque[5].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                num_attaque = 5;
                gif.setIcon(new ImageIcon(animation[5]));
                Desactivation_Bouton(); 
                int duree = 3000; 
                Timer time = new Timer(duree, Soin); //24 images de 60 frames;
                time.setRepeats(false);
                time.start();
            }
        }); 
        accueil.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Ecran_Accueil().setVisible(true);
                setVisible(false); 
            }
        }); 
    }
    public void Desactivation_Bouton(){
        for(int i=0; i<attaque.length; i++){
            attaque[i].setEnabled(false); 
        }
        choix_attaque.setVisible(false);
    }
    ActionListener Soin = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            heros.AugmenterPV();
            gif.setText("Augmentation des PV : 1300");
            gif.setFont(new Font("Arial", Font.BOLD, 30));
            gif.setForeground(Color.GREEN);
            gif.setIcon(new ImageIcon());
            pv_h.setText("PV : " + heros.getPV());
            DefinirVitaliteHeros(); 
            Timer time = new Timer(3000, AfficherLeTourDuMonstre); 
                 time.setRepeats(false);
                 time.start();
        }
    }; 
    ActionListener Desactivation_animation = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            Heros h = new Heros(); 
            int nb = h.getPuissanceAttaque(num_attaque); 
            if(nb >= 3000){
                gif.setText("Coup critique : - " + nb);
            }else{
                gif.setText("Puissance de l'attaque choisis : - " + nb);
            }
            gif.setFont(new Font("Arial", Font.BOLD, 30));
            gif.setForeground(Color.RED);
            gif.setIcon(new ImageIcon(""));
            monstre.Attaque_Subit(nb); 
            pv_m.setText("PV : " + monstre.getPV()); 
            DefinirVitaliteMonstre(); 
             //PASSER A L'ACTION SUIVANTE; 
            if(monstre.getPV() > 0){
                 Timer time = new Timer(3000, AfficherLeTourDuMonstre); 
                 time.setRepeats(false);
                 time.start();
            }else{
                Timer time = new Timer(3000, VICTOIRE); 
                time.setRepeats(false);
                time.start();
            }
        }
    };
    ActionListener AfficherLeTourDuMonstre = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            gif.setText("C'est au tour du monstre d'attaquer");
            gif.setFont(new Font("Arial", Font.BOLD, 25));
            gif.setForeground(Color.BLACK);
            //PASSER A L'ACTION SUIVANTE; 
            Timer time = new Timer(3000, AttaqueDuMonstre); 
            time.setRepeats(false);
            time.start();
      }  
    };
    ActionListener AttaqueDuMonstre = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            int attaque = monstre.getAttaqueMonstre(); 
            gif.setText("Puissance d'attaque du monstre: - " + attaque);
            gif.setFont(new Font("Arial", Font.BOLD, 30));
            gif.setForeground(Color.RED);
            heros.Attaque_Subit(attaque);
            pv_h.setText("PV : " + heros.getPV());
            DefinirVitaliteHeros(); //CHANGER L'Image des PV; 
            //PASSER A L'ACTION SUIVANTE; 
            if(heros.getPV() > 0){
                 Timer time = new Timer(4000, Activation_Bouton); 
                 time.setRepeats(false);
                 time.start();
            }else{
                Timer time = new Timer(3000, DEFAITE); 
                time.setRepeats(false);
                time.start();
            }            
      }  
    };
    ActionListener Activation_Bouton = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            for(int i=0; i<attaque.length; i++){
                attaque[i].setEnabled(true);
            }
            gif.setText("");
            choix_attaque.setVisible(true);
        }
    };
    ActionListener VICTOIRE = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            getContentPane().removeAll();
            setVisible(false); 
            setSize(600, 600); 
            Color cc = Color.decode("#297444"); 
            ImageIcon imageIcon = new ImageIcon("src/main/java/Ecran_Combat/victoire.gif"); 
            Image image = imageIcon.getImage().getScaledInstance(37*6, 11*6, Image.SCALE_DEFAULT);
            JLabel victoire = new JLabel(new ImageIcon(image)); 
            JPanel panel_nord = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
                panel_nord.setBackground(cc);
                panel_nord.add(victoire); 
            JPanel panel_sud = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
                panel_sud.setBackground(cc);
                panel_sud.add(accueil); 
            JPanel panel_centre = new JPanel(new GridLayout(1, 1)); 
                panel_centre.setBackground(cc);
                imageIcon = new ImageIcon("src/main/java/Ecran_Combat/victoire.png"); 
                image = imageIcon.getImage().getScaledInstance(81*5, 61*5, Image.SCALE_DEFAULT);
                JLabel Im_victoire = new JLabel(new ImageIcon(image)); 
                Im_victoire.setHorizontalAlignment(SwingConstants.CENTER);
                Im_victoire.setVerticalAlignment(SwingConstants.CENTER);
            panel_centre.add(Im_victoire); 
            getContentPane().add(panel_nord, BorderLayout.NORTH); 
            getContentPane().add(panel_centre, BorderLayout.CENTER); 
            getContentPane().add(panel_sud, BorderLayout.SOUTH); 
            getContentPane().setBackground(cc);
            setVisible(true);
            setLocationRelativeTo(null);
        }
    };
    ActionListener DEFAITE = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            getContentPane().removeAll();
            setVisible(false); 
            setSize(600, 600); 
            Color cc = Color.decode("#297444"); 
            ImageIcon imageIcon = new ImageIcon("src/main/java/Ecran_Combat/defaite.gif"); 
            Image image = imageIcon.getImage().getScaledInstance(37*6, 11*6, Image.SCALE_DEFAULT);
            JLabel victoire = new JLabel(new ImageIcon(image)); 
            JPanel panel_nord = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
                panel_nord.setBackground(cc);
                panel_nord.add(victoire); 
            JPanel panel_sud = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
                panel_sud.setBackground(cc);
                panel_sud.add(accueil); 
            JPanel panel_centre = new JPanel(new GridLayout(1, 1)); 
                panel_centre.setBackground(cc);
                imageIcon = new ImageIcon("src/main/java/Ecran_Combat/defaite.png"); 
                image = imageIcon.getImage().getScaledInstance(125*4, 61*4, Image.SCALE_DEFAULT);
                JLabel Im_defaite = new JLabel(new ImageIcon(image)); 
                Im_defaite.setHorizontalAlignment(SwingConstants.CENTER);
                Im_defaite.setVerticalAlignment(SwingConstants.CENTER);
            panel_centre.add(Im_defaite); 
            getContentPane().add(panel_nord, BorderLayout.NORTH); 
            getContentPane().add(panel_centre, BorderLayout.CENTER); 
            getContentPane().add(panel_sud, BorderLayout.SOUTH); 
            getContentPane().setBackground(cc);
            setVisible(true); 
            setLocationRelativeTo(null);
        }
    };
    
    public void DefinirVitaliteMonstre(){
        int m = monstre.getPV();
        if(m<= 3000 && m>2500){
            vitalite_m.setIcon(new ImageIcon(vie[1]));
        }else if(m<=2500 && m >2000){
            vitalite_m.setIcon(new ImageIcon(vie[2]));
        }else if(m<=2000 && m >1500){
            vitalite_m.setIcon(new ImageIcon(vie[3])); 
        }else if(m<=1500 && m >1000){
            vitalite_m.setIcon(new ImageIcon(vie[4]));           
        }else if(m<=1000 && m >500){
            vitalite_m.setIcon(new ImageIcon(vie[5]));     
        }else if(m<=500 && m>0){
            vitalite_m.setIcon(new ImageIcon(vie[6]));      
        }else if(m<=0){
            vitalite_m.setIcon(new ImageIcon(vie[7]));     
        }
    }
    public void DefinirVitaliteHeros(){
        int h = heros.getPV();
        if(h <= 3000 && h > 2580){
            vitalite_h.setIcon(new ImageIcon(vie[0]));
        }
        else if(h<= 2580 && h>2150){
            vitalite_h.setIcon(new ImageIcon(vie[1]));
        }else if(h<=2150 && h >1720){
            vitalite_h.setIcon(new ImageIcon(vie[2]));
        }else if(h<=1720 && h >1290){
            vitalite_h.setIcon(new ImageIcon(vie[3])); 
        }else if(h<=1290 && h >860){
            vitalite_h.setIcon(new ImageIcon(vie[4]));           
        }else if(h<=860 && h >430){
            vitalite_h.setIcon(new ImageIcon(vie[5]));     
        }else if(h<=430 && h>0){
            vitalite_h.setIcon(new ImageIcon(vie[6]));      
        }else if(h<=0){
            vitalite_h.setIcon(new ImageIcon(vie[7])); 
        }
    }
}
