package pack180801_multiThread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class JUC11_ReadWriteLock {
/**
 * дֻ����һ�����������ж��
 * 1.ReadWriteLock:��д��
 * дд����Ҫ���⣩/��д����Ҫ���⣩ ��һ��ֻ��ִ��һ��
 * ���� ����Ҫ����
 * */
	public static void main(String[] args) {
		final ReadWriteLockDemo rw = new ReadWriteLockDemo();
		//һ���߳�ȥд��10���߳�ȥ��
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
	//��
	public void get(){
		lock.readLock().lock();//����
		try {
			System.out.println(Thread.currentThread().getName()+":"+number);
		} finally {
			lock.readLock().unlock();//�ͷ���
		}
		
	}
	//д
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
