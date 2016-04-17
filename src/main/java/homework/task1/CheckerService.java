package homework.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CheckerService {
	private static List<Integer> simpleNumbers;
	private static int start;
	private static int end;
	private static int count;
	private static boolean flag = false;

	public static void setFlag(final boolean flag) {
		CheckerService.flag = flag;
	}

	public static void inputParameter() {
		int[] parameters = getParameter();
		start = Math.min(parameters[0], parameters[1]);
		end = Math.max(parameters[0], parameters[1]);
		count = Runtime.getRuntime().availableProcessors();
		if (parameters[2] < 1) {
			System.out.println(String.format("Count of thread incorrect...%nDefault count thread is %s", count));
		} else {
			count = parameters[2];
		}
	}

	public static void check(final boolean flag) {
		CheckerService.flag = flag;
		simpleNumbers = Collections.synchronizedList(new ArrayList<Integer>());
		List<Checker> checkers = new ArrayList<>();
		preparedChecker(start, end, count, checkers);

		runChecker(checkers);

		for (Checker checker : checkers) {
			if (!checker.isFlag())
				simpleNumbers.addAll(checker.getNumbers());
		}
	}

	public static List<Integer> getSimpleNumbers() {
		return simpleNumbers.isEmpty() ? Collections.<Integer>emptyList() : Collections.unmodifiableList(simpleNumbers);
	}

	private static int[] getParameter() {
		int[] result = new int[3];
		Scanner scanner = new Scanner(System.in);
			System.out.println("Enter lower bound:");
			result[0] = getValue(scanner);
			System.out.println("Enter upper bound:");
			result[1] = getValue(scanner);
			System.out.println("Enter threads count:");
			result[2] = getValue(scanner);

		return result;
	}

	private static void preparedChecker(final int start, final int end, final int count, final List<Checker> checkers) {
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
				Checker checker;
				if (flag) {
					checker = new Checker(lowerBound, upperBound);
				} else {
					checker = new Checker(lowerBound, upperBound, simpleNumbers);
				}

				checkers.add(index, checker);
				lowerBound = upperBound + 1;
				upperBound += interval;
			}
		}
	}

	private static void runChecker(final List<Checker> checker) {
		for (Checker number : checker) {
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
