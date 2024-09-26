package control;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileController {
	public static File openFile(JFrame frame, FileNameExtensionFilter filter) throws Exception {
		try {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setFileFilter(filter);
			
			int res = fileChooser.showOpenDialog(frame);
			if(res != JFileChooser.APPROVE_OPTION) {
				throw new Exception();
			}
			
			File fileChosen = fileChooser.getSelectedFile();
			String fileName = fileChosen.getName();
			boolean isValidExtension = Arrays.stream(filter.getExtensions()).anyMatch(extension -> fileName.toLowerCase().endsWith(extension));
			
			if(!isValidExtension) {
				throw new InvalidFileTypeException("O arquivo pode ser apenas dos tipos: " + Arrays.toString(filter.getExtensions()));
			}
			
			return fileChosen;
			
		}
		catch(InvalidFileTypeException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
			throw ex;
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	
	public static String getFileContent(File file) {
		String fileContent;
		try (Scanner sc = new Scanner(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8)) {
			fileContent = sc.useDelimiter("\\A").next();
			return fileContent;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}
}
