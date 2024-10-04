package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import control.FileController;

public class MainWindowListener implements ActionListener, ItemListener {

	private MainWindow mainWindow;
	
	private Map<Object, Runnable> stateChangeActionMap;

	public MainWindowListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		
		this.stateChangeActionMap = new HashMap<>() {{
			put(mainWindow.getProjectMenuBar().getGreenColor(), MainWindowListener.this::setToGreen);
			put(mainWindow.getProjectMenuBar().getRedColor(), MainWindowListener.this::setToRed);
			put(mainWindow.getProjectMenuBar().getBlueColor(), MainWindowListener.this::setToBlue);
			put(mainWindow.getProjectMenuBar().getYellowColor(), MainWindowListener.this::setToYellow);
		}};
		
		mainWindow.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exitSystem();
			}
		});
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == mainWindow.getProjectMenuBar().getLowSpeed()) {
			// TODO: Altera velocidade do fundo para devagar
		}
		else if(e.getSource() == mainWindow.getProjectMenuBar().getMediumSpeed()) {
			// TODO: Altera velocidade do fundo para media
		}
		if(e.getSource() == mainWindow.getProjectMenuBar().getHighSpeed()) {
			// TODO: Altera velocidade do fundo para rápida
		}
		
		Runnable func = this.stateChangeActionMap.get(e.getSource());
		if (func == null) {
			return;
		}
		
		func.run();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mainWindow.getProjectMenuBar().getCloseApp()) {
			exitSystem();
		}
		
		else if(e.getSource() == mainWindow.getProjectMenuBar().getOpenFile()) {
			openFile();
		}
		
		else if(e.getSource() == mainWindow.getProjectMenuBar().getCloseFile()) {
			closeFile();
		}
	}
	
	private void exitSystem() {
		JOptionPane.showMessageDialog(this.mainWindow, "Adeus!");
		System.exit(0);
	}
	
	private void openFile() {
		try {
			File file = FileController.openFile(this.mainWindow, new FileNameExtensionFilter("Arquivos texto", "txt"));
			String fileText = FileController.getFileContent(file);
			String fileTitle = file.getName();
			mainWindow.getFileContent().setTextContent(fileTitle, fileText);
			mainWindow.getFileContent().setVisible(true);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void closeFile() {
		mainWindow.getFileContent().setVisible(false);
		mainWindow.getFileContent().setTextContent("","");
	}
	
	private void setToRed() {
		mainWindow.setBackgroundColor(Color.RED);
	}
	
	private void setToBlue() {
		mainWindow.setBackgroundColor(Color.BLUE);
	}
	
	private void setToGreen() {
		mainWindow.setBackgroundColor(Color.GREEN);
	}
	
	private void setToYellow() {
		mainWindow.setBackgroundColor(Color.YELLOW);
	}
}
