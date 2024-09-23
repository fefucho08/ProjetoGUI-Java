package control;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import exceptions.InvalidFileType;

public class FileController {
	private static File fileChosen;
	public static void openFileOnTextArea(JFrame frame, JTextArea label){
		try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.showOpenDialog(frame);
			fileChosen = fileChooser.getSelectedFile();
			
			if(!fileChosen.getName().endsWith(".txt")) {
				throw new InvalidFileType("Arquivo deve ser txt!");
			}
			
			try (Scanner sc = new Scanner(Paths.get(fileChosen.getAbsolutePath()), StandardCharsets.UTF_8)) {
				String fileContent = sc.useDelimiter("\\A").next();
				label.setText(fileContent);
				label.repaint();
			}
			
		}
		catch(InvalidFileType ex) {
			JOptionPane.showMessageDialog(frame, ex.getMessage());
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public static void closeTextAreaFile(JTextArea area) {
		fileChosen = null;
		area.setText("");
		area.repaint();
	}
}
