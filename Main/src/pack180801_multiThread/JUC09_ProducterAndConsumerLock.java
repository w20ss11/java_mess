package pack180801_multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JUC09_ProducterAndConsumerLock {
//生产者和消费者案例
	public static void main(String[] args) {
		Clerk4 clerk = new Clerk4();
		Productor4 pro = new Productor4(clerk);
		Consumer4 cos = new Consumer4(clerk);
		new Thread(pro,"生产者A").start();
		new Thread(pro,"生产者B").start();
		new Thread(cos,"消费者C").start();
		new Thread(cos,"消费者D").start();
		
		/**
		 * 问题:现在用的lock这把锁，wait和notifyall用的this这把锁，lock也有属于自己的wait和notifyall方式
		 * 解决:condition对象中也有await、signalAll方法，condition对象通过lock获取
		 */
	}

}
class Clerk4{//店员
	private int product = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	//进货
	public void get(){//有10个货位
		lock.lock();
		try {
			while(product>=1){
				System.out.println("产品已满");
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//货位没有满 店员添加一个货
			System.out.println(Thread.currentThread().getName()+":"+ ++product);
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
	//卖货
	public void sale(){
		lock.lock();
		try {
			while(product<=0){
				System.out.println("缺货！");
				try {
					condition.await();;//（1）
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+":"+ --product);
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
}
class Productor4 implements Runnable{//生产者
	private Clerk4 clerk;
	public Productor4(Clerk4 clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			clerk.get();
		}
	}
}
class Consumer4 implements Runnable{//消费者
	private Clerk4 clerk;
	public Consumer4(Clerk4 clerk) {
		this.clerk = clerk;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			clerk.sale();
		}
	}
}