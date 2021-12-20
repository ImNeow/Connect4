import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class grille extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public void paintComponent(Graphics g) {
		Image img;
		try {
			img = ImageIO.read(new File("images/grille.png"));
			g.drawImage(img, 0, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
}
