package homework;

import com.google.common.base.Stopwatch;
import homework.task1.CheckerService;

import java.util.Scanner;

public class Main {

	
	private Main() {
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("HOMEWORK #8");
		showMenu(scanner);
		System.out.println("Good bay");
	}


	private static void showMenu(final Scanner scanner) {
		System.out.println("Menu:");
		System.out.println("1 - start task 1");
		System.out.println("2 - start task 2");
		System.out.println("3 - exit");
		boolean flag = true;
		while (flag) {
			System.out.println("Select menu item:");
			String input = scanner.nextLine();
			switch (input) {
				case "1":
					CheckerService.inputParameter();
					Stopwatch stopwatch = Stopwatch.createStarted();
					CheckerService.check(false);
					System.out.println(String.format("storing numbers in separate collections of each stream:%n%s", CheckerService.getSimpleNumbers()));
					System.out.println(String.format("saving speed is %s", stopwatch));
					stopwatch.reset();
					stopwatch.start();
					CheckerService.check(true);
					System.out.println(String.format("storing numbers in the general collection:%n%s", CheckerService.getSimpleNumbers()));
					System.out.println(String.format("saving speed is %s", stopwatch));
					stopwatch.stop();
					break;
				case "2":
					System.out.println("Not implements yet");
					break;
				case "3":
					flag = false;
					scanner.close();
					break;
				default:
					System.out.println("Enter incorrect menu item\nExpected from 1 to 3");
			}
		}
	}

}

