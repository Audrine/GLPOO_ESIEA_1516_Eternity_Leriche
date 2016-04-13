package Affichage;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

class ImagePanel extends JPanel {
	 
    /**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	Image bg;
    
    public ImagePanel(String pathImage) {
    	this.setLayout(null);
    	bg = new ImageIcon(pathImage).getImage(); 
	}
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}
