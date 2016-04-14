package homework.task1;

import java.util.ArrayList;
import java.util.List;

public class CheckerNumberBuffered implements Runnable {
	private List<Integer> numberBuffer = new ArrayList<>();
	private int start;
	private int end;

	public CheckerNumberBuffered(final int start, final int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		for (int index = start; index <= end; index++) {
			if (isSimpleNumber(index)) {
				numberBuffer.add(index);
			}
		}
	}

	public List<Integer> getNumberBuffer() {
		return numberBuffer;
	}

	private boolean isSimpleNumber(int number) {
		int count = 0;
		for (int index = 2; index <= number; index++) {
			if (number % index == 0) {
				count++;
			}
		}
		return count == 1;
	}
}
