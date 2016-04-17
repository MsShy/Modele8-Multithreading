package homework.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CheckerServiceConcurrent {

	//	private static List<Integer> simpleNumbers = new ArrayList<>();
	private static List<Integer> collectionNumbers =Collections.synchronizedList(new ArrayList<Integer>());


		public static void check() {
			int[] parameters = getParameter();
			int start = Math.min(parameters[0], parameters[1]);
			int end = Math.max(parameters[0], parameters[1]);
			int count = Runtime.getRuntime().availableProcessors();
			if (parameters[2] < 1) {
				System.out.println(String.format("Count of thread incorrect...%nDefault count thread is %s", count));
			} else {
				count = parameters[2];
			}

			List<CheckerNumberBuffered> checkerNumberBuffered = new ArrayList<>();
			preparedChecker(start, end, count, checkerNumberBuffered,collectionNumbers);

			runChecker(checkerNumberBuffered);

			for (CheckerNumberBuffered numberBuffered : checkerNumberBuffered) {
				collectionNumbers.addAll(numberBuffered.getNumberBuffer());
			}
		}

		public static List<Integer> getCollectionNumbers() {
			return collectionNumbers.isEmpty() ? Collections.<Integer>emptyList() : Collections.unmodifiableList(collectionNumbers);
		}

		private static int[] getParameter() {
			int[] result = new int[3];
			try (Scanner scanner = new Scanner(System.in)) {
				System.out.println("Enter lower bound:");
				result[0] = getValue(scanner);
				System.out.println("Enter upper bound:");
				result[1] = getValue(scanner);
				System.out.println("Enter threads count:");
				result[2] = getValue(scanner);
			}
			return result;
		}

		private static void preparedChecker(final int start, final int end, final int count, final List<ChekerConcurrentBuffered> checkerNumberBuffered, List<Integer> collectionNumbers) {
			int countThread;
			if (end < count) {
				countThread = end;
			} else {
				countThread = count;
			}
			int interval = (end - start + 1) / countThread;
			int lowerBound = start;
			int upperBound = start + interval;
			for (int index = 0; index < countThread; index++) {
				if (upperBound <= end) {
					checkerNumberBuffered.add(index, new ChekerConcurrentBuffered(collectionNumbers, lowerBound, upperBound));
					lowerBound = upperBound + 1;
					upperBound += interval;
				}
			}
		}

		private static void runChecker(final List<CheckerNumberBuffered> checkerNumberBuffered) {
			for (CheckerNumberBuffered number : checkerNumberBuffered) {
				Thread thread = new Thread(number);
				thread.start();
				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		private static int getValue(final Scanner scanner) {
			while (true) {
				String line = scanner.nextLine();
				try {
					return Integer.parseInt(line);
				} catch (NumberFormatException e) {
					System.out.println("Incorrect input, expected number");
					System.out.println("Enter correct value:");
				}
			}
		}
	}


