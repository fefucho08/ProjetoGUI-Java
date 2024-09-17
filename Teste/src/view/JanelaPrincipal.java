package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JSeparator;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
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
	public JanelaPrincipal() {
		setTitle("Projeto GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel conteudoPagina = new JLabel("Texto texto texto");
		contentPane.add(conteudoPagina, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);
		
		JMenuItem abrirArquivo = new JMenuItem("Abrir Arquivo");
		menuArquivo.add(abrirArquivo);
		
		JMenuItem fecharArquivo = new JMenuItem("Fechar Arquivo");
		menuArquivo.add(fecharArquivo);
		
		JSeparator separator = new JSeparator();
		menuArquivo.add(separator);
		
		JMenuItem sairAplicacao = new JMenuItem("Sair");
		menuArquivo.add(sairAplicacao);
		
		JMenu menuConfiguracao = new JMenu("Configuração");
		menuBar.add(menuConfiguracao);
		
		JMenuItem configPadroes = new JMenuItem("Padrões");
		menuConfiguracao.add(configPadroes);
		
		JMenuItem configCores = new JMenuItem("Cores");
		menuConfiguracao.add(configCores);
		
		JMenuItem configVelocidade = new JMenuItem("Velocidade");
		menuConfiguracao.add(configVelocidade);
		
		JMenu menuAjuda = new JMenu("Ajuda");
		menuBar.add(menuAjuda);
		
		JMenuItem ajudaAjuda = new JMenuItem("Ajuda");
		menuAjuda.add(ajudaAjuda);
		
		JMenuItem ajudaSobre = new JMenuItem("Sobre");
		menuAjuda.add(ajudaSobre);
	}
}
