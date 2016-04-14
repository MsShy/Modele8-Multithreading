package homework.task1;

import java.util.ArrayList;
import java.util.List;

class SimpleNumber {

	private final static int START = 1;
	private final static int END = 5;
	private static List<SimpleNumber> numb = new ArrayList<SimpleNumber>();

	static void output() {
		for (int i = START; i <= END; i++) {
			if (isSimpleNumber(i)) {
				numb.add(new SimpleNumber());
				System.out.print(i+",");
			}

		}
	}

	private static boolean isSimpleNumber(int number) {
		int count = 0;

		for (int j = 2; j <= number; j++) {
			if (number % j == 0) {
				count++;
			}
		}
		return count == 1;

	}
}
