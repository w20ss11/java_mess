package pack180801_multiThread;

import java.util.concurrent.CountDownLatch;

public class JUC05_CountDownLatch {
//����:�����ĳЩ���㣬ֻ�������̵߳�����ȫ����ɣ���ǰ����Ż����ִ��
	public static void main(String[] args) {
		//����ʮ���̵߳�����ʱ��
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
		System.out.println("�ķ�ʱ�䣺"+(end-start));//11���߳�ͬʱִ�У��޷������м����ִ��ʱ��
		//ʹ���̵߳ȴ�����10���߳�ִ����ɲ�ִ��ʱ�����
	}

}
class LatchDemo implements Runnable{
	private CountDownLatch latch;
	public LatchDemo(CountDownLatch latch){
		this.latch = latch;
	}
	@Override
	public void run() {
		synchronized (this) {//����̣߳���ȫ����
			try {
				for(int i=0;i<50000;i++){
					if(i%2==0)
						System.out.println(i);
				}
			} finally {//ÿ���̱߳���ִ�����ݼ�1
				latch.countDown();
				//ÿ���̵߳�ִ�����ʱ������ݼ�1�����ݼ���0ʱ�����в��������
			}
		}
	}
}
