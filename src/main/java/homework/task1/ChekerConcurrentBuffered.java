package homework.task1;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class ChekerConcurrentBuffered implements Runnable {


	private final List<Integer> collectionNumbers;
	//	private List<Integer> numberBuffer = new ArrayList<>();
	private int start;
	private int end;

	ChekerConcurrentBuffered(final List<Integer> collectionNumbers, final int start, final int end) {
		this.collectionNumbers = collectionNumbers;
		this.start = start;
		this.end = end;

	}

	@Override
	public void run() {
		for (int index = start; index <= end; index++) {
			if (isSimpleNumber(index)) {
				collectionNumbers.add(index);
			}
		}
	}

/*	List<Integer> getNumberBuffer() {
		return numbersList;
	}*/

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


