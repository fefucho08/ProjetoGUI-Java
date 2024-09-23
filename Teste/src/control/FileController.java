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
	public static String openFileOnTextArea(JFrame frame){
		try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.showOpenDialog(frame);
			fileChosen = fileChooser.getSelectedFile();
			
			if(!fileChosen.getName().endsWith(".txt")) {
				throw new InvalidFileType("Arquivo deve ser txt!");
			}
			
			
			String fileContent;
			try (Scanner sc = new Scanner(Paths.get(fileChosen.getAbsolutePath()), StandardCharsets.UTF_8)) {
				fileContent = sc.useDelimiter("\\A").next();
			}
			return fileContent;
		}
		catch(InvalidFileType ex) {
			JOptionPane.showMessageDialog(frame, ex.getMessage());
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}
	
	public static void closeTextAreaFile() {
		fileChosen = null;
	}
}
