package homework.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	private Main() {
	}

	public static void main(String[] args) {
		List<Integer> simpleNumbers = new ArrayList<>();
		//код получения интервала и количества потоков с консоле
		try (Scanner scanner = new Scanner(System.in)) {

		}

		//код разделения интервала на подинтервалы (from start to end) с учетом количества потоков



		//Run diff threads count
		int start = -1;
		int end = 10;
		int count = 3;
		List<CheckerNumberBuffered> checkerNumberBuffered = new ArrayList<>();
		for (int index = 0; index < count; index++) {
			checkerNumberBuffered.add(index, new CheckerNumberBuffered(start, end));
			Thread thread = new Thread(checkerNumberBuffered.get(index));
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (CheckerNumberBuffered numberBuffered : checkerNumberBuffered) {
			simpleNumbers.addAll(numberBuffered.getNumberBuffer());
		}
		System.out.println(simpleNumbers.toString());
	}
}

