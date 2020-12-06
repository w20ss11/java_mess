package pack180801_multiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JUC13_ThreadPool {
/**
 * �̳߳أ��ṩ��һ���̶߳��У������б��������еȴ�״̬���̡߳������˴����������̶߳���Ŀ������������Ӧ���ٶ�
 * �̳߳���ϵ�ṹ��java.util.concurrent.Executor:�����̵߳�ʹ�ú͵��ȵĸ��ӿ�
 *       |--ExecutorService �ӽӿڣ��̳߳ص���Ҫ�ӿڣ��ص㣩
 *           |--ThreadPoolExecutor �̳߳�ʵ����
 *           |--ScheduledExecutorService �ӽӿڣ������̵߳����ӽӿ�
 *             |--ScheduledThreadPoolExecutor���̳���ThreadPoolExecutor��ʵ����ScheduledExecutorService
 * ������Excutors�ṩ�˷�����ȡ���ӳأ�Ԥ���趨�Ѿ������ڴ󲿷��龰������������
 *  ExecutorService newFixedThreadPool     �����������̶���С���̳߳�
 *  ExecutorService newCachedThreadPool    �����������̳߳أ��̳߳��������̶������Ը��������Զ���������
 *  ExecutorService newSingleThreadExecutor���������������̳߳أ��̳߳���ֻ��һ���̡߳�
 *  
 *  ScheduledExecutorService newScheduledThreadPool():�����̶���С���̣߳�������ʱ��ʱ��ִ������
 * @throws ExecutionException 
 * @throws InterruptedException 
 * */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//1.�����̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(5);
//		ThreadPoolDemo tpd = new ThreadPoolDemo();
//		//2.Ϊ�̳߳���(׼���õ�)�̷߳�������
//		for(int i=0;i<10;i++){
//			pool.submit(tpd);
//		}
//		//3.�ر��̳߳�
//		pool.shutdown();//�ȴ���������ִ������ٹر�
		
		//------------------------------------------
		
//		new Thread(tpd).start();
//		new Thread(tpd).start();//Ƶ���Ĵ����������߳�Ҳ�ķ���Դ
		
		//---------------------------------------------
		
		List<Future<Integer>> list = new ArrayList<Future<Integer>>();
		for(int i=0;i<10;i++){
			Future<Integer> future = pool.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for(int i=0;i<100;i++){
						sum = sum +i;
					}
					return sum;
				}
			});
			list.add(future);
		}
		pool.shutdown();
		for(Future<Integer> future:list){
			System.out.println(future.get());
		}
		
	}

}

class ThreadPoolDemo implements Runnable{

	private int i = 0;
	@Override
	public void run() {
		while(i <= 100){
			System.out.println(Thread.currentThread().getName()+":"+i++);
		}
	}
	
}
