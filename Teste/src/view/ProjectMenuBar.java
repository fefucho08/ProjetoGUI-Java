package view;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;

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
	private JRadioButtonMenuItem rotatingStar;
	private JRadioButtonMenuItem starWithNoRotation;
	private JRadioButtonMenuItem noStar;
	private ButtonGroup patternGroup;
	private JMenu configColors;
	private JRadioButtonMenuItem primaryColors;
	private JRadioButtonMenuItem pastelColors;
	private JRadioButtonMenuItem neutralColors;
	private JRadioButtonMenuItem rainbowColors;
	private ButtonGroup colorGroup;
	private JMenu configSpeed;
	private JMenu backgroundSpeed;
	private JRadioButtonMenuItem backgroundLowSpeed;
	private JRadioButtonMenuItem backgroundMediumSpeed;
	private JRadioButtonMenuItem backgroundHighSpeed;
	private JMenu starSpeed;
	private JRadioButtonMenuItem starLowSpeed;
	private JRadioButtonMenuItem starMediumSpeed;
	private JRadioButtonMenuItem starHighSpeed;
	private ButtonGroup backgroundSpeedGroup;
	private ButtonGroup starSpeedGroup;
	private JMenu helpMenu;
	private JMenuItem helpHelp;
	private JMenuItem helpAbout;
	
	public ProjectMenuBar() {
		this.fileMenu = new JMenu("Arquivo");
		this.add(fileMenu);
		
		openFile = new JMenuItem("Abrir Arquivo");
		fileMenu.add(openFile);
		
		closeFile = new JMenuItem("Fechar Arquivo");
		fileMenu.add(closeFile);
		
		separator = new JSeparator();
		fileMenu.add(separator);
		
		closeApp = new JMenuItem("Sair");
		fileMenu.add(closeApp);
		
		menuConfig = new JMenu("Configuração");
		this.add(menuConfig);
		
		configPattern = new JMenu("Padrões");
		menuConfig.add(configPattern);
		
		patternGroup = new ButtonGroup();
		
		rotatingStar = new JRadioButtonMenuItem("Estrela Giratória", true);
		configPattern.add(rotatingStar);
		patternGroup.add(rotatingStar);

		starWithNoRotation = new JRadioButtonMenuItem("Estrela Estática");
		configPattern.add(starWithNoRotation);
		patternGroup.add(starWithNoRotation);
		
		noStar = new JRadioButtonMenuItem("Sem estrela");
		configPattern.add(noStar);
		patternGroup.add(noStar);
		
		configColors = new JMenu("Cores");
		menuConfig.add(configColors);
		
		colorGroup = new ButtonGroup();
		
		primaryColors = new JRadioButtonMenuItem("Primárias");
		configColors.add(primaryColors);
		colorGroup.add(primaryColors);
		
		pastelColors = new JRadioButtonMenuItem("Pastel", true);
		configColors.add(pastelColors);
		colorGroup.add(pastelColors);
		
		neutralColors = new JRadioButtonMenuItem("Neutras");
		configColors.add(neutralColors);
		colorGroup.add(neutralColors);
		
		rainbowColors = new JRadioButtonMenuItem("Arco-íris");
		configColors.add(rainbowColors);
		colorGroup.add(rainbowColors);
		
		configSpeed = new JMenu("Velocidade");
		menuConfig.add(configSpeed);
		
		backgroundSpeed = new JMenu("Fundo");
		configSpeed.add(backgroundSpeed);
		
		backgroundSpeedGroup = new ButtonGroup();
		
		backgroundLowSpeed = new JRadioButtonMenuItem("Devagar");
		backgroundSpeed.add(backgroundLowSpeed);
		backgroundSpeedGroup.add(backgroundLowSpeed);
		
		backgroundMediumSpeed = new JRadioButtonMenuItem("Médio", true);
		backgroundSpeed.add(backgroundMediumSpeed);
		backgroundSpeedGroup.add(backgroundMediumSpeed);
		
		backgroundHighSpeed = new JRadioButtonMenuItem("Rápido");
		backgroundSpeed.add(backgroundHighSpeed);
		backgroundSpeedGroup.add(backgroundHighSpeed);
		
		starSpeed = new JMenu("Estrela");
		configSpeed.add(starSpeed);
		
		starSpeedGroup = new ButtonGroup();
		
		starLowSpeed = new JRadioButtonMenuItem("Devagar");
		starSpeed.add(starLowSpeed);
		starSpeedGroup.add(starLowSpeed);
		
		starMediumSpeed = new JRadioButtonMenuItem("Médio", true);
		starSpeed.add(starMediumSpeed);
		starSpeedGroup.add(starMediumSpeed);
		
		starHighSpeed = new JRadioButtonMenuItem("Rápido");
		starSpeed.add(starHighSpeed);
		starSpeedGroup.add(starHighSpeed);
		
		helpMenu = new JMenu("Ajuda");
		this.add(helpMenu);
		
		helpHelp = new JMenuItem("Ajuda");
		helpMenu.add(helpHelp);
		
		helpAbout = new JMenuItem("Sobre");
		helpMenu.add(helpAbout);
		
		repaint();
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

	public JRadioButtonMenuItem getRotatingStar() {
		return rotatingStar;
	}

	public JRadioButtonMenuItem getStarWithNoRotation() {
		return starWithNoRotation;
	}

	public JRadioButtonMenuItem getNoStar() {
		return noStar;
	}

	public ButtonGroup getPatternGroup() {
		return patternGroup;
	}
	
	public JMenu getConfigColors() {
		return configColors;
	}
	
	public JRadioButtonMenuItem getPrimaryColors() {
		return primaryColors;
	}
	
	public JRadioButtonMenuItem getPastelColors() {
		return pastelColors;
	}
	
	public JRadioButtonMenuItem getNeutralColors() {
		return neutralColors;
	}
	
	public JRadioButtonMenuItem getRainbowColors() {
		return rainbowColors;
	}

	public ButtonGroup getColorGroup() {
		return colorGroup;
	}
	
	public JMenu getConfigSpeed() {
		return configSpeed;
	}

	public JRadioButtonMenuItem getBackgroundLowSpeed() {
		return backgroundLowSpeed;
	}

	public JRadioButtonMenuItem getBackgroundMediumSpeed() {
		return backgroundMediumSpeed;
	}

	public JRadioButtonMenuItem getBackgroundHighSpeed() {
		return backgroundHighSpeed;
	}

	public ButtonGroup getBackgroundSpeedGroup() {
		return backgroundSpeedGroup;
	}
	
	public JMenu getStarSpeed() {
		return starSpeed;
	}

	public JRadioButtonMenuItem getStarLowSpeed() {
		return starLowSpeed;
	}

	public JRadioButtonMenuItem getStarMediumSpeed() {
		return starMediumSpeed;
	}

	public JRadioButtonMenuItem getStarHighSpeed() {
		return starHighSpeed;
	}

	public ButtonGroup getStarSpeedGroup() {
		return starSpeedGroup;
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
