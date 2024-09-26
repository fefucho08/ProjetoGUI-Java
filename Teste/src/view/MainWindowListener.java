package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import control.FileController;

public class MainWindowListener implements ActionListener, ItemListener {

	private MainWindow mainWindow;

	public MainWindowListener(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		
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
}
