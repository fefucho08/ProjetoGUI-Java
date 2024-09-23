package view;

import java.awt.EventQueue;

import javax.swing.*;

import control.FileController;

import java.awt.*;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/images/LogoFT.png")));
		setTitle("Projeto GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize((int) (Toolkit.getDefaultToolkit().getScreenSize().width * 0.5),
				(int) (Toolkit.getDefaultToolkit().getScreenSize().height * 0.5));
		
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTextArea pageText = new JTextArea();
		pageText.setBackground(new Color(0,0,0,0));
		pageText.setOpaque(false);
		pageText.setEditable(false);
		pageText.setFocusable(false);
		contentPane.add(pageText, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu fileMenu = new JMenu("Arquivo");
		menuBar.add(fileMenu);
		
		JMenuItem openFile = new JMenuItem("Abrir Arquivo");
		openFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileController.openFileOnTextArea(MainWindow.this, pageText);
			}
		});
		fileMenu.add(openFile);
		
		JMenuItem closeFile = new JMenuItem("Fechar Arquivo");
		fileMenu.add(closeFile);
		
		JSeparator separator = new JSeparator();
		fileMenu.add(separator);
		
		JMenuItem closeApp = new JMenuItem("Sair");
		fileMenu.add(closeApp);
		
		JMenu menuConfiguracao = new JMenu("Configuração");
		menuBar.add(menuConfiguracao);
		
		JMenuItem configPattern = new JMenuItem("Padrões");
		menuConfiguracao.add(configPattern);
		
		JMenuItem configColors = new JMenuItem("Cores");
		menuConfiguracao.add(configColors);
		
		JMenuItem configSpeed = new JMenuItem("Velocidade");
		menuConfiguracao.add(configSpeed);
		
		JMenu helpMenu = new JMenu("Ajuda");
		menuBar.add(helpMenu);
		
		JMenuItem helpHelp = new JMenuItem("Ajuda");
		helpMenu.add(helpHelp);
		
		JMenuItem helpAbout = new JMenuItem("Sobre");
		helpMenu.add(helpAbout);
	}
}