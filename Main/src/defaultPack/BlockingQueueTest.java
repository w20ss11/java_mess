package defaultPack;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTest {
	private static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5, true); //�������Ϊ5�������������
	//private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(5);
	
	private static CountDownLatch producerLatch; //����ʱ������
	private static CountDownLatch consumerLatch;
	
	public static void main(String[] args) {
		BlockingQueueTest queueTest = new BlockingQueueTest();
		queueTest.test();
	}
	
	private void test(){
		producerLatch = new CountDownLatch(10); //stateֵΪ10
		consumerLatch = new CountDownLatch(10); //stateֵΪ10
		
		Thread t1 = new Thread(new ProducerTask());
		Thread t2 = new Thread(new ConsumerTask());

		//�����߳�
		t1.start();
		t2.start();
		
//		try {
//			System.out.println("producer waiting...");
//			producerLatch.await(); //����ȴ�״̬��ֱ��stateֵΪ0���ټ�������ִ��
//			System.out.println("producer end");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		try {
//			System.out.println("consumer waiting...");
//			consumerLatch.await(); //����ȴ�״̬��ֱ��stateֵΪ0���ټ�������ִ��
//			System.out.println("consumer end");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}

		//�����߳�
		//t1.interrupt(); 
		//t2.interrupt();
		
		//System.out.println("end");
	}
	
	//������
	class ProducerTask implements Runnable{
		private Random rnd = new Random();
		
		@Override
		public void run() {
			try {
				while(true){
					queue.put(rnd.nextInt(100)); //���queue������������ǰ�̻߳������ֱ���пռ��ټ���
					
					//offer����Ϊ�Ƕ�����
					//queue.offer(rnd.nextInt(100), 1, TimeUnit.SECONDS); //�ȴ�1��󻹲��ܼ�������򷵻�ʧ�ܣ���������
					//queue.offer(rnd.nextInt(100));
					
					producerLatch.countDown(); //stateֵ��1
					//TimeUnit.SECONDS.sleep(2); //�߳�����2��
				}
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}  catch (Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	//������
	class ConsumerTask implements Runnable{
		@Override
		public void run() {
			try {
				while(true){
					Integer value = queue.take(); //���queueΪ�գ���ǰ�̻߳������ֱ���������ݼ���
					
					//poll����Ϊ�Ƕ�����
					//Integer value = queue.poll(1, TimeUnit.SECONDS); //�ȴ�1���û�����ݿ�ȡ�򷵻�ʧ�ܣ�������ȡ
					//Integer value = queue.poll();
					
					System.out.println("value = " + value);
					
					consumerLatch.countDown(); //stateֵ��1
					TimeUnit.SECONDS.sleep(2); //�߳�����2��
				}
			} catch (InterruptedException e) {
				//e.printStackTrace();
			} catch (Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
}