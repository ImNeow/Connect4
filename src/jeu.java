import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


public class jeu extends JFrame {

	private static final long serialVersionUID = 1L;
	
 	private JPanel container = new container();
	private JPanel grille = new grille();
	private JPanel rond = new rond();
	private	JButton col1 = new JButton();
	private	JButton col2 = new JButton();
	private	JButton col3 = new JButton();
	private	JButton col4 = new JButton();
	private	JButton col5 = new JButton();
	private	JButton col6 = new JButton();
	private	JButton col7 = new JButton();
	private	JButton boutonRetour = new JButton(new ImageIcon("images/boutonRetour.png"));
	private	JButton boutonRestart = new JButton(new ImageIcon("images/boutonRestart.png"));
	private	JButton boutonFinRetour = new JButton();
	private	JButton boutonFinRestart = new JButton();
	private JLabel nomJoueur = new JLabel();
	public int tableaunbr[][]= new int[6][7];
	private int comptcol1;
	private int comptcol2;
	private int comptcol3;
	private int comptcol4;
	private int comptcol5;
	private int comptcol6;
	private int comptcol7;
	private int TourJoueur=1 ;	//Tour du joueur
	private int compt=0;   //Compteur aléatoire de l'IA
	private int nbrcol = 0;  //Numéro de la colonne choisie
	private int nbIA;			//IA active ou non => 1 ,IA active /2 , IA inactive
	private int vic;        //Y a t'il victoire ou non

	
		public jeu(String nomj1, String nomj2, Color nomcouleurj1, Color nomcouleurj2,int nbr,int diff) 
		{			
			 nbIA = nbr;
				
			/*
			 * Parametre du CONTAINER
			 */
			container.setVisible(true);
			container.setLayout(null);
			this.setContentPane(container);		
			
			/*
			 * Tour joueur Titre
			 */
			nomJoueur.setFont(new Font("Impact",Font.PLAIN,42));
			nomJoueur.setHorizontalAlignment(JLabel.CENTER);
			nomJoueur.setBounds(0, 20, 1000, 100);
			container.add(nomJoueur);
			
     	   Tourjoueur(nomj1, nomj2, nomcouleurj1, nomcouleurj2); //Appel de la fonction Tourjoueur, qui affiche tous d'abord le nom de J1
     	   
		           
			/*
			 * Parametre du bouton Retour
			 */
			boutonRetour.setBounds(925, 10, 50,50);
			boutonRetour.setBorder(new EtchedBorder(EtchedBorder.RAISED));
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
			 * Parametre du bouton Restart
			 */
			
			boutonRestart.setBounds(860, 10, 50,50);
			boutonRestart.setBorder(new EtchedBorder(EtchedBorder.RAISED));
			boutonRestart.setContentAreaFilled(false);
			container.add(boutonRestart);
			boutonRestart.addActionListener(new ActionListener()
		    {
		        public void actionPerformed(ActionEvent ae)
		        {
		           
		        	@SuppressWarnings("unused")
					Restart restart = new Restart(nomj1,nomj2,nomcouleurj1,nomcouleurj2,nbr,diff);
		    		
		    		
		    		dispose();
		        }
		    });
			
			
			
			container.add(rond);
			rond.setBackground(null);
			rond.setOpaque(false);
			
			/*
			 * Parametre des JButton reprensentant les colonnes 
			 */
			container.add(col1);
			col1.setFocusable(false);
			col1.setContentAreaFilled(false);
			col1.setBorderPainted(false);
			col1.setBounds(180,140, 90, 570);
			col1.setOpaque(false);
			col1.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	
			    	rond.setBounds(180, 125, 90, 80);
			    	rond.setVisible(true);
			    	
			    	if(TourJoueur==0) {
				        rond.setForeground(nomcouleurj1);
			    	}
			    	if(TourJoueur==1) {
				        rond.setForeground(nomcouleurj2);
			    	}
			    	}
			    public void mouseExited(MouseEvent e){
			    	
			    	}
			    public void mousePressed(MouseEvent e){
			    	
			    	if(TourJoueur==0 && nbIA == 2) {
				        rond.setForeground(nomcouleurj2);
			    	}
			    	if(TourJoueur==1) {
				        rond.setForeground(nomcouleurj1);
			    	}
			    	
			    	}
			});
			col1.addActionListener(new ActionListener()
		    {
		        public void actionPerformed(ActionEvent ae)
		        {	
		        						           
		           nbrcol = 1;
		           		           
		           if(comptcol1<6) {
		        	   Tourjoueur(nomj1, nomj2, nomcouleurj1, nomcouleurj2);
		        	   setPions(nomcouleurj1, nomcouleurj2);
		        	   tableauP4();
			           comptcol1++;
			           victoire(nomj2,nomj1,nomcouleurj1,nomcouleurj2,nbr,diff);
			           
			           if(vic==0) { 
		        	   IA(diff);
		        	   victoire(nomj2,nomj1,nomcouleurj1,nomcouleurj2,nbr,diff);
			           }
		           }
		        }
		    });
			
			
			container.add(col2);
			col2.setFocusable(false);
			col2.setContentAreaFilled(false);
			col2.setBorderPainted(false);
			col2.setBounds(270,140, 90, 570);
			col2.setForeground(Color.lightGray);
			col2.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	rond.setBounds(270, 125, 90, 80);
			    	rond.setVisible(true);
			    	
			    	if(TourJoueur==0) {
				        rond.setForeground(nomcouleurj1);
			    	}
			    	if(TourJoueur==1) {
				        rond.setForeground(nomcouleurj2);
			    	}
			    	}
			    public void mouseExited(MouseEvent e){
			    	
			    	}
			    public void mousePressed(MouseEvent e){
			    	
			    	if(TourJoueur==0 && nbIA == 2) {
				        rond.setForeground(nomcouleurj2);
			    	}
			    	if(TourJoueur==1) {
				        rond.setForeground(nomcouleurj1);
			    	}
			    	}
			});
			col2.addActionListener(new ActionListener()
		    {
		        public void actionPerformed(ActionEvent ae)
		        {
		        	
			         nbrcol = 2;			        
			         
			         if(comptcol2<6) 
			         {
			        	 Tourjoueur(nomj1, nomj2, nomcouleurj1, nomcouleurj2);
				         setPions(nomcouleurj1, nomcouleurj2);
				         tableauP4();
					     comptcol2++;
					     victoire(nomj2,nomj1,nomcouleurj1,nomcouleurj2,nbr,diff);
					     
				          if(vic==0) {
			        	 IA(diff);
			        	 victoire(nomj2,nomj1,nomcouleurj1,nomcouleurj2,nbr,diff);
				          }
				         }
		        }
		    });
			
			container.add(col3);
			col3.setFocusable(false);
			col3.setContentAreaFilled(false);
			col3.setBorderPainted(false);
			col3.setBounds(360, 140, 90, 570);
			col3.setForeground(Color.lightGray);
			col3.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	rond.setBounds(360, 125, 90, 80);
			    	rond.setVisible(true);
			    	
			    	if(TourJoueur==0) {
				        rond.setForeground(nomcouleurj1);
			    	}
			    	if(TourJoueur==1) {
				        rond.setForeground(nomcouleurj2);
			    	}
			    	}
			    public void mouseExited(MouseEvent e){
			    	
			    	}
			    public void mousePressed(MouseEvent e){
			    	
			    	if(TourJoueur==0 && nbIA == 2) {
				        rond.setForeground(nomcouleurj2);
			    	}
			    	if(TourJoueur==1) {
				        rond.setForeground(nomcouleurj1);
			    	}
			    	}
			});
			col3.addActionListener(new ActionListener()
		    {
		        public void actionPerformed(ActionEvent ae)
		        {
		        	
			           nbrcol = 3;
			           
			           if(comptcol3<6) 
			           {
			        	   Tourjoueur(nomj1, nomj2, nomcouleurj1, nomcouleurj2);
					       setPions(nomcouleurj1, nomcouleurj2);
					       tableauP4();
					       comptcol3++;
					       victoire(nomj2,nomj1,nomcouleurj1,nomcouleurj2,nbr,diff);	
					       
				           if(vic==0) {
					       IA(diff);
					       victoire(nomj2,nomj1,nomcouleurj1,nomcouleurj2,nbr,diff);
					       
				           }
			           }
		        }
		    });
			
			container.add(col4);
			col4.setFocusable(false);
			col4.setContentAreaFilled(false);
			col4.setBorderPainted(false);
			col4.setBounds(450, 140 ,90, 570);
			col4.setForeground(Color.lightGray);
			col4.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	rond.setBounds(450, 125, 90, 80);
			    	rond.setVisible(true);
			    	
			    	if(TourJoueur==0) {
				        rond.setForeground(nomcouleurj1);
			    	}
			    	if(TourJoueur==1) {
				        rond.setForeground(nomcouleurj2);
			    	}
			    	}
			    public void mouseExited(MouseEvent e){
			    	
			    	}
			    public void mousePressed(MouseEvent e){
			    	
			    	if(TourJoueur==0 && nbIA == 2) {
				        rond.setForeground(nomcouleurj2);
			    	}
			    	if(TourJoueur==1) {
				        rond.setForeground(nomcouleurj1);
			    	}
			    	}
			});
			col4.addActionListener(new ActionListener()
		    {
		        public void actionPerformed(ActionEvent ae)
		        {
			           nbrcol = 4;
			           
			           if(comptcol4<6) 
			           {
			        	   		Tourjoueur(nomj1, nomj2, nomcouleurj1, nomcouleurj2);
			        	   		setPions(nomcouleurj1, nomcouleurj2);
			        	   		tableauP4();
			        	   		comptcol4++;
						        victoire(nomj2,nomj1,nomcouleurj1,nomcouleurj2,nbr,diff);
						        
						         if(vic==0) {
					            IA(diff);
					            victoire(nomj2,nomj1,nomcouleurj1,nomcouleurj2,nbr,diff);
						         }
			           }
		        }
		    });
			
			container.add(col5);
			col5.setFocusable(false);
			col5.setContentAreaFilled(false);
			col5.setBorderPainted(false);
			col5.setBounds(540, 140, 90, 570);
			col5.setForeground(Color.lightGray);
			col5.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	rond.setBounds(540, 125, 90, 80);
			    	rond.setVisible(true);
			    	
			    	if(TourJoueur==0) {
				        rond.setForeground(nomcouleurj1);
			    	}
			    	if(TourJoueur==1) {
				        rond.setForeground(nomcouleurj2);
			    	}
			    	}
			    public void mouseExited(MouseEvent e){
			    	
			    	}
			    public void mousePressed(MouseEvent e){
			    	
			    	if(TourJoueur==0 && nbIA == 2) {
				        rond.setForeground(nomcouleurj2);
			    	}
			    	if(TourJoueur==1) {
				        rond.setForeground(nomcouleurj1);
			    	}
			    	}
			});
			col5.addActionListener(new ActionListener()
		    {
		        public void actionPerformed(ActionEvent ae)
		        {
		        	
			           nbrcol = 5;
			         
			           if(comptcol5<6) 
			           {
			        	   
				           Tourjoueur(nomj1, nomj2, nomcouleurj1, nomcouleurj2);
				           setPions(nomcouleurj1, nomcouleurj2);
				           tableauP4();
					       comptcol5++;
				           victoire(nomj2,nomj1,nomcouleurj1,nomcouleurj2,nbr,diff);	
				           
				           if(vic==0) {
				           IA(diff);
				           victoire(nomj2,nomj1,nomcouleurj1,nomcouleurj2,nbr,diff);
				           }
			           }
		        }
		    });
			
			container.add(col6);
			col6.setFocusable(false);			
			col6.setContentAreaFilled(false);
			col6.setBorderPainted(false);
			col6.setBounds(630, 140, 90, 570);
			col6.setForeground(Color.lightGray);
			col6.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	rond.setBounds(630, 125, 90, 80);
			    	rond.setVisible(true);
			    	
			    	if(TourJoueur==0) {
				        rond.setForeground(nomcouleurj1);
			    	}
			    	if(TourJoueur==1) {
				        rond.setForeground(nomcouleurj2);
			    	}
			    	}
			    public void mouseExited(MouseEvent e){
			    	
			    	}
			    public void mousePressed(MouseEvent e){
			    	
			    	if(TourJoueur==0 && nbIA == 2) {
				        rond.setForeground(nomcouleurj2);
			    	}
			    	if(TourJoueur==1) {
				        rond.setForeground(nomcouleurj1);
			    	}
			    	}
			});
			col6.addActionListener(new ActionListener()
		    {
		        public void actionPerformed(ActionEvent ae)
		        {
		        	
			           nbrcol = 6;
			           
			           
			           if(comptcol6<6) 
			           {
			        	   
				           Tourjoueur(nomj1, nomj2, nomcouleurj1, nomcouleurj2);
				           setPions(nomcouleurj1, nomcouleurj2);
				           tableauP4();	
				           comptcol6++;
				           victoire(nomj2,nomj1,nomcouleurj1,nomcouleurj2,nbr,diff);	
				           
				           if(vic==0) {
				           IA(diff);
				           victoire(nomj2,nomj1,nomcouleurj1,nomcouleurj2,nbr,diff);		
				           }
		        }
			           }
		    });
			
			container.add(col7);
			col7.setFocusable(false);
			col7.setContentAreaFilled(false);
			col7.setBorderPainted(false);
			col7.setBounds(720, 140, 90, 570);
			col7.setForeground(Color.lightGray);
			col7.addMouseListener(new java.awt.event.MouseAdapter() {
			    public void mouseEntered(java.awt.event.MouseEvent evt) {
			    	rond.setBounds(720, 125, 90, 80);
			    	rond.setVisible(true);
			    	
			    	if(TourJoueur==0) {
				        rond.setForeground(nomcouleurj1);
			    	}
			    	if(TourJoueur==1) {
				        rond.setForeground(nomcouleurj2);
			    	}
			    	}
			    public void mouseExited(MouseEvent e){
			    	
			    	}
			    public void mousePressed(MouseEvent e){
			    	
			    	if(TourJoueur==0 && nbIA == 2) {
				        rond.setForeground(nomcouleurj2);
			    	}
			    	if(TourJoueur==1) {
				        rond.setForeground(nomcouleurj1);
			    	}
			    	}
			});
			col7.addActionListener(new ActionListener()
		    {
		        public void actionPerformed(ActionEvent ae)
		        {
		        	
			           nbrcol = 7;			          
			         
			         if(comptcol7<6) 
			         {	        	  
				           Tourjoueur(nomj1, nomj2, nomcouleurj1, nomcouleurj2);
				           setPions(nomcouleurj1, nomcouleurj2);
				           tableauP4();
				           comptcol7++;
				           victoire(nomj2,nomj1,nomcouleurj1,nomcouleurj2,nbr,diff);	
				           
				           if(vic==0) {
				           IA(diff);
				           victoire(nomj2,nomj1,nomcouleurj1,nomcouleurj2,nbr,diff);	
				           }
				         }
		        }
		    });
			
			
			
			
			/*
			 * Parametre de la grille du puissance4
			 */
			grille.setLayout(null);
			grille.setBounds(180, 225, 630, 480);
			container.add(grille);
			
			
			
			 //DEBUG     ne pas laisser tourner trop longtemps car crach + IMPOSSIBLE A ARRETER   + ligne 879
			//col1.doClick();
			//DEBUG
			
		}
		

		/*	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		 * NOM DU JOUEUR
		 */	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

		public void Tourjoueur(String nomj1,String nomj2, Color nomcouleurj1, Color nomcouleurj2) 
		{

			if(TourJoueur==1) 
			{
				nomJoueur.setText(nomj1);
				nomJoueur.setForeground(nomcouleurj1);
				TourJoueur = TourJoueur-1;
			}
				
			else if(TourJoueur== 0) 
			{
				nomJoueur.setText(nomj2);
				nomJoueur.setForeground(nomcouleurj2);
				
				TourJoueur = TourJoueur+1;
			}				           
			
			
		}
		
		
		/*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		 * PIONS 
		 */	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

		
		public void setPions(Color nomcouleurj1, Color nomcouleurj2) {
			
			if(TourJoueur==1) 
			{
				
				JPanel pion = new pion(nbrcol,comptcol1,comptcol2,comptcol3,comptcol4,comptcol5,comptcol6,comptcol7);
				pion.setVisible(true);
				container.add(pion);
				pion.setForeground(nomcouleurj1);
				pion.setOpaque(false);
				pion.setSize(70, 70);
				}

			if(TourJoueur== 0) 
			{
				
				JPanel pion = new pion(nbrcol, comptcol1, comptcol2, comptcol3, comptcol4, comptcol5, comptcol6, comptcol7);
				pion.setVisible(true);
				container.add(pion);
				pion.setForeground(nomcouleurj2);	
				pion.setOpaque(false);
				pion.setSize(70, 70);
				
			}
			
			}
		
		
/*	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
* TABLEAU 
*/	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

		
		public void tableauP4()
		{
			int i,j;

			
			if(TourJoueur==1) {  //Joueur 1
				
				switch(nbrcol)
				{
				
				case 1:
					tableaunbr[5-comptcol1][0]=1;
					
					break;
				case 2:
					tableaunbr[5-comptcol2][1]=1;

					break;	
				case 3:
					tableaunbr[5-comptcol3][2]=1;

					break;
				case 4:
					tableaunbr[5-comptcol4][3]=1;

					break;
				case 5:
					tableaunbr[5-comptcol5][4]=1;

					break;
				case 6:
					tableaunbr[5-comptcol6][5]=1;

					break;
				case 7:
					tableaunbr[5-comptcol7][6]=1;

					break;
				}
			}

			if(TourJoueur==0) {  //Joueur 2
				
				switch(nbrcol)
				{
				
				case 1:
					tableaunbr[5-comptcol1][0]=2;

					break;
				case 2:
					tableaunbr[5-comptcol2][1]=2;

					break;	
				case 3:
					tableaunbr[5-comptcol3][2]=2;

					break;
				case 4:
					tableaunbr[5-comptcol4][3]=2;

					break;
				case 5:
					tableaunbr[5-comptcol5][4]=2;

					break;
				case 6:
					tableaunbr[5-comptcol6][5]=2;

					break;
				case 7:
					tableaunbr[5-comptcol7][6]=2;

					break;
				}
				
			}
			
			//Affichage du tableau dans la console
			
			for(i=0;i<6;i++)
			{
				for(j=0;j<7;j++) {
					System.out.print(tableaunbr[i][j]+" ");
				}
				System.out.println(" ");
			}
			System.out.println(" ");
		}
		
/*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
* IA
*//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
		public void IA(int diff){
			if(compt != 42)
			{
			if(TourJoueur == 1 && nbIA== 1 ) {
				compt++;
				@SuppressWarnings("unused")
				IA IA = new IA(tableaunbr,col1,col2,col3,col4,col5,col6,col7,diff,compt,nbIA);

			}
			if(nbIA == 3)
			{
				compt++;
				@SuppressWarnings("unused")
				IA IA = new IA(tableaunbr,col1,col2,col3,col4,col5,col6,col7,diff,compt,nbIA);
			}
			}
		}
		
		
/*/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
* VICTOIRE
*//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		public void victoire(String nomj2,String nomj1,Color nomcouleurj1,Color nomcouleurj2,int nbr,int diff) {
			int i,j;  //i=ligne    j=colonne
						
			for(i=0;i<6;i++)
			{
				for(j=0;j<7;j++)
				{
					
				if(tableaunbr[i][j]==1)
					{	
							//Victoire vertical J1
							if(vic == 0 && i<3 && tableaunbr[i+1][j]==1 && tableaunbr[i+2][j]==1 && tableaunbr[i+3][j]==1)
							{
										pionvic(i,j,i+1,j,i+2,j,i+3,j);
										System.out.println("Victoire J1");
										Fin(1,nomj1, nomj2, nomcouleurj1, nomcouleurj2, nbr,diff);
										vic=1;
							}

						
					
					
							//Victoire horizontal J1
							if(vic == 0 && j<4 && tableaunbr[i][j+1]==1 && tableaunbr[i][j+2]==1  && tableaunbr[i][j+3]==1)
							{
									pionvic(i,j,i,j+1,i,j+2,i,j+3);
									System.out.println("Victoire J1");									
									Fin(1,nomj1, nomj2, nomcouleurj1, nomcouleurj2, nbr,diff);
									vic=1;
							}

					
					
					
							//Victoire oblique J1
						
							if(vic == 0 && i<3 && j<4 && tableaunbr[i+1][j+1]==1 && j<5 && tableaunbr[i+2][j+2]==1 && tableaunbr[i+3][j+3]==1 )
							{
									pionvic(i,j,i+1,j+1,i+2,j+2,i+3,j+3);
									System.out.println("Victoire J1");
									Fin(1,nomj1, nomj2, nomcouleurj1, nomcouleurj2, nbr,diff);
									vic=1;
							}
						
						
							if(vic==0 && i>2 && j<4 &&tableaunbr[i-1][j+1]==1 && tableaunbr[i-2][j+2]==1  && tableaunbr[i-3][j+3]==1)
							{		
									pionvic(i,j,i-1,j+1,i-2,j+2,i-3,j+3);
									System.out.println("Victoire J1");
									Fin(1,nomj1, nomj2, nomcouleurj1, nomcouleurj2, nbr,diff);
									vic=1;
							}
					}
					
				
					if(vic== 0 && tableaunbr[i][j]==2)
						{	
							//Victoire vertical J2
							if(i<3 && tableaunbr[i+1][j]==2 && tableaunbr[i+2][j]==2 && tableaunbr[i+3][j]==2)
							{
										pionvic(i,j,i+1,j,i+2,j,i+3,j);
										System.out.println("Victoire J2");
										Fin(2,nomj1, nomj2, nomcouleurj1, nomcouleurj2, nbr,diff);
										vic=1;
							}

						
					
					
							//Victoire horizontal J2
							if(vic == 0 && j<4 && tableaunbr[i][j+1]==2 && tableaunbr[i][j+2]==2 && tableaunbr[i][j+3]==2)
							{
									pionvic(i,j,i,j+1,i,j+2,i,j+3);
									System.out.println("Victoire J2");
									Fin(2,nomj1, nomj2, nomcouleurj1, nomcouleurj2, nbr,diff);
									vic=1;
							}

					
					
					
							//Victoire oblique J2
							if( vic == 0 && i<3 && j<4 && tableaunbr[i+1][j+1]==2  && tableaunbr[i+2][j+2]==2 && tableaunbr[i+3][j+3]==2)
							{
									pionvic(i,j,i+1,j+1,i+2,j+2,i+3,j+3);
									System.out.println("Victoire J2");
									Fin(2,nomj1, nomj2, nomcouleurj1, nomcouleurj2, nbr,diff);
									vic=1;
							}

							if(vic == 0 && i>2 && j<4 && tableaunbr[i-1][j+1]==2 && tableaunbr[i-2][j+2]==2 && tableaunbr[i-3][j+3]==2)
							{		
									pionvic(i,j,i-1,j+1,i-2,j+2,i-3,j+3);
									System.out.println("Victoire J2");
									Fin(2,nomj1, nomj2, nomcouleurj1, nomcouleurj2, nbr,diff);
									vic=1;	
							}	
					
				}
			}
			}
			
			/*
			 * Defaite des deux joueurs
			 */
			
			if((comptcol1)+(comptcol2)+(comptcol3)+(comptcol4)+(comptcol5)+(comptcol6)+(comptcol7)==42) {
					
					//Renvoie 3 car pas de gagnants     :'(   
				
				Fin(3,nomj1, nomj2, nomcouleurj1, nomcouleurj2, nbr,diff);
				
				
			}
		
		}
		
		
		/*	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		 * FIN DU JEU
		 */	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

		public void Fin (int gagnant, String nomj1,String nomj2,Color nomcouleurj1,Color nomcouleurj2,int nbr,int diff) {
			
			rond.setVisible(false);
			
			col1.setEnabled(false);
			col1.setVisible(false);
			col2.setEnabled(false);
			col2.setVisible(false);
			col3.setEnabled(false);
			col3.setVisible(false);
			col4.setEnabled(false);
			col4.setVisible(false);
			col5.setEnabled(false);
			col5.setVisible(false);
			col6.setEnabled(false);
			col6.setVisible(false);
			col7.setEnabled(false);
			col7.setVisible(false);
			
			
			boutonRetour.setVisible(false);
			
			boutonFinRetour.setBounds(525, 140, 200,75);
			boutonFinRetour.setForeground(Color.white);
			boutonFinRetour.setBackground(Color.red);
			boutonFinRetour.setText("Retour au Menu");         
			boutonFinRetour.setFont(new Font("Arial",Font.BOLD,20)); 
			boutonFinRetour.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			boutonFinRetour.setFocusable(false);
			boutonFinRetour.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			container.add(boutonFinRetour);
			boutonFinRetour.addActionListener(new ActionListener()
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
			
			
			boutonRestart.setVisible(false);
			
			boutonFinRestart.setBounds(275, 140, 200,75);
			boutonFinRestart.setForeground(Color.white);
			boutonFinRestart.setText("Rejouer");         
			boutonFinRestart.setFont(new Font("Arial",Font.BOLD,20)); 
			boutonFinRestart.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			boutonFinRestart.setBackground(Color.red);
			boutonFinRestart.setFocusable(false);
			boutonFinRestart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			container.add(boutonFinRestart);
			boutonFinRestart.addActionListener(new ActionListener()
		    {
		        public void actionPerformed(ActionEvent ae)
		        {
		           
		        	@SuppressWarnings("unused")
					Restart restart = new Restart(nomj1,nomj2,nomcouleurj1,nomcouleurj2,nbr,diff);
		    		
		    		
		    		dispose();
		    		
		        }
		    });
			
			
			switch(gagnant)
			{
			case 1:
				nomJoueur.setText("Victoire de "+ nomj1);
				nomJoueur.setForeground(nomcouleurj1);
				break;		
			case 2:
				nomJoueur.setText("Victoire de "+ nomj2);
				nomJoueur.setForeground(nomcouleurj2);		
				break;
			case 3 :
				nomJoueur.setText("Egalité");
				nomJoueur.setForeground(Color.white);
				break;
			};
			
			
			//RESTART A L'INFINI
			//DEBUG + Doclick col1 ligne 488
			//boutonFinRestart.doClick();
			//DEBUG
		}
		
		
		 /*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
		 * MISE EN SURBRILLANCE DES PIONS EN CAS DE VICTOIRE 
		 */	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

		public void pionvic(int i1,int j1,int i2,int j2,int i3,int j3,int i4,int j4) {
					
			container.setSize(1000,750);

		        	JPanel pionvic1 = new pionvic(i1,j1);
					pionvic1.setVisible(true);
					container.add(pionvic1);
					
					JPanel pionvic2 = new pionvic(i2,j2);
					pionvic2.setVisible(true);
					container.add(pionvic2);
					
					JPanel pionvic3 = new pionvic(i3,j3);
					pionvic3.setVisible(true);
					container.add(pionvic3);
					
					JPanel pionvic4 = new pionvic(i4,j4);
					pionvic4.setVisible(true);
					container.add(pionvic4);
					
					container.add(grille);


		}
		
}


