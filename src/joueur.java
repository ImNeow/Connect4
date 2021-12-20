import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class joueur extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel container = new JPanel();
	private	JButton boutonRetour = new JButton(new ImageIcon("images/boutonRetour.png"));
	private JButton bouton1 = new JButton() ;
	private JTextField textfieldj1 = new JTextField();
	private JTextField textfieldj2 = new JTextField();
	private JLabel background = new JLabel(new ImageIcon("images/game_background.jpg"));
	private JLabel phrasej1 = new JLabel();
	private JLabel phrasej2 = new JLabel();
	private JLabel titre = new JLabel();
	private JLabel erreurcouleur = new JLabel();
	private JLabel erreurnom = new JLabel();
	private JLabel erreurnom2 = new JLabel();
	private JLabel erreurdiff = new JLabel();
	private String nomj1 =null;
	private String nomj2 =null;
	private Color nomcouleurj1 ; 
	private Color nomcouleurj2 ; 
	private JComboBox<?> CBcouleurj1 ; 
	private JComboBox<?> CBcouleurj2 ;
	private JButton diffez = new JButton();
	private JButton diffmoyen = new JButton();
	private JButton diffhard = new JButton();
	private JRadioButton IAvsIA = new JRadioButton();
	private int nbr;     //Nombre de joueur 
	private int diff=0;  //Difficulté
	
	public joueur(int nbrIA){
		nbr = nbrIA;

		
		this.setContentPane(container);
		this.setLayout(null);
	
		/*
		 * Parametre du bouton Retour
		 */
		
		boutonRetour.setBounds(10, 10, 50,50);
		boutonRetour.setBorder(null);
		boutonRetour.setContentAreaFilled(false);
		container.add(boutonRetour);
		boutonRetour.addActionListener(new ActionListener()
	    {
	        public void actionPerformed(ActionEvent ae)
	        {
	           
	        	JFrame Fenetre = new Fenetre() ;
	        	Fenetre.setSize(1000,750);
	    		Fenetre.setLocationRelativeTo(null);
	    		Fenetre.setResizable(false);
	    		
	    		dispose();
	        }
	    });
		
		
		/*
		 * Parametre Joueur1 
		 */
		

		//DEBUG  A SUPPRIMER
		textfieldj1.setText("J1");		
		
		textfieldj1.setBackground(Color.black);
		textfieldj1.setBounds(150, 280, 300, 75);
		textfieldj1.setBorder(null);
		textfieldj1.setForeground(Color.white);
		textfieldj1.setFont(new Font("Impact",Font.PLAIN,30));
		textfieldj1.setHorizontalAlignment(JTextField.CENTER);
		container.add(textfieldj1);
		
		phrasej1.setText("Joueur 1");
		phrasej1.setBounds(220, 205, 300, 75);
		phrasej1.setFont(new Font("Arial",Font.BOLD,40));
		phrasej1.setForeground(Color.white);
		container.add(phrasej1);
		
		/*
		 * Parametre Joueur2 
		 */
		
		if(nbr==1)
		{
			textfieldj2.setText("IA");
			textfieldj2.setEnabled(false);
		}
		
		//DEBUG A SUPPRIMER
		else if(nbr==2)
		{
			textfieldj2.setText("J2");
		}
		
		
		textfieldj2.setBounds(550, 280, 300, 75);
		textfieldj2.setBackground(Color.black);
		textfieldj2.setBorder(null);
		textfieldj2.setForeground(Color.white);
		textfieldj2.setFont(new Font("Impact",Font.PLAIN,30));
		textfieldj2.setHorizontalAlignment(JTextField.CENTER);
		container.add(textfieldj2);
		
		phrasej2.setText("Joueur 2");
		phrasej2.setBounds(620, 205, 300, 75);
		phrasej2.setFont(new Font("Arial",Font.BOLD,40));
		phrasej2.setForeground(Color.white);
		container.add(phrasej2);
		
		
		
		if(nbr==1)
		{
			/*
			 * LA CheckBox Choix de la difficulté
			 */		
			
			//DEBUG  diffhard =>diffez
			//diffhard.setSelected(true);
			
			diffez.setBounds(550, 480, 100, 50);
			diffez.setText("Facile");
			diffez.setFocusable(false);
			diffez.setBackground(Color.blue);
			diffez.setForeground(Color.white);
			diffez.setBorder(null);
			diffez.setFont(new Font("Tahoma",Font.BOLD,13));
			container.add(diffez); 
			diffez.addActionListener(new ActionListener()
		    {
		        public void actionPerformed(ActionEvent ae)
		        {
		        	
		        	if(diff==1) 
		        	{
		        		diff=0;
		        		diffez.setBackground(Color.blue);
						diffez.setBounds(550, 480, 100, 50);

		        	}
		        	else {

		        	diff=1;
		        	diffez.setBackground(new Color(102,178,255));
		        	diffmoyen.setBackground(Color.blue);
		        	diffhard.setBackground(Color.blue);
		        	
					diffez.setBounds(548, 478, 104, 54);
					diffmoyen.setBounds(650, 480, 100, 50);	
					diffhard.setBounds(750, 480, 100, 50);	
		        			        	
		        	}
		        }
		    });
			diffez.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	
					diffez.setBackground(new Color(78,78,255));

			    	}
			    public void mouseExited(MouseEvent e){
			    	if(diff==1)
			    	{
			        	diffez.setBackground(new Color(102,178,255));
			    	}
			    	else {
				    	diffez.setBackground(Color.blue);
			    	}			    	
			    	}
			});
			
			
			diffmoyen.setBounds(650, 480, 100, 50);	
			diffmoyen.setText("Moyen");
			diffmoyen.setFocusable(false);
			diffmoyen.setBackground(Color.blue);
			diffmoyen.setForeground(Color.white);
			diffmoyen.setBorder(null);
			diffmoyen.setFont(new Font("Tahoma",Font.BOLD,12));
			container.add(diffmoyen);
			diffmoyen.addActionListener(new ActionListener()
		    {
		        public void actionPerformed(ActionEvent ae)
		        {
		           
		        	if(diff==2) 
		        	{
		        		diff=0;
		        		diffmoyen.setBackground(Color.blue);
		    			diffmoyen.setBounds(650, 480, 100, 50);	

		        	}
		        	
		        	else
		        	{
			        	diff=2;
		        		diffez.setBackground(Color.blue);
			        	diffmoyen.setBackground(new Color(102,178,255));
			        	diffhard.setBackground(Color.blue);

						diffmoyen.setBounds(648, 478, 104, 54);	
						diffez.setBounds(550, 480, 100, 50);
						diffhard.setBounds(750, 480, 100, 50);	

		        	}
		        	
		        	
		        }
		    });
			diffmoyen.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	
					diffmoyen.setBackground(new Color(78,78,255));

			    	}
			    public void mouseExited(MouseEvent e){
			    	if(diff==2)
			    	{
			        	diffmoyen.setBackground(new Color(102,178,255));
			    	}
			    	else {
				    	diffmoyen.setBackground(Color.blue);
			    	}			    	}
			});
			
			diffhard.setBounds(750, 480, 100, 50);	
			diffhard.setText("Difficile");
			diffhard.setFocusable(false);
			diffhard.setBackground(Color.blue);
			diffhard.setForeground(Color.white);		
			diffhard.setForeground(Color.white);
			diffhard.setBorder(null);
			diffhard.setFont(new Font("Tahoma",Font.BOLD,13));
			container.add(diffhard);
			diffhard.addActionListener(new ActionListener()
		    {
		        public void actionPerformed(ActionEvent ae)
		        {
		        	
		        	if(diff==3) 
		        	{
		        		diff=0;
		        		diffhard.setBackground(Color.blue);
		    			diffhard.setBounds(750, 480, 100, 50);	

		        	}
		        	else {

		        	diff=3;
		        	diffez.setBackground(Color.blue);
		        	diffmoyen.setBackground(Color.blue);
		        	diffhard.setBackground(new Color(102,178,255));
		        	
					diffez.setBounds(550, 480, 100, 50);
	    			diffmoyen.setBounds(650, 480, 100, 50);	
					diffhard.setBounds(748, 478, 104, 54);	

		        	}
		        }
		    });
			diffhard.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	
					diffhard.setBackground(new Color(78,78,255));

			    	}
			    public void mouseExited(MouseEvent e){
			    	if(diff==3)
			    	{
			        	diffhard.setBackground(new Color(102,178,255));
			    	}
			    	else {
				    	diffhard.setBackground(Color.blue);
			    	}
			    	}
			});
			
			
			IAvsIA.setBounds(275, 490, 75, 50);
			IAvsIA.setText("IA");
			IAvsIA.setOpaque(false);
			IAvsIA.setForeground(Color.white);
			IAvsIA.setFont(new Font("Tahoma",Font.BOLD,15));
			container.add(IAvsIA); 
			
		}
		
		
		
		/*
		 * LES COMBOBOX Choix des Couleurs
		 */
		Object[] couleur = new Object[]{"Rouge","Jaune","Vert","Violet","Orange","Rose","Virus"};
		
		CBcouleurj1 = new JComboBox<Object>(couleur);
		CBcouleurj1.setBounds(175, 390, 250, 75);	
		CBcouleurj1.setBackground(Color.black);
		CBcouleurj1.setForeground(Color.white);
		CBcouleurj1.setFont(new Font("Arial",Font.BOLD,25));
		((JLabel)CBcouleurj1.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		container.add(CBcouleurj1);
		
		
		
		CBcouleurj2 = new JComboBox<Object>(couleur);
		CBcouleurj2.setSelectedIndex(1);
		CBcouleurj2.setBounds(575, 390, 250, 75);
		CBcouleurj2.setBackground(Color.black);
		CBcouleurj2.setForeground(Color.white);
		CBcouleurj2.setFont(new Font("Arial",Font.BOLD,25));
		((JLabel)CBcouleurj2.getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		container.add(CBcouleurj2);
		
		
		/*
		 * Parametre Titre
		 */
		
		titre.setText("Joueurs");
		titre.setBounds(380, 75, 700, 100);
		titre.setFont(new Font("Arial",Font.BOLD,60));
		titre.setForeground(Color.white);
		container.add(titre);
		
		/*
		 * Parametre Bouton Lancer
		 */
		
		bouton1.setForeground(Color.white);
		bouton1.setText("Lancer");         
		bouton1.setFont(new Font("Arial",Font.BOLD,40)); 
		bouton1.setBounds(350, 550, 300, 75); 
		bouton1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bouton1.setBackground(Color.blue);
		bouton1.setFocusable(false);
		bouton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bouton1.addActionListener(new BoutonGoListener());
		
		bouton1.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	
				bouton1.setBackground(new Color(78,78,255));

		    	}
		    public void mouseExited(MouseEvent e){
		    	bouton1.setBackground(Color.blue);
		    	}
		});
		
		container.add(bouton1);
		
		/*
		 * Parametre erreurcouleur
		 */
		erreurcouleur.setVisible(false);
		erreurcouleur.setText("Veuillez choisir une couleur différente !");
		erreurcouleur.setBounds(325, 150, 700, 100);
		erreurcouleur.setFont(new Font("Arial",Font.BOLD,20));
		erreurcouleur.setForeground(Color.red);
		container.add(erreurcouleur);
		
		/*
		 * Parametre erreurnom
		 */
		erreurnom.setVisible(false);
		erreurnom.setText("Veuillez entrer un nom !");
		erreurnom.setBounds(385, 150, 700, 100);
		erreurnom.setFont(new Font("Arial",Font.BOLD,20));
		erreurnom.setForeground(Color.red);
		container.add(erreurnom);
		
		/*
		 * Parametre erreurnom2
		 */
		erreurnom2.setVisible(false);
		erreurnom2.setText("Veuillez entrer un nom différent !");
		erreurnom2.setBounds(360, 150, 700, 100);
		erreurnom2.setFont(new Font("Arial",Font.BOLD,20));
		erreurnom2.setForeground(Color.red);
		container.add(erreurnom2);
		
		/*
		 * Parametre erreurdiff
		 */
		erreurdiff.setVisible(false);
		erreurdiff.setText("Veuillez choisir une difficulté !");
		erreurdiff.setBounds(360, 150, 700, 100);
		erreurdiff.setFont(new Font("Arial",Font.BOLD,20));
		erreurdiff.setForeground(Color.red);
		container.add(erreurdiff);
		
		/*
		 * Background
		 */
		background.setBounds(0, 0, 1000, 750);
		container.add(background);
		
	}
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * ActionListener du bouton Lancer
	 */
	class BoutonGoListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			nomj1 = textfieldj1.getText();
			nomj2 = textfieldj2.getText();	
				
			if(CBcouleurj1.getSelectedItem()=="Rouge")
			{
				nomcouleurj1 =Color.red;
			}
			else if(CBcouleurj1.getSelectedItem()=="Jaune")
			{
				nomcouleurj1 = Color.yellow;
			}
			else if(CBcouleurj1.getSelectedItem()=="Vert")
			{
				nomcouleurj1 =Color.green;
			}
			else if(CBcouleurj1.getSelectedItem()=="Orange")
			{
				nomcouleurj1 =Color.orange;
			}
			else if(CBcouleurj1.getSelectedItem()=="Violet")
			{
				nomcouleurj1 =Color.magenta;
			}
			else if(CBcouleurj1.getSelectedItem()=="Rose")
			{
				nomcouleurj1 =Color.pink;
			}
			else if(CBcouleurj1.getSelectedItem()=="Virus")
			{
				nomcouleurj1 =Color.black;  //Noir si le joueur 1 a choisi Virus
			}
			
						
			if(CBcouleurj2.getSelectedItem()=="Rouge")
			{
				nomcouleurj2 =Color.red;
			}
			else if(CBcouleurj2.getSelectedItem()=="Jaune")
			{
				nomcouleurj2 = Color.yellow;
			}
			else if(CBcouleurj2.getSelectedItem()=="Vert")
			{
				nomcouleurj2 =Color.green;
			}
			else if(CBcouleurj2.getSelectedItem()=="Orange")
			{
				nomcouleurj2 =Color.orange;
			}
			else if(CBcouleurj2.getSelectedItem()=="Violet")
			{
				nomcouleurj2 =Color.magenta;
			}
			else if(CBcouleurj2.getSelectedItem()=="Rose")
			{
				nomcouleurj2 =Color.pink;
			}
			else if(CBcouleurj2.getSelectedItem()=="Virus")
			{
				nomcouleurj2 =Color.black;  //Noir si le joueur 2 a choisi Virus
			}
					
			
			if(IAvsIA.isSelected()==true)
			{
				nbr=3;
			}	
			
			
			erreurcouleur.setVisible(false);
			erreurnom.setVisible(false);
			erreurnom2.setVisible(false);
			erreurdiff.setVisible(false);

			
			
			if(nomcouleurj1 == nomcouleurj2) 
			{	
				erreurcouleur.setVisible(true);
			}
			else if(nomcouleurj1 != nomcouleurj2) 
				{
					erreurcouleur.setVisible(false);
					if(textfieldj1.getText().isEmpty()==true||textfieldj2.getText().isEmpty()==true)
							{
								erreurnom.setVisible(true);
							}
					else if(nomj1.equals(nomj2))
					 		{	
								erreurnom2.setVisible(true);
					 		}
					else
					 		{
						 		if(diff==0 || nbr ==2 )
						 			{
						 				erreurdiff.setVisible(true);
						 			}
						 		if(diff!=0 || nbr == 2)
						 			{
						 				System.out.println("Difficulté choisi = "+diff);
								
								
						 				JFrame jeu = new jeu(nomj1,nomj2,nomcouleurj1,nomcouleurj2,nbr,diff);
						 				jeu.setVisible(true);
						 				jeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						 				jeu.setSize(1000,750);
						 				jeu.setLocationRelativeTo(null);
						 				jeu.setResizable(false);
								
						 				dispose();
						 			}
					 		}
				
			   }
			
			
			
		}
	}			
}
