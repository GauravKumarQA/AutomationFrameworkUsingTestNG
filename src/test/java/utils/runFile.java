package utils;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

public class runFile {
	public void OpenFile(String applicationNameWithExtention, String applicationFolderPath){	
	try {
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", applicationNameWithExtention);
		File dir = new File(applicationFolderPath);
		pb.directory(dir);
		Process p = pb.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
