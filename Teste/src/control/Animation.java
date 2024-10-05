package control;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import view.Icon;

public class Animation implements Runnable {
	protected int delay;          // interval between frames in millisec
	protected int offset;         // distance moved between two frames
	
	protected int width;
	protected int height;
	
	protected Thread animationThread;
	protected JLayeredPane targetContainer;
	
	protected List<Icon> icons;
	protected Icon modelIcon;
	
	public Animation(
		int width, 
		int height, 
		JLayeredPane targetContainer,
		Icon icon
	) {
		delay = 1000;
		offset = 10;
		
		this.icons = new ArrayList<>();
		
		this.width = width;
		this.height = height;
		
		this.modelIcon = icon;
		this.targetContainer = targetContainer;
	}
	
	@Override
	public void run() {
		animationThread = new Thread(() -> {
			int positionX = (int)(width / modelIcon.getWidth());
			
			for (int i = 0; i < positionX; i++) {
				try {
					Icon cloned = (Icon)modelIcon.clone();
					icons.add(cloned);
					
					int startDelay = ((int)(Math.random() * 3) + 1) * 1000;
					
					cloned.setBounds(
						cloned.getWidth() * i, 
						this.height, 
						cloned.getWidth(), 
						cloned.getHeight()
					);
					
					targetContainer.add(cloned, JLayeredPane.DEFAULT_LAYER);
					
					Timer timer = new Timer(startDelay, new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							updateIcon(cloned);
						}
					});
					
					timer.setRepeats(false);
					timer.start();
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
			}
		});
		
		animationThread.start();
	}
	
	public void updateIcon(JPanel icon) {
		Timer timer = new Timer(0, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					int y = icon.getY();
					
					int updatedHeight = y - 10;
					
					if (updatedHeight <= 0) {
						updatedHeight = height;
					}
					
					icon.setBounds(icon.getX(), updatedHeight, icon.getWidth(), icon.getHeight());
					icon.repaint();
				});
				
				try {
		            Thread.sleep(5); // Adjust as necessary
		        } catch (InterruptedException ex) {
		            ex.printStackTrace();
		        }
			}
		});	
		
		timer.start();
		timer.setRepeats(true);
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setWidth(int width) {
		this.width = width;
		this.restart();
	}
	
	private void restart() {
		for (Icon icon : icons) {
			//System.out.print("Removing");
			targetContainer.remove(icon);
		}
		
		animationThread.interrupt();
		icons = new ArrayList<>();
		this.run();
	}
}
