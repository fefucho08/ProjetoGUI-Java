package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Icon extends JPanel {
	private int width;
	private int height;
	
	private Image image;
	
	public Icon() {
		this.width = 200;
		this.height = 200;
		
		image = Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/images/LogoFT.png"));
		
        setPreferredSize(new Dimension(width, height));
        setOpaque(false); // Make sure background is transparent
	}
	
	public Icon(int width, int height, Image image) {
		this.width = width;
		this.height = height;
		this.image = image;
	}
	
	@Override
	public void paintComponent(Graphics graphic) {
		super.paintComponent(graphic);
		
		graphic.setColor(Color.WHITE);
		graphic.fillRect(0, 0, this.width, this.height);
		
		if (image != null) {
            // Draw the image at (0, 0)
			graphic.drawImage(image, 0, 0, this);
        }
		//this.setBounds(0, 0, this.width, this.height);
	}
	
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
}
