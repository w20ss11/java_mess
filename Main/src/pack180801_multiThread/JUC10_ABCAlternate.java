package pack180801_multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JUC10_ABCAlternate {
/**��дһ�����򣬿���A B C3���̣߳�ÿ���߳�ID��ӡ10�飬����˳����ʾ
 * �磺ABCABCABC.....һ�εݹ�
 * 
 * */
	public static void main(String[] args) {
		final AlternateDemo ad = new AlternateDemo();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<20;i++){
					ad.loopA(i);
				}
			}
		},"A").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<20;i++){
					ad.loopB(i);
				}
			}
		},"B").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<20;i++){
					ad.loopC(i);
					System.out.println("---------------------");
				}
			}
		},"C").start();
	}

}

class AlternateDemo{
	private int number = 1;//��ʾ����ִ���̵߳ı��
	private Lock lock = new ReentrantLock();
	private Condition condition1 = lock.newCondition();
	private Condition condition2 = lock.newCondition();
	private Condition condition3 = lock.newCondition();
	public void loopA(int totalLoop){//���ǵڼ���
		lock.lock();
		try {
			//1.�ж��̱߳���Ƿ�Ϊ1����1��ִ��
			if(number!=1){
				condition1.await();
			}
			//2.�����ӡ
			for(int i=0;i<5;i++){//ÿһ�ִ�ӡ5��
				System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
			}
			//3.��ӡ���ѱ���
			number = 2;
			condition2.signal();//ֻ����2
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	public void loopB(int totalLoop){//���ǵڼ���
		lock.lock();
		try {
			//1.�ж��̱߳���Ƿ�Ϊ2����2��ִ��
			if(number!=2){
				condition2.await();
			}
			//2.�����ӡ
			for(int i=0;i<15;i++){//ÿһ�ִ�ӡ15��
				System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
			}
			//3.��ӡ���ѱ���
			number = 3;
			condition3.signal();//ֻ����3
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	public void loopC(int totalLoop){//���ǵڼ���
		lock.lock();
		try {
			//1.�ж��̱߳���Ƿ�Ϊ3����3��ִ��
			if(number!=3){
				condition3.await();
			}
			//2.�����ӡ
			for(int i=0;i<20;i++){//ÿһ�ִ�ӡ5��
				System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
			}
			//3.��ӡ���ѱ���
			number = 1;
			condition1.signal();//ֻ����2
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
