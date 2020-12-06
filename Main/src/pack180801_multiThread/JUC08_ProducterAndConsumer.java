package pack180801_multiThread;

public class JUC08_ProducterAndConsumer {
//�����ߺ������߰���
	public static void main(String[] args) {
		Clerk clerk = new Clerk();
		Productor pro = new Productor(clerk);
		Consumer cos = new Consumer(clerk);
		new Thread(pro,"������A").start();
		new Thread(cos,"������B").start();
		
		/**
		 * ����:�������̹߳��죬���Ϸ����ݣ���һ���Ѿ������Խ��գ���������ݶ�ʧ
		                �������̹߳��죬���Ͻ������ݣ���һ��û�з��ͣ����ܲ����ظ������ݻ��ߴ��������
		        ���:�ȴ����ѻ���
		                  �����Ʒ���ˣ���wait(),��������֪ͨ�������ӳɹ�����notifyall()֪ͨ��������
		                  ���ȱ������wait()�� ����ɹ�ȡ�߲�Ʒ��˵���п�λ�ˣ��Ϳ���֪ͨ�����߼�������
		 */
	}

}
class Clerk{//��Ա
	private int product = 0;
	//����
	public synchronized void get(){//��10����λ
		if(product>=10){
			System.out.println("��Ʒ����");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			//��λû���� ��Ա���һ����
			System.out.println(Thread.currentThread().getName()+":"+ ++product);
			this.notifyAll();
		}
	}
	//����
	public synchronized void sale(){
		if(product<=0){
			System.out.println("ȱ����");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else{
			System.out.println(Thread.currentThread().getName()+":"+ --product);
			this.notifyAll();
		}
	}
}
class Productor implements Runnable{//������
	private Clerk clerk;
	public Productor(Clerk clerk) {
		this.clerk = clerk;
	}

	@Override
	public void run() {
		for(int i=0;i<20;i++){
			clerk.get();
		}
	}
}
class Consumer implements Runnable{//������
	private Clerk clerk;
	public Consumer(Clerk clerk) {
		this.clerk = clerk;
	}
	@Override
	public void run() {
		for(int i=0;i<20;i++){
			clerk.sale();
		}
	}
}