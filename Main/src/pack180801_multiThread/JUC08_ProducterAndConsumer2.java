package pack180801_multiThread;

public class JUC08_ProducterAndConsumer2 {
//�����ߺ������߰���
	public static void main(String[] args) {
		Clerk2 clerk = new Clerk2();
		Productor2 pro = new Productor2(clerk);
		Consumer2 cos = new Consumer2(clerk);
		new Thread(pro,"������A").start();
		new Thread(cos,"������B").start();
		
		/**
		 * ����:����ûͣ
		 * ԭ��:�������߳�ѭ���������һ�Σ��������߳�ʣ��2�Σ�product=0ʱ��
		                  �����߻�ȡ����Դ����ʼ���ѣ�produce<=0���ԡ�ȱ������wait()��1���������Ѻ��ڣ�1������������ִ�У���ʱ������ѭ������ʣ��Ϊ0���ͷ�����Դ
		                  Ȼ���������õ���Դ��ѭ������ʣ��1�Σ��жϳ�product=0����ӻ���Ȼ��notifyall()���ͷ�����Դ�������������ߺ�������ͬʱ������Դ
		                 ��������������Դ���ӣ�1������ʼ����ִ�У��Ѿ��ж�Ϊif��else����ִ�У����Ծͳ��׽�����
		                 Ȼ���������õ���Դ��product��ʱΪ1����Ʒ��������ʼwait��û�������̻߳��������
		 * ���:ȥ��notifyall()ǰ���else
		 */
	}

}
class Clerk2{//��Ա
	private int product = 0;
	//����
	public synchronized void get(){//��10����λ
		if(product>=1){
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
		if(product<=0){
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
class Productor2 implements Runnable{//������
	private Clerk2 clerk;
	public Productor2(Clerk2 clerk) {
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
class Consumer2 implements Runnable{//������
	private Clerk2 clerk;
	public Consumer2(Clerk2 clerk) {
		this.clerk = clerk;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			clerk.sale();
		}
	}
}