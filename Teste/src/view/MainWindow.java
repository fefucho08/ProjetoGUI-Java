package view;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import control.FileController;

import java.awt.*;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.awt.event.ActionEvent;


public class MainWindow extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private FileContentPanel fileContent;
	private JPanel footer;
	private JLabel footerLabel;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem openFile;
	private JMenuItem closeFile;
	private JSeparator separator;
	private JMenuItem closeApp;
	private JMenu menuConfig;
	private JMenu configPattern;
	private JMenu configColors;
	private JMenu configSpeed;
	private JMenu helpMenu;
	private JMenuItem helpHelp;
	private JMenuItem helpAbout;
	
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public MainWindow() {
		// WINDOW CONFIGURATION
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/images/LogoFT.png")));
		setTitle("Projeto GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.5),
				(int) (Toolkit.getDefaultToolkit().getScreenSize().height * 0.5));
		
		// WINDOW´S COMPONENTS
		
		// TODO: SUBSTITUIR ESSE JPANEL PELO FUNDO ANIMADO
		this.contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		this.fileContent = new FileContentPanel();
		fileContent.setVisible(false);
		contentPane.add(fileContent, BorderLayout.CENTER);
		
		this.footer = new JPanel();
		footer.setBackground(Color.LIGHT_GRAY);
		contentPane.add(footer, BorderLayout.SOUTH);

		this.footerLabel = new JLabel();
		footer.add(footerLabel);
		footerLabel.setText(this.getClass().getSimpleName());
		
		this.menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		this.fileMenu = new JMenu("Arquivo");
		menuBar.add(fileMenu);
		
		this.openFile = new JMenuItem("Abrir Arquivo");
		fileMenu.add(openFile);
		
		this.closeFile = new JMenuItem("Fechar Arquivo");
		fileMenu.add(closeFile);
		
		this.separator = new JSeparator();
		fileMenu.add(separator);
		
		this.closeApp = new JMenuItem("Sair");
		fileMenu.add(closeApp);
		
		this.menuConfig = new JMenu("Configuração");
		menuBar.add(menuConfig);
		
		this.configPattern = new JMenu("Padrões");
		menuConfig.add(configPattern);
		
		this.configColors = new JMenu("Cores");
		menuConfig.add(configColors);
		
		this.configSpeed = new JMenu("Velocidade");
		menuConfig.add(configSpeed);
		
		this.helpMenu = new JMenu("Ajuda");
		menuBar.add(helpMenu);
		
		this.helpHelp = new JMenuItem("Ajuda");
		helpMenu.add(helpHelp);
		
		this.helpAbout = new JMenuItem("Sobre");
		helpMenu.add(helpAbout);
		
		setupListeners();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == closeApp) {
			exitSystem();
		}
	}
	
	private void setupListeners() {
		openFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					File file = FileController.openFile(MainWindow.this, new FileNameExtensionFilter("Arquivos texto", "txt"));
					String fileText = FileController.getFileContent(file);
					String fileTitle = file.getName();
					fileContent.setTextContent(fileTitle, fileText);
					fileContent.setVisible(true);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		closeFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fileContent.setVisible(false);
				fileContent.setTextContent("","");
			}
		});
		
		closeApp.addActionListener(this);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exitSystem();
			}
		});
	}
	
	private void exitSystem() {
		JOptionPane.showMessageDialog(MainWindow.this, "Adeus!");
		System.exit(0);
	}

	
}