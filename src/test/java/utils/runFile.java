package utils;

import java.io.File;
import java.io.IOException;

public class runFile {
	public void OpenFile(String applicationNameWithExtention, String applicationFolderPath){	
	try {
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", applicationNameWithExtention);
		File dir = new File(applicationFolderPath);
		pb.directory(dir);
		Process p = pb.start();
		System.out.println(p);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
