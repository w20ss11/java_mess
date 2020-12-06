package pack180801_multiThread;

import java.util.concurrent.CountDownLatch;

public class JUC05_CountDownLatch {
//闭锁:在完成某些运算，只有所有线程的运算全部完成，当前运算才会继续执行
	public static void main(String[] args) {
		//计算十个线程的运行时间
		final CountDownLatch latch = new CountDownLatch(10);
		LatchDemo latchDemo = new LatchDemo(latch);
		
		long start = System.currentTimeMillis();
		
		for(int i=0;i<10;i++){
			new Thread(latchDemo).start();
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println("耗费时间："+(end-start));//11个线程同时执行，无法计算中间代码执行时间
		//使主线程等待，让10个线程执行完成才执行时间计算
	}

}
class LatchDemo implements Runnable{
	private CountDownLatch latch;
	public LatchDemo(CountDownLatch latch){
		this.latch = latch;
	}
	@Override
	public void run() {
		synchronized (this) {//多个线程，安全问题
			try {
				for(int i=0;i<50000;i++){
					if(i%2==0)
						System.out.println(i);
				}
			} finally {//每个线程必须执行这句递减1
				latch.countDown();
				//每次线程当执行这句时，都会递减1，当递减到0时，所有操作就完成
			}
		}
	}
}
