package pack180801_multiThread;

public class JUC12_Thread8Monitor {
/**
 * ��Ŀ���жϴ�ӡ���ǡ�one�����ǡ�two��
 * 1. ������ͨͬ�������������̣߳���׼��ӡ		           �����one two��û��sleep��䣬������ӡ��
 * 2. ����Thread.sleep()���� ��getOne       �����one two��3s֮������һ���ӡ������
 * 3. ������ͨ����getThree()				�����three one two�������ӡthree����3s��ӡone two��
 * 4. ������ͨͬ������������Number���󣬴�ӡ                 �����two one��two����������one��3s��
 * 5. �޸�getOneΪ��̬ͬ����������ӡ                                �����two one��two����������one��3s��
 * 6. �޸�������Ϊ��̬ͬ��������һ��Number����             �����one two��3s������һ���ӡ������
 * 7. һ���Ǿ�̬ͬ��������һ���Ǿ�̬ͬ������������Number����   �����two one��two����������one��3s��
 * 8. ������Ϊ��̬ͬ������������Number����                                     �����one two��3s������һ���ӡ������
 * 
 * �̰߳����Ĺؼ���
 * 1.�Ǿ�̬��������Ĭ��Ϊ��this����̬��������Ϊ ��ӦClassʵ����Number.class��
 * 2.ĳһʱ���ڣ�ֻ����һ���̳߳����������ۼ�������
 * */
	public static void main(String[] args) {
		final Number number = new Number();
		final Number number2 = new Number();
		new Thread(new Runnable() {
			@Override
			public void run() {
				number.getOne();
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				number2.getTwo();
//				number.getTwo();
			}
		}).start();
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				number.getThree();
//			}
//		}).start();
	}

}
class Number{
	public static synchronized void getOne(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("one");
	}
	public static synchronized void getTwo(){
		System.out.println("two");
	}
	public void getThree(){
		System.out.println("three");
	}
}
