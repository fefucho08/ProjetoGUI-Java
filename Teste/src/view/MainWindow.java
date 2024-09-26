package view;

import java.awt.EventQueue;

import javax.swing.*;

import java.awt.*;

import java.awt.BorderLayout;


public class MainWindow extends JFrame {
	
	private JPanel contentPane;
	private FileContentPanel fileContent;
	private JPanel footer;
	private JLabel footerLabel;
	private ProjectMenuBar menuBar;
	
	private MainWindowListener listener;
	
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
		
		this.menuBar = new ProjectMenuBar();
		setJMenuBar(menuBar);
		
		setupListeners();
	}
	
	private void setupListeners() {
		this.listener = new MainWindowListener(this);
		
		menuBar.getCloseApp().addActionListener(listener);
		menuBar.getOpenFile().addActionListener(listener);
		menuBar.getCloseFile().addActionListener(listener);
		
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public FileContentPanel getFileContent() {
		return fileContent;
	}

	public JPanel getFooter() {
		return footer;
	}

	public JLabel getFooterLabel() {
		return footerLabel;
	}

	public ProjectMenuBar getProjectMenuBar() {
		return menuBar;
	}

	
}