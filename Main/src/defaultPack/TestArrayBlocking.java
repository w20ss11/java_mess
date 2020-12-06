package defaultPack;
import java.util.concurrent.ArrayBlockingQueue;


public class TestArrayBlocking {
	public static void main(String[] args) throws Exception {
//		insertBlocking();
//		fetchBlocking();
		
		ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<String>(10);
		testProducerConsumer(abq);
		
	}
	
	   
	/**
	 * �˷���չʾ�� ArrayBlockingQueue �Ĳ����������� ����������Ѿ����ˣ���ô����Ĳ����ͻᱻ����������ִ�оͻᱻ����ͣ��
	 */
	public static void insertBlocking() throws InterruptedException {
		ArrayBlockingQueue<String> names = new ArrayBlockingQueue<String>(1);
		System.out.println("����ִ�е���...1");
		names.put("a");
		System.out.println("����ִ�е���...2");
		
		// ����һ�俪ʼ����ľͲ��ᱻִ����
		names.put("b");
		
		System.out.println("����ִ�е���...3");
	}
	
	/**
	 * �˷���չʾ�� ArrayBlockingQueue ��ȡ���������� ���������Ϊ�գ���ôȡ�Ĳ����ͻᱻ����������ִ�оͻᱨ��
	 * 
	 */
	public static void fetchBlocking() throws InterruptedException {
		ArrayBlockingQueue<String> names = new ArrayBlockingQueue<String>(1);
		names.put("a");
		System.out.println("����ִ�е���...1");
		names.remove();
		System.out.println("����ִ�е���...2");
		names.remove();
		System.out.println("����ִ�е���...3");
		names.put("b");
		
		System.out.println("����ִ�е���...");
	}
	
	   
	/**
	 * @���� �˷����������������ߺ�������
	 * Ϊ���ó����ڻ�ȡ����Ԫ��ʱ�����������ַ�ʽ��
	 * 1.�������ߵ������ٶȴ��������ߵ������ٶ�
	 * 2.�������߻�ȡ��Դ����ʱ���������߳���ͣһ��ʱ�䣬���������
	 * @param abq 
	 */
	public static void testProducerConsumer (ArrayBlockingQueue<String> abq) {
		Thread tConsumer = new Consumer(abq);
		Thread tProducer = new Producer(abq);
		tConsumer.start();
		tProducer.start();
	}
	
}

   
/**            
 * @���� ����������
 *    
 */       
class Consumer extends Thread {
	ArrayBlockingQueue<String> abq = null;

	public Consumer(ArrayBlockingQueue<String> abq) {
		super();
		this.abq = abq;
	}
	
	@Override
	public void run() {
		while(true) {
			try{
				Thread.sleep(500);
				String msg = abq.remove();
				System.out.println("ȡ���ݣ�===="+msg+"\tʣ����������"+abq.size());
			} catch (Exception e) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}

   
/**            
 * @���� ����������
 *    
 */       
class Producer extends Thread {
	ArrayBlockingQueue<String> abq = null;

	public Producer(ArrayBlockingQueue<String> abq) {
		this.abq = abq;
	}

	@Override
	public void run() {
		int i = 0;
		while(true) {
			try {
				Thread.sleep(1000);
				abq.put(""+i);
				System.out.println("������ݣ�===="+i+"\tʣ����������"+abq.size());
				i++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}


