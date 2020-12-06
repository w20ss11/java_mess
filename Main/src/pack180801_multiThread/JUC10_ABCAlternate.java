package pack180801_multiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JUC10_ABCAlternate {
/**编写一个程序，开启A B C3个线程，每个线程ID打印10遍，按照顺序显示
 * 如：ABCABCABC.....一次递归
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
	private int number = 1;//表示正在执行线程的标记
	private Lock lock = new ReentrantLock();
	private Condition condition1 = lock.newCondition();
	private Condition condition2 = lock.newCondition();
	private Condition condition3 = lock.newCondition();
	public void loopA(int totalLoop){//这是第几轮
		lock.lock();
		try {
			//1.判断线程标记是否为1，是1才执行
			if(number!=1){
				condition1.await();
			}
			//2.否则打印
			for(int i=0;i<5;i++){//每一轮打印5次
				System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
			}
			//3.打印后唤醒别人
			number = 2;
			condition2.signal();//只唤醒2
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	public void loopB(int totalLoop){//这是第几轮
		lock.lock();
		try {
			//1.判断线程标记是否为2，是2才执行
			if(number!=2){
				condition2.await();
			}
			//2.否则打印
			for(int i=0;i<15;i++){//每一轮打印15次
				System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
			}
			//3.打印后唤醒别人
			number = 3;
			condition3.signal();//只唤醒3
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	public void loopC(int totalLoop){//这是第几轮
		lock.lock();
		try {
			//1.判断线程标记是否为3，是3才执行
			if(number!=3){
				condition3.await();
			}
			//2.否则打印
			for(int i=0;i<20;i++){//每一轮打印5次
				System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
			}
			//3.打印后唤醒别人
			number = 1;
			condition1.signal();//只唤醒2
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
}
