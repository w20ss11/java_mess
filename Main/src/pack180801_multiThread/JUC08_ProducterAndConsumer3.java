package pack180801_multiThread;

public class JUC08_ProducterAndConsumer3 {
//�����ߺ������߰���
	public static void main(String[] args) {
		Clerk3 clerk = new Clerk3();
		Productor3 pro = new Productor3(clerk);
		Consumer3 cos = new Consumer3(clerk);
		new Thread(pro,"������A").start();
		new Thread(pro,"������B").start();
		new Thread(cos,"������C").start();
		new Thread(cos,"������D").start();
		
		/**
		 * ����:�����˸���
		 * ԭ��:һ��������ȱ�����ڣ�1����wait��Ȼ����һ��������������Դ��Ҳ�ڣ�1����wait
		                  ������notifyall�����������߻��ѣ����ӣ�1��������ִ�У�����--product��������Ϊ��ٻ���
		 * ���:waitʹ����ѭ���У�if��Ϊwhile����ʹ�������ߣ����������ߣ��ڱ�����ʱ����ȥ�ж�һ��
		 */
	}

}
class Clerk3{//��Ա
	private int product = 0;
	//����
	public synchronized void get(){//��10����λ
		while(product>=1){
			System.out.println("��Ʒ����");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//��λû���� ��Ա���һ����
		System.out.println(Thread.currentThread().getName()+":"+ ++product);
		this.notifyAll();
	}
	//����
	public synchronized void sale(){
		while(product<=0){
			System.out.println("ȱ����");
			try {
				this.wait();//��1��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+":"+ --product);
		this.notifyAll();
	}
}
class Productor3 implements Runnable{//������
	private Clerk3 clerk;
	public Productor3(Clerk3 clerk) {
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
class Consumer3 implements Runnable{//������
	private Clerk3 clerk;
	public Consumer3(Clerk3 clerk) {
		this.clerk = clerk;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			clerk.sale();
		}
	}
}