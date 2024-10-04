package control;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Animation implements Runnable {
	protected int delay;          // interval between frames in millisec
	protected int offset;         // distance moved between two frames
	
	protected int width;
	protected int height;
	protected int quantity;
	
	protected Thread banner;
	
	protected List<JPanel> icons;
	
	public Animation(int width, int height, JPanel icon, int quantity) {
		delay = 1000;
		offset = 1;
		this.width = width;
		this.height = height;
		this.quantity = quantity;
		
		icons = new ArrayList<JPanel>(Collections.nCopies(quantity, icon));
	}
	
	@Override
	public void run() {
		System.out.println("Starting thread...");
		
		Thread animationThread = new Thread(() -> {
			icons.forEach((icon) -> {
				int startDelay = ((int)(Math.random() * 10) + 1) * 1000;
				
				System.out.println("Delay: " + startDelay);
				
				Timer timer = new Timer(startDelay, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Update icon");
						updateIcon(icon);
					}
				});
				
				System.out.println("Starting timer");
				timer.setRepeats(false);
				timer.start();
			});
		});
		
		animationThread.start();
	}
	
	public void updateIcon(JPanel icon) {
		int updatedWidth = this.width / this.quantity;
		
		System.out.println("Width: " + updatedWidth);
		
		Timer timer = new Timer(0, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					int y = icon.getY();
					
					System.out.println("y: " + y);
					
					int updatedHeight = y - 5;
					
					if (updatedHeight <= 0) {
						updatedHeight = height;
					}
					
					icon.setBounds(updatedWidth, updatedHeight, icon.getWidth(), icon.getHeight());
					icon.repaint();
				});
				
				try {
		            Thread.sleep(50); // Adjust as necessary
		        } catch (InterruptedException ex) {
		            ex.printStackTrace();
		        }
			}
		});	
		
		timer.start();
		timer.setRepeats(true);
	}
}
