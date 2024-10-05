package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.AbstractButton;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import control.FileController;
import enums.Colors;
import enums.Speed;

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
		
		ProjectMenuBar menuBar = mainWindow.getProjectMenuBar();
		
		menuBar.getCloseApp().addActionListener(this);
		menuBar.getOpenFile().addActionListener(this);
		menuBar.getCloseFile().addActionListener(this);
		menuBar.getHelpHelp().addActionListener(this);
		menuBar.getHelpAbout().addActionListener(this);
		
		ArrayList<AbstractButton> backgroundSpeedButtons = Collections.list(menuBar.getBackgroundSpeedGroup().getElements());
		ArrayList<AbstractButton> starSpeedButtons = Collections.list(menuBar.getStarSpeedGroup().getElements());
		ArrayList<AbstractButton> colorButtons = Collections.list(menuBar.getColorGroup().getElements());
		ArrayList<AbstractButton> patternButtons = Collections.list(menuBar.getPatternGroup().getElements());
		
		for(AbstractButton button : backgroundSpeedButtons) {
			button.addItemListener(this);
		}
		
		for(AbstractButton button : colorButtons) {
			button.addItemListener(this);
		}
		
		for(AbstractButton button : patternButtons) {
			button.addItemListener(this);
		}
		
		for(AbstractButton button : starSpeedButtons) {
			button.addItemListener(this);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// VELOCIDADE DO FUNDO
		if(e.getSource() == mainWindow.getProjectMenuBar().getBackgroundLowSpeed()) {
			((AnimatedBackground) mainWindow.getContentPane()).setBackgroundSpeed(Speed.LOW);
		}
		else if(e.getSource() == mainWindow.getProjectMenuBar().getBackgroundMediumSpeed()) {
			((AnimatedBackground) mainWindow.getContentPane()).setBackgroundSpeed(Speed.MEDIUM);
		}
		else if(e.getSource() == mainWindow.getProjectMenuBar().getBackgroundHighSpeed()) {
			((AnimatedBackground) mainWindow.getContentPane()).setBackgroundSpeed(Speed.HIGH);
		}
		
		// VELOCIDADE DA ESTRELA
		if(e.getSource() == mainWindow.getProjectMenuBar().getStarLowSpeed()) {
			((AnimatedBackground) mainWindow.getContentPane()).setStarSpeed(Speed.LOW);
		}
		else if(e.getSource() == mainWindow.getProjectMenuBar().getStarMediumSpeed()) {
			((AnimatedBackground) mainWindow.getContentPane()).setStarSpeed(Speed.MEDIUM);
		}
		else if(e.getSource() == mainWindow.getProjectMenuBar().getStarHighSpeed()) {
			((AnimatedBackground) mainWindow.getContentPane()).setStarSpeed(Speed.HIGH);
		}
		
		// CORES
		if(e.getSource() == mainWindow.getProjectMenuBar().getPrimaryColors()) {
			((AnimatedBackground) mainWindow.getContentPane()).setColors(Colors.PRIMARY);
		}
		else if(e.getSource() == mainWindow.getProjectMenuBar().getPastelColors()) {
			((AnimatedBackground) mainWindow.getContentPane()).setColors(Colors.PASTEL);
		}
		else if(e.getSource() == mainWindow.getProjectMenuBar().getNeutralColors()) {
			((AnimatedBackground) mainWindow.getContentPane()).setColors(Colors.NEUTRAL);
		}
		else if(e.getSource() == mainWindow.getProjectMenuBar().getRainbowColors()) {
			((AnimatedBackground) mainWindow.getContentPane()).setColors(Colors.RAINBOW);
		}
		
		// PADROES
		if(e.getSource() == mainWindow.getProjectMenuBar().getRotatingStar()) {
			((AnimatedBackground) mainWindow.getContentPane()).hasStar(true);
			((AnimatedBackground) mainWindow.getContentPane()).setRotatingStar(true);
		}
		else if(e.getSource() == mainWindow.getProjectMenuBar().getStarWithNoRotation()) {
			((AnimatedBackground) mainWindow.getContentPane()).hasStar(true);
			((AnimatedBackground) mainWindow.getContentPane()).setRotatingStar(false);
		}
		else if(e.getSource() == mainWindow.getProjectMenuBar().getNoStar()) {
			((AnimatedBackground) mainWindow.getContentPane()).hasStar(false);
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
		
		else if(e.getSource() == mainWindow.getProjectMenuBar().getHelpHelp()) {
			new HelpDialog(mainWindow);
		}
		else if(e.getSource() == mainWindow.getProjectMenuBar().getHelpAbout()) {
			new AboutDialog(mainWindow);
		}
	}
	
	private void exitSystem() {
		JOptionPane.showMessageDialog(this.mainWindow, "Adeus!");
		System.exit(0);
	}
	
	private void openFile() {
		File file = FileController.openFile(this.mainWindow, new FileNameExtensionFilter("Arquivos texto", "txt"));
		if(file != null) {
			String fileText = FileController.getFileContent(file);
			String fileTitle = file.getName();
			mainWindow.getFileContent().setTextContent(fileTitle, fileText);
			mainWindow.getFileContent().setVisible(true);
		}
	}
	
	private void closeFile() {
		mainWindow.getFileContent().setVisible(false);
		mainWindow.getFileContent().setTextContent("","");
	}
}
