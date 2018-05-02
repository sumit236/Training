/** 
 * Program: 			 Read a file from local disk and manipulate it.
 * Program Description:  The program contains 2 files:-
 * 						 1) From 1st file, it reads the content and 
 * 							prints accordingly. 
 * 						 2) In 2nd file, it writes the data in the file.						 
 */
package mypack;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

public class FileIO {

	private static Logger log = Logger.getLogger(ContainDuplicate.class);

	private void readFromFile() {
		// For reading contents from the file.
		File file = new File("./hello.txt");
		FileInputStream fis = null;
		try {
			// Opens a connection to the file .
			fis = new FileInputStream(file);
			int content;

			content = fis.read();
			// Reads a byte from this input stream.
			while (content != -1)
				// converts to char and display it.
				log.info((char) content);
		} catch (Exception e) {
			log.info("Exception occured " + e);
		}

	}

	private void writeInFile() {
		// For writing contents into the file.
		File data = new File("./Sasuke.txt");
		try {
			// For writing data to a file
			FileOutputStream file2 = new FileOutputStream(data);
			FilterOutputStream filter = new FilterOutputStream(file2);
			// String written in the file named Sasuke.
			final String example = "Welcome Sasuke Uchiha.";
			byte byteBybyte[] = example.getBytes();
			filter.write(byteBybyte);
			filter.flush();
			filter.close();
			file2.close();
		} catch (Exception e) {
			log.info("Exception occured " + e);
		}
	}

	public static void main(String[] args) {

		FileIO fileObj = new FileIO();
		fileObj.readFromFile();
		fileObj.writeInFile();
	}
}
