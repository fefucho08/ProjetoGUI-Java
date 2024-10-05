package view;

import java.awt.*;

import javax.swing.JPanel;

import enums.Colors;
import enums.Speed;

public class AnimatedBackground extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Colors colors;
	private int backgroundColorIndex = 0;
	private Thread backgroundThread;
	private Thread starThread;
	private Speed backgroundSpeed;
	private Speed starSpeed;
	private boolean hasStar;
	private boolean rotatingStar;
	private double starAngle = 0;
	
	public AnimatedBackground() {
		backgroundThread = new Thread(this);
		starThread = new Thread(new StarRotator());
		backgroundSpeed = Speed.MEDIUM;
		starSpeed = Speed.MEDIUM;
		colors = Colors.PASTEL;
		hasStar = true;
		rotatingStar = true;
		backgroundThread.start();
		starThread.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(colors.colorsArr[backgroundColorIndex]);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if(hasStar) {
			drawRotatingStar(g, getWidth() / 2, getHeight() / 2, 100, starAngle);
		}
	}
	
	@Override
	public void run() {
		while (true) {
            backgroundColorIndex = (backgroundColorIndex + 1) % colors.colorsArr.length;
         
            repaint();
            try {
                Thread.sleep(backgroundSpeed.backgroundSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
	}
	
	private class StarRotator implements Runnable{

		@Override
		public void run() {
            while (true) {
            	if(rotatingStar) {
            		starAngle += starSpeed.starSpeed;
            		repaint();
            	}
                try {
                    Thread.sleep(16);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
		}
		
	}
	
	private void drawRotatingStar(Graphics g, int x, int y, int size, double angle) {
        int[] xPoints = new int[10];
        int[] yPoints = new int[10];

        for (int i = 0; i < 10; i++) {
            double theta = Math.toRadians(i * 36 + angle);
            int r = (i % 2 == 0) ? size : size / 2;
            xPoints[i] = (int) (x + r * Math.cos(theta));
            yPoints[i] = (int) (y + r * Math.sin(theta));
        }
        
        int colorStarIndex = (backgroundColorIndex + 1) % colors.colorsArr.length;
        g.setColor(colors.colorsArr[colorStarIndex]);
        g.fillPolygon(xPoints, yPoints, 10);
    }
	
	public void setBackgroundSpeed(Speed backgroundSpeed) {
		this.backgroundSpeed = backgroundSpeed;
	}
	
	public void setStarSpeed(Speed starSpeed) {
		this.starSpeed = starSpeed;
	}
	
	public void setColors(Colors colors) {
		backgroundColorIndex = 0;
		this.colors = colors;
	}
	
	public void setRotatingStar(boolean hasRotation) {
		rotatingStar = hasRotation;
	}
	
	public void hasStar(boolean hasStar) {
		this.hasStar = hasStar;
	}
}
