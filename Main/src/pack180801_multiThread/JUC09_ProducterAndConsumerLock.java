package pack180801_multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JUC09_ProducterAndConsumerLock {
//�����ߺ������߰���
	public static void main(String[] args) {
		Clerk4 clerk = new Clerk4();
		Productor4 pro = new Productor4(clerk);
		Consumer4 cos = new Consumer4(clerk);
		new Thread(pro,"������A").start();
		new Thread(pro,"������B").start();
		new Thread(cos,"������C").start();
		new Thread(cos,"������D").start();
		
		/**
		 * ����:�����õ�lock�������wait��notifyall�õ�this�������lockҲ�������Լ���wait��notifyall��ʽ
		 * ���:condition������Ҳ��await��signalAll������condition����ͨ��lock��ȡ
		 */
	}

}
class Clerk4{//��Ա
	private int product = 0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	//����
	public void get(){//��10����λ
		lock.lock();
		try {
			while(product>=1){
				System.out.println("��Ʒ����");
				try {
					condition.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			//��λû���� ��Ա���һ����
			System.out.println(Thread.currentThread().getName()+":"+ ++product);
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
	//����
	public void sale(){
		lock.lock();
		try {
			while(product<=0){
				System.out.println("ȱ����");
				try {
					condition.await();;//��1��
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
class Productor4 implements Runnable{//������
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
class Consumer4 implements Runnable{//������
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