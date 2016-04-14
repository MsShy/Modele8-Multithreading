package homework.task1;

public class Main {
	private Main() {
	}



	public static void main(String[] args) {


		//	ExecutorService service = Executors.newCachedThreadPool();
		RunnableDemo R1 = new RunnableDemo("Thread-1");
		R1.start();



	}


}

