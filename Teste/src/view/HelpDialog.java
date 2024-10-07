package view;

import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import control.FileController;

public class HelpDialog extends PersonalizedDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HelpDialog(JFrame frame) {
		super(frame, new ImageIcon(AboutDialog.class.getResource("/images/HelpIcon.png")).getImage(), "Ajuda");
		File helpFile = new File("src/TextFiles/Help.txt");
		String helpFileContent = FileController.getFileContent(helpFile);
		this.setTextContent(helpFileContent);
	}
}
