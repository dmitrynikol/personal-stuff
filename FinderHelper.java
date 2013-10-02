package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Example how to search file in directory and if it's missing, download it.
 * 
 * First time when you run a program you don't have a file 'JSONUtils.java'
 * in the directory - 'C:\\Users\\Public'. So, file will loaded to the directory. 
 * In the next time, file will stay in the directory - and we just get a path in console.
 * 
 * @author Dmitry Nikolaenko
 *
 */
public class FinderHelper {
	
	private static final String repository = "https://github.com/dmitrynikol/personal-stuff/blob/master";
	private static final String fileDirectory = "C:\\Users\\Public";
	private static final String fileName = "JSONUtils.java";
	
	private static List<File> files = new ArrayList<File>();
	
	public static void main(String[] args) throws IOException {
		List<File> files = searchFile(fileName, new File(fileDirectory));
		// if list is empty then we should search and download it
		if (files.isEmpty()) {
			downloadFile(repository.concat("/").concat(fileName), fileDirectory);
		} else {
			for (File filePath : files) {
				System.out.println("File URL: " + filePath);
			}
		}
	}
	
	public static List<File> searchFile(String name, File directory) {
		File[] list = directory.listFiles();
		if (list != null) {
			for (File pathName : list) {
				// check do we have permission to read this directory
				if (pathName.canRead()) {
					if (pathName.isDirectory()) {
						// try to search again
						searchFile(name, pathName);
					} else if (pathName.exists() && name.equalsIgnoreCase(pathName.getName())) {
						//System.out.println(pathName);
						files.add(pathName);
					}
				} else {
					System.out.println(pathName.getAbsoluteFile() + ": permission denied!");
				}
			}
		}
		return files;
	}
	
	/**
     * Method downloads file from URL to a given directory.
     * 
     * @param fileURL - file URL to download
     * @param directory  - directory to download file to
     * @throws IOException
     */
	private static void downloadFile(String fileURL, String directory) throws IOException {
		String downloadedFileName = fileURL.substring(fileURL.lastIndexOf("/") + 1);

		// open connection to the file
		URL url = new URL(fileURL);
		InputStream inputStream = url.openStream();
		// system-dependent filename
		String fileName = directory.concat("\\").concat(downloadedFileName);
		// stream for downloadable file
		FileOutputStream outputStream = new FileOutputStream(fileName);

		// read bytes from URL to the local file
		byte[] buffer = new byte[4096];
		int bytesRead = 0;

		System.out.print("Loading " + downloadedFileName);
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			System.out.print(".");
			outputStream.write(buffer, 0, bytesRead);
		}
		System.out.println("done!");
		System.out.println("File URL: " + fileName);

		outputStream.close();
		inputStream.close();
	}
}