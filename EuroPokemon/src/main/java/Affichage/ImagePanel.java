package Affichage;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

class ImagePanel extends JPanel {
	 
    Image bg = new ImageIcon("resources/images/background.jpg").getImage();
    
    public ImagePanel() {
    	this.setLayout(null);
	}
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}
