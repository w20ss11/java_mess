package pack180801_multiThread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class JUC11_ReadWriteLock {
/**
 * 写只能有一个，读可以有多个
 * 1.ReadWriteLock:读写锁
 * 写写（需要互斥）/读写（需要互斥） 即一次只能执行一个
 * 读读 不需要互斥
 * */
	public static void main(String[] args) {
		final ReadWriteLockDemo rw = new ReadWriteLockDemo();
		//一个线程去写，10个线程去读
		new Thread(new Runnable() {
			@Override
			public void run() {
				rw.set((int)(Math.random()*101));
			}
		},"write").start();
		for(int i=0;i<10;i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					rw.get();
				}
			}).start();
		}
	}

}

class ReadWriteLockDemo{
	private int number = 0;
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	//读
	public void get(){
		lock.readLock().lock();//上锁
		try {
			System.out.println(Thread.currentThread().getName()+":"+number);
		} finally {
			lock.readLock().unlock();//释放锁
		}
		
	}
	//写
	public void set(int number){
		lock.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName());
			this.number = number;
		} finally {
			lock.writeLock().unlock();
		}
		
	}
}
