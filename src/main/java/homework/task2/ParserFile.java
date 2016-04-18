package homework.task2;

import homework.util.Constant;
import homework.util.ReaderFile;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

class ParserFile {
		private static ConcurrentLinkedQueue<Object> trans;

	static void parsFile(String file) throws FileNotFoundException {
		trans = new ConcurrentLinkedQueue<>();
		String text = ReaderFile.read(file);
		try (Scanner scanner = new Scanner(text)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] split = Constant.PATTERN.split(line);
				int sender = Integer.parseInt(split[0]);
				int recipient = Integer.parseInt(split[1]);
				int amount = Integer.parseInt(split[2]);
				TransObject transObject = new TransObject(sender, recipient, amount);
				trans.add(transObject);
			}
		}
	}

	static ConcurrentLinkedQueue<Object> getTrans() {
		return trans;
	}
}
