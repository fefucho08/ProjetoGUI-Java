package view;

import javax.swing.*;

public class ProjectMenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JMenu fileMenu;
	private JMenuItem openFile;
	private JMenuItem closeFile;
	private JSeparator separator;
	private JMenuItem closeApp;
	private JMenu menuConfig;
	private JMenu configPattern;
	
	private JMenu configColors;
	private JRadioButtonMenuItem green;
	private JRadioButtonMenuItem red;
	private JRadioButtonMenuItem blue;
	private JRadioButtonMenuItem yellow;
	
	private JMenu configSpeed;
	private JRadioButtonMenuItem lowSpeed;
	private JRadioButtonMenuItem mediumSpeed;
	private JRadioButtonMenuItem highSpeed;
	private ButtonGroup speedGroup;
	private JMenu helpMenu;
	private JMenuItem helpHelp;
	private JMenuItem helpAbout;
	
	public ProjectMenuBar() {
		this.fileMenu = new JMenu("Arquivo");
		this.add(fileMenu);
		
		this.openFile = new JMenuItem("Abrir Arquivo");
		fileMenu.add(openFile);
		
		this.closeFile = new JMenuItem("Fechar Arquivo");
		fileMenu.add(closeFile);
		
		this.separator = new JSeparator();
		fileMenu.add(separator);
		
		this.closeApp = new JMenuItem("Sair");
		fileMenu.add(closeApp);
		
		this.menuConfig = new JMenu("Configuração");
		this.add(menuConfig);
		
		this.configPattern = new JMenu("Padrões");
		menuConfig.add(configPattern);
		
		this.configColors = new JMenu("Cores");
		menuConfig.add(configColors);
		
		blue = new JRadioButtonMenuItem("Azul");
		red = new JRadioButtonMenuItem("Vermelho", true);
		green = new JRadioButtonMenuItem("Verde");
		yellow = new JRadioButtonMenuItem("Amarelo");
		
		configColors.add(red);
		configColors.add(blue);
		configColors.add(green);
		configColors.add(yellow);
		
		this.configSpeed = new JMenu("Velocidade");
		menuConfig.add(configSpeed);
		
		lowSpeed = new JRadioButtonMenuItem("Lento");
		configSpeed.add(lowSpeed);
		
		mediumSpeed = new JRadioButtonMenuItem("Normal", true);
		configSpeed.add(mediumSpeed);
		
		highSpeed = new JRadioButtonMenuItem("Rápido");
		configSpeed.add(highSpeed);
		
		speedGroup = new ButtonGroup();
		speedGroup.add(lowSpeed);
		speedGroup.add(mediumSpeed);
		speedGroup.add(highSpeed);
		
		this.helpMenu = new JMenu("Ajuda");
		this.add(helpMenu);
		
		this.helpHelp = new JMenuItem("Ajuda");
		helpMenu.add(helpHelp);
		
		this.helpAbout = new JMenuItem("Sobre");
		helpMenu.add(helpAbout);
	}

	public JMenu getFileMenu() {
		return fileMenu;
	}

	public JMenuItem getOpenFile() {
		return openFile;
	}

	public JMenuItem getCloseFile() {
		return closeFile;
	}

	public JSeparator getSeparator() {
		return separator;
	}

	public JMenuItem getCloseApp() {
		return closeApp;
	}

	public JMenu getMenuConfig() {
		return menuConfig;
	}

	public JMenu getConfigPattern() {
		return configPattern;
	}

	public JMenu getConfigColors() {
		return configColors;
	}

	public JMenu getConfigSpeed() {
		return configSpeed;
	}

	public JRadioButtonMenuItem getLowSpeed() {
		return lowSpeed;
	}

	public JRadioButtonMenuItem getMediumSpeed() {
		return mediumSpeed;
	}

	public JRadioButtonMenuItem getHighSpeed() {
		return highSpeed;
	}
	
	public JRadioButtonMenuItem getGreenColor() {
		return green;
	}
	
	public JRadioButtonMenuItem getRedColor() {
		return red;
	}
	
	public JRadioButtonMenuItem getBlueColor() {
		return blue;
	}
	
	public JRadioButtonMenuItem getYellowColor() {
		return yellow;
	}

	public ButtonGroup getSpeedButtonGroup() {
		return speedGroup;
	}
	
	public JMenu getHelpMenu() {
		return helpMenu;
	}

	public JMenuItem getHelpHelp() {
		return helpHelp;
	}

	public JMenuItem getHelpAbout() {
		return helpAbout;
	}
	
}
