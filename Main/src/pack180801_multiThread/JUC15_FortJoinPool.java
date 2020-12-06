package pack180801_multiThread;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

import org.junit.Test;

public class JUC15_FortJoinPool {

	public static void main(String[] args) {
		Instant start = Instant.now();
		
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new ForkJoinSumCalc(0L, 100000000L);
		//RecursiveTask<Long>继承ForkJoinTask<Long>继承Future<T>
		Long sum = pool.invoke(task);
		System.out.println(sum);
		
		Instant end = Instant.now();
		//拆分时间和串行运行时间比较
		System.out.println("耗费时间："+Duration.between(start, end).toMillis());//88
	}
	
	@Test
	public void test(){
		Instant start = Instant.now();
				
		long sum = 0L;
		for(long i=0L;i<=100000000L;i++){
			sum += i;
		}
		System.out.println(sum);
		
		Instant end = Instant.now();//46
		System.out.println("耗费时间："+Duration.between(start, end).toMillis());
	}
	
//	@Test
//	//java8新特性
//	public void test2(){
//		Instant start = Instant.now();
//				
//		Long sum = LongStream.rangeClosed(0L,100000000L)
//							.parallel()
//							.reduce(0L,Long::sum);
//		
//		Instant end = Instant.now();//46
//		System.out.println("耗费时间："+Duration.between(start, end).toMillis());
//	}
}
class ForkJoinSumCalc extends RecursiveTask<Long>{//Recursive：递归
	private static final long serialVersionUID = 1L;

	private long start;
	private long end;
	private static final long THRESHOLD = 10000L;//临界值
	
	public ForkJoinSumCalc(long start,long end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	protected Long compute() {
		long length = end - start;
		if(length<=THRESHOLD){
			long sum = 0L;
			for(long i = start;i <= end;i++){
				sum += i;
			}
			return sum;
		}else{
			long mid = (start+end)/2;
			ForkJoinSumCalc left = new ForkJoinSumCalc(start, mid);
			left.fork();//进行拆分，同时压入线程队列
			ForkJoinSumCalc right = new ForkJoinSumCalc(mid+1, end);
			right.fork();
			
			return left.join()+right.join();
			
		}
	}
	
}