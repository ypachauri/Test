package interview;

public class ThreadExp {
	
	synchronized void SyncTest(String thread)
	{
		for(int i = 0; i < 5; i++)
		{
			System.out.println(thread);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notify();
	}
	
	synchronized void W8NtfyTest() throws InterruptedException
	{
		System.out.println("Waiting");
		wait();
		System.out.println("Done");
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadExp threadExp = new ThreadExp();
		// Join method
		/*Thread1 thread1 = new Thread1();
		thread1.start();
		thread1.join();
		Thread thread2 = new Thread(new Thread2());
		thread2.start();*/
		
		// synchronization
		/*Thread3 thread3 = new Thread3(threadExp);
		thread3.start();
		Thread thread4 = new Thread(new Thread4(threadExp));
		thread4.start();*/
		
		// Wait & Notify
		Thread5 thread5 = new Thread5(threadExp);
		thread5.start();
		Thread thread6 = new Thread(new Thread6(threadExp));
		thread6.start();
	}

}
/*class Thread1 extends Thread
{
	@Override
	public void run()
	{
		for(int i = 0; i < 10; i++)
		{
			System.out.println("Thread1 := "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
class Thread2 implements Runnable
{
	@Override
	public void run()
	{
		for(int i = 10; i < 20; i++)
		{
			System.out.println("Thread2 := "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}*/
/*class Thread3 extends Thread
{
	ThreadExp t;
	Thread3(ThreadExp t) {
		this.t = t;
	}
	
	@Override
	public void run()
	{
		t.SyncTest("Thread3");
	}
}
class Thread4 implements Runnable
{
	ThreadExp t;
	Thread4(ThreadExp t) {
		this.t = t;
	}
	
	@Override
	public void run()
	{
		t.SyncTest("Thread4");
	}
}*/
class Thread5 extends Thread
{
	ThreadExp t;
	Thread5(ThreadExp t) {
		this.t = t;
	}
	
	@Override
	public void run()
	{
		try {
			t.W8NtfyTest();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Thread6 implements Runnable
{
	ThreadExp t;
	Thread6(ThreadExp t) {
		this.t = t;
	}
	
	@Override
	public void run()
	{
		t.SyncTest("Notify");
	}
}