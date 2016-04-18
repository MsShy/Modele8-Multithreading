package homework.task2;

import homework.Util.ReaderFile;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParserFile {

	public static void parsFile(String file) throws FileNotFoundException {
		Queue<>
				String text= ReaderFile.read(file);
try(Scanner scanner=new Scanner(text)){
			while (scanner.hasNextLine()){
				String line=scanner.nextLine();
				String[]
			}
		}
	}
}
