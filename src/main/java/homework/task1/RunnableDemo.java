package homework.task1;

public class RunnableDemo implements Runnable{

	private Thread t;
	private String threadName;


	RunnableDemo(String name){
		threadName = name;
		System.out.println("Creating " +  threadName );
	}

	@Override
	public void run() {
		System.out.println("Running " + threadName);

		try {

				SimpleNumber.output();

				Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	public void start(){
		if (t == null)
		{
			t = new Thread (this, threadName);
			t.start ();
		}
	}


}
