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
 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
		
		for(int i=0;i<10;i++){//池中有5个，有10线程任务，所以5个线程有的重复利用了
			Future<Integer> result = pool.schedule(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					int num = new Random().nextInt(100);//生成随机数
					System.out.println(Thread.currentThread().getName()+":"+num);
					return num;
				}
			}, 1, TimeUnit.SECONDS);//延迟1s执行
			
			System.out.println(result.get());
		}
		pool.shutdown();
	}

}
