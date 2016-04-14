package homework.task1;

class SimpleNumber {




	static void output(int start, int end) {

		for (int i = start; i <= end; i++) {
			if (isSimpleNumber(i)) {

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
