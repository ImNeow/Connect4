import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class pion extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private int posx;
	private int posy;
	private Color couleur;
	
	public void paintComponent(Graphics g) {
		
		g.fillOval(0, 0, 70, 70);

		
		if(couleur==Color.black)
		try {
		      Image img = ImageIO.read(new File("images/virus.png"));
		      g.drawImage(img, 0, 0, this);
		    } catch (IOException e) {
		    } 
}
	
	public pion(int nbrcol, int comptcol1, int comptcol2, int comptcol3, int comptcol4, int comptcol5, int comptcol6, int comptcol7) {
		
		
		switch(nbrcol){
			
		case 1:
			posx=195;
			posy=632-(comptcol1*80);
			break;
		case 2:
			posx=285;
			posy=632-(comptcol2*80);
			break;
		case 3: 
			posx=375;
			posy=632-(comptcol3*80);
			break;
		case 4:
			posx=465;
			posy=632-(comptcol4*80);
			break;
		case 5:
			posx=555;
			posy=632-(comptcol5*80);
			break;
		case 6:
			posx=645;
			posy=632-(comptcol6*80);
			break;
		case 7 :
			posx=735;
			posy=632-(comptcol7*80);
			break;
		}
		
		this.setLocation(posx,posy);
		
	}	
}
