import java.awt.Color;

import javax.swing.JFrame;

public class Restart {

	public Restart(String nomj1, String nomj2, Color nomcouleurj1, Color nomcouleurj2, int nbr, int diff) {
		
		
		
		JFrame jeu = new jeu(nomj1,nomj2,nomcouleurj1,nomcouleurj2,nbr,diff);
		jeu.setVisible(true);
		jeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jeu.setSize(1000,750);
		jeu.setLocationRelativeTo(null);
		jeu.setResizable(false);
	
		
	}

}
