import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class pionvic extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private int posx;
	private int posy;
	
	public void paintComponent(Graphics g) {
		g.fillOval(0, 0, 80, 80);
}
	
	public pionvic(int i,int j) {
			
		switch(j){
		
		case 0:
			posx=190;
			posy=227+(i*80);
			break;
		case 1:
			posx=280;
			posy=227+(i*80);
			break;
		case 2: 
			posx=370;
			posy=227+(i*80);
			break;
		case 3:
			posx=460;
			posy=227+(i*80);
			break;
		case 4:
			posx=550;
			posy=227+(i*80);
			break;
		case 5:
			posx=640;
			posy=227+(i*80);
			break;
		case 6 :
			posx=730;
			posy=227+(i*80);
			break;
		}
		
		
		this.setForeground(Color.white);
		this.setSize(80,80);
		this.setLocation(posx, posy);
		
		
	}	
}
