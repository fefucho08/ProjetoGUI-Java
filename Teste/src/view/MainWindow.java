package view;

import java.awt.EventQueue;

import javax.swing.*;

import control.Animation;

import java.awt.*;

import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class MainWindow extends JFrame {
	
	private JPanel contentPane;
	private FileContentPanel fileContent;
	private JPanel footer;
	private Icon icon;
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
		
		int initialScreenWidth = (int) ((int)Toolkit.getDefaultToolkit().getScreenSize().width * 0.5);
		int initialScreenHeight = (int) ((int)Toolkit.getDefaultToolkit().getScreenSize().height * 0.5);
		
		setBounds(0, 0, initialScreenWidth, initialScreenHeight);
		setSize(initialScreenWidth, initialScreenHeight);
        //setLocationRelativeTo(null); // Center on screen
		
		// WINDOW´S COMPONENTS
		
		// TODO: SUBSTITUIR ESSE JPANEL PELO FUNDO ANIMADO
		this.contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLayeredPane container = new JLayeredPane();
		contentPane.add(container, BorderLayout.CENTER);
		
		
		icon = new Icon();
		icon.setBounds(100, 0, getWidth(), getHeight()); // Set bounds
		container.add(icon, JLayeredPane.DEFAULT_LAYER);
		
		Runnable animation = new Animation(getWidth(), getHeight(), icon, 1);
		animation.run();
		
		this.fileContent = new FileContentPanel();
		fileContent.setVisible(false);
		fileContent.setBounds(0, 0, getWidth(), getHeight());
		container.add(fileContent, JLayeredPane.PALETTE_LAYER);
		
		this.footer = new JPanel();
		footer.setBackground(Color.LIGHT_GRAY);
		contentPane.add(footer, BorderLayout.SOUTH);

		this.footerLabel = new JLabel();
		footer.add(footerLabel);
		footerLabel.setText(this.getClass().getSimpleName());
		
		this.menuBar = new ProjectMenuBar();
		setJMenuBar(menuBar);
		
		setupListeners();
		
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resizeComponents();
            }
        });

        // Initial resizing
        resizeComponents();
    }

    private void resizeComponents() {
        int width = contentPane.getWidth();
        int height = contentPane.getHeight();

        // Resize file content panel to fit background
        fileContent.setPreferredSize(new Dimension(width, height - 50)); // Leave space for footer
        fileContent.setBounds(0, 0, width, height - 50); // Update bounds
        fileContent.revalidate(); // Refresh layout
        
    }
	
	private void setupListeners() {
		this.listener = new MainWindowListener(this);
		
		menuBar.getCloseApp().addActionListener(listener);
		menuBar.getOpenFile().addActionListener(listener);
		menuBar.getCloseFile().addActionListener(listener);
		
        menuBar.getGreenColor().addItemListener(listener);
        menuBar.getRedColor().addItemListener(listener);
        menuBar.getBlueColor().addItemListener(listener);
        menuBar.getYellowColor().addItemListener(listener);
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
	
    public void setBackgroundColor(Color color) {
    	contentPane.setBackground(color);
    }

}