package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FileContentPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
<<<<<<< HEAD
	private JScrollPane textScrollPane;
	private JTextArea fileText;
	private JLabel fileTitle;
=======
	JScrollPane textScrollPane;
	JTextArea fileText;
	JLabel fileTitle;
>>>>>>> branch 'master' of https://github.com/fefucho08/ProjetoGUI-Java.git
	private Component verticalStrutNorth;
	private Component verticalStrutSouth;
	
	public FileContentPanel() {
		setLayout(new BorderLayout());
		
		this.fileText = new JTextArea("Abra um arquivo");
		fileText.setLineWrap(true);
		fileText.setWrapStyleWord(true);
		fileText.setEditable(false);
		fileText.setFocusable(false);
		fileText.setMargin(new Insets(0, 10, 0, 10));
		
		this.textScrollPane = new JScrollPane(fileText);
		
		this.fileTitle = new JLabel("Titulo");
		fileTitle.setBorder(new EmptyBorder(5, 10, 5, 0));
		
		textScrollPane.setColumnHeaderView(fileTitle);
		
		this.verticalStrutNorth = Box.createVerticalStrut(60);
		this.add(verticalStrutNorth, BorderLayout.NORTH);
		
		this.verticalStrutSouth = Box.createVerticalStrut(60);
		this.add(verticalStrutSouth, BorderLayout.SOUTH);
		
		this.add(textScrollPane);
		
		this.setOpaque(false);
		this.setBackground(new Color(0,0,0,0));
               
        this.repaint();
        
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                adjustStrutHeights();
            }
        });
		
	}
	
	public void setTextContent(String fileTitle, String fileText) {
		this.fileText.setText(fileText);
		this.fileText.repaint();
		
		this.fileTitle.setText(fileTitle);
		this.fileTitle.repaint();
	}
	

    private void adjustStrutHeights() {        
        int newHeight = (int) (getHeight() * 0.2);
        
        verticalStrutNorth.setPreferredSize(new Dimension(0, newHeight));
        verticalStrutSouth.setPreferredSize(new Dimension(0, newHeight));
        
        verticalStrutNorth.repaint();
        verticalStrutSouth.repaint();
    }
}

