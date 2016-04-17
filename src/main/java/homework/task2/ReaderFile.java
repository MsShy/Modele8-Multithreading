package homework.task2;

import homework.Constant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

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

	/*public static getID(String balances) {


		final List<String> phrases = get(balances);
		if (phrases != null) {

			for (String phrase : phrases) {
				int id = Constant.PATTERN.split(phrase).length;
			}


		}
	}*/
}
