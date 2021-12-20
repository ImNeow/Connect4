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

public class Fenetre  extends JFrame {

	private static final long serialVersionUID = 1;
	private JPanel container = new JPanel();
	private JButton bouton1 = new JButton() ;
	private JButton bouton2 = new JButton();
	private JButton boutonQuit = new JButton() ; 
	private JLabel logo = new JLabel(new ImageIcon("images/logo.png"));
	private JLabel background = new JLabel(new ImageIcon("images/background.jpg"));
	private JLabel credit = new JLabel();
	
	public Fenetre() {
			
		/*
		 * Paramêtre du container Menu
		 */
		
		container.setLayout(null);
		container.setSize(1000, 750);
		
		/*
		 * Parametre du Logo
		 */
			logo.setBounds(150, 50, 700, 350);
			container.add(logo);
			
		
		/*
		 * Paramêtre du  bouton Joueur contre Joueur
		 */
		bouton1.setForeground(Color.white);
		bouton1.setText("Joueur Contre Joueur");         
		bouton1.setFont(new Font("Arial",Font.BOLD,20)); 
		bouton1.setBounds(350, 350, 300, 75); 
		bouton1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bouton1.setBackground(Color.red);
		bouton1.setFocusable(false);
		bouton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bouton1.addActionListener(new ActionListener()
	    {
	        public void actionPerformed(ActionEvent ae)
	        {
	        	setVisible(false);			
				JFrame joueur = new joueur(2);
				joueur.setVisible(true);
				joueur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				joueur.setSize(1000,750);
				joueur.setLocationRelativeTo(null);
				joueur.setResizable(false);
	        }
	    });
		bouton1.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	
				bouton1.setBackground(new Color(255,78,78));

		    	}
		    public void mouseExited(MouseEvent e){
		    	bouton1.setBackground(Color.red);
		    	}
		});
	        
		container.add(bouton1);                         
		
		/*
		 * Paramêtre du bouton Joueur contre Ordinateur
		 */

		bouton2.setForeground(Color.white);
		bouton2.setText("Joueur Contre Ordinateur");         
		bouton2.setFont(new Font("Arial",Font.BOLD,20)); 
		bouton2.setBounds(350, 450, 300, 75); 
		bouton2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		bouton2.setBackground(Color.red);		
		bouton2.setFocusable(false);
		bouton2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		bouton2.addActionListener(new ActionListener()
	    {
	        public void actionPerformed(ActionEvent ae)
	        {
	        	setVisible(false);			
				JFrame joueur = new joueur(1);
				joueur.setVisible(true);
				joueur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				joueur.setSize(1000,750);
				joueur.setLocationRelativeTo(null);
				joueur.setResizable(false);
	        }
	    });
		bouton2.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	
				bouton2.setBackground(new Color(255,78,78));

		    	}
		    public void mouseExited(MouseEvent e){
		    	bouton2.setBackground(Color.red);
		    	}
		});
		container.add(bouton2); 
			
		/*
		 * Paramêtre du bouton Quitter
		 */
		boutonQuit.setForeground(Color.white);
		boutonQuit.setText("Quitter");         
		boutonQuit.setFont(new Font("Arial",Font.BOLD,20)); 
		boutonQuit.setBounds(350, 550, 300, 75);
		boutonQuit.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		boutonQuit.setBackground(Color.red);
		boutonQuit.setFocusable(false);
		boutonQuit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boutonQuit.addActionListener(new ActionListener()
	    {
	        public void actionPerformed(ActionEvent ae)
	        {
				System.exit(1);
	        }
	    });	
		boutonQuit.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	
				boutonQuit.setBackground(new Color(255,78,78));

		    	}
		    public void mouseExited(MouseEvent e){
		    	boutonQuit.setBackground(Color.red);
		    	}
		});
		container.add(boutonQuit); 
		
		
		/*
		 * Parametre du credit 
		 */
		
		credit.setVisible(true);
		credit.setText("crée par Tommy Riquet");
		credit.setBounds(10, 650, 200, 100);
		container.add(credit);
		/*
		 * Parametre du background
		 */
		background.setBounds(0, 0, 1000, 750);
		container.add(background);
		
		/*
		 * Parametre de la fenêtre 
		 */
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setVisible(true);
			this.setContentPane(container);
		
		
		/*
		 * FIN DU JPANEL CONTAINER MENU
		 */
		
		/////////////////////////////////////////////////////////////////////////////////////////////

	} 
}

