package pack180801_multiThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JUC07_Lock {
	//同步锁，相较于synchronized更灵活 是一个显示锁
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		new Thread(ticket,"1号窗口").start();
		new Thread(ticket,"2号窗口").start();
		new Thread(ticket,"3号窗口").start();
	}

}

class Ticket implements Runnable{
	private int tick = 100;
	private Lock lock = new ReentrantLock();

	@Override
	public void run() {
		while(true){
			lock.lock();//上锁
			try {
				if(tick>0){
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"完成售票，余票为："+ --tick);;
				}
			} finally {
				lock.unlock();//释放锁
			}
		}

	}

}
