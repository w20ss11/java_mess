package pack180801_multiThread;

import java.util.concurrent.atomic.AtomicInteger;

public class JUC02_atomic {
/**
 *  i=i++;
 *  
 *  int temp = i;
 *  i = i+1;
 *  i = temp;
 */
	public static void main(String[] args) {
		AtomicDemo ad = new AtomicDemo();
		for(int i=0;i<10;i++){
			new Thread(ad).start();
		}
	}

}

class AtomicDemo implements Runnable{
//	private int serialNumber = 0;
	private AtomicInteger serialNumber = new AtomicInteger();

	public int getSerialNumber() {
		return serialNumber.getAndIncrement();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+":"+getSerialNumber());
		
	}
	
}
