package pack180801_multiThread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JUC14_ScheduledThreadPool {
/**
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
 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
		
		for(int i=0;i<10;i++){//������5������10�߳���������5���߳��е��ظ�������
			Future<Integer> result = pool.schedule(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					int num = new Random().nextInt(100);//���������
					System.out.println(Thread.currentThread().getName()+":"+num);
					return num;
				}
			}, 1, TimeUnit.SECONDS);//�ӳ�1sִ��
			
			System.out.println(result.get());
		}
		pool.shutdown();
	}

}
