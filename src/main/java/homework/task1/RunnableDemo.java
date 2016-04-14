package homework.task1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RunnableDemo implements Runnable {

	private Thread t;
	private String threadName;
	private static Scanner scanner = new Scanner(System.in);

	RunnableDemo(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	@Override
	public void run() {
		System.out.println("Running " + threadName);
		int start = getNumber();
		int end = getNumber();
		try {
			if (start < end) {
				SimpleNumber.output(start, end);
			} else {
				System.out.println("not correct ");

			}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public void start() {
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

	private static int getNumber() {
		try {
			System.out.println("enter number:");
			return scanner.nextInt();
		} catch (InputMismatchException e) { //NOSONAR
			System.out.println("Entered number incorrect.");
			return -1;
		}
	}
}
