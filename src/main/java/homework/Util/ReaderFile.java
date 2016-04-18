package homework.Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFile {

	public static String read(String fileName) throws FileNotFoundException {
		StringBuilder builder = new StringBuilder();
		try (FileReader reader = new FileReader(fileName);
		     BufferedReader bufferedReader = new BufferedReader(reader)) {
			String output;
			while ((output = bufferedReader.readLine()) != null) {
				builder.append(output).append("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}

}
