package view;

import java.awt.EventQueue;

import javax.swing.*;

import control.FileController;

import java.awt.*;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;


public class MainWindow extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private JTextArea pageText;
	private JPanel footer;
	private JLabel footerLabel;
	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem openFile;
	private JMenuItem closeFile;
	private JSeparator separator;
	private JMenuItem closeApp;
	private JMenu menuConfiguracao;
	private JMenuItem configPattern;
	private JMenuItem configColors;
	private JMenuItem configSpeed;
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
		this.contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		this.pageText = new JTextArea();
		pageText.setBackground(new Color(0,0,0,0));
		pageText.setOpaque(false);
		pageText.setEditable(false);
		pageText.setFocusable(false);
		contentPane.add(pageText, BorderLayout.CENTER);
		
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
		
		this.menuConfiguracao = new JMenu("Configuração");
		menuBar.add(menuConfiguracao);
		
		this.configPattern = new JMenuItem("Padrões");
		menuConfiguracao.add(configPattern);
		
		this.configColors = new JMenuItem("Cores");
		menuConfiguracao.add(configColors);
		
		this.configSpeed = new JMenuItem("Velocidade");
		menuConfiguracao.add(configSpeed);
		
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
				setTextContent(FileController.openFileOnTextArea(MainWindow.this));
			}
		});
		
		closeFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FileController.closeTextAreaFile();
				setTextContent("");
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
	
	private void setTextContent(String text) {
		this.pageText.setText(text);
		pageText.repaint();
	}
	
	private void exitSystem() {
		JOptionPane.showMessageDialog(MainWindow.this, "Adeus!");
		System.exit(0);
	}

	
}