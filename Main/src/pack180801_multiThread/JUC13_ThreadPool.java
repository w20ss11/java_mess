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
 * 线程池：提供了一个线程队列，队列中保存了所有等待状态的线程。避免了创建与销毁线程额外的开销，提高了响应的速度
 * 线程池体系结构：java.util.concurrent.Executor:负责线程的使用和调度的根接口
 *       |--ExecutorService 子接口：线程池的主要接口（重点）
 *           |--ThreadPoolExecutor 线程池实现类
 *           |--ScheduledExecutorService 子接口：负责线程调度子接口
 *             |--ScheduledThreadPoolExecutor：继承了ThreadPoolExecutor，实现了ScheduledExecutorService
 * 工具类Excutors提供了方法获取连接池，预先设定已经适用于大部分情景，不用再配置
 *  ExecutorService newFixedThreadPool     方法：创建固定大小的线程池
 *  ExecutorService newCachedThreadPool    方法：缓存线程池，线程池数量不固定，可以根据需求自动更改数量
 *  ExecutorService newSingleThreadExecutor方法：创建单个线程池，线程池中只有一个线程。
 *  
 *  ScheduledExecutorService newScheduledThreadPool():创建固定大小的线程，可以延时或定时的执行任务。
 * @throws ExecutionException 
 * @throws InterruptedException 
 * */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//1.创建线程池
		ExecutorService pool = Executors.newFixedThreadPool(5);
//		ThreadPoolDemo tpd = new ThreadPoolDemo();
//		//2.为线程池中(准备好的)线程分配任务
//		for(int i=0;i<10;i++){
//			pool.submit(tpd);
//		}
//		//3.关闭线程池
//		pool.shutdown();//等待现有任务执行完毕再关闭
		
		//------------------------------------------
		
//		new Thread(tpd).start();
//		new Thread(tpd).start();//频繁的创建和销毁线程也耗费资源
		
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
