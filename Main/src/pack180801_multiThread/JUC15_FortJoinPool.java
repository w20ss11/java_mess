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
		//RecursiveTask<Long>�̳�ForkJoinTask<Long>�̳�Future<T>
		Long sum = pool.invoke(task);
		System.out.println(sum);
		
		Instant end = Instant.now();
		//���ʱ��ʹ�������ʱ��Ƚ�
		System.out.println("�ķ�ʱ�䣺"+Duration.between(start, end).toMillis());//88
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
		System.out.println("�ķ�ʱ�䣺"+Duration.between(start, end).toMillis());
	}
	
//	@Test
//	//java8������
//	public void test2(){
//		Instant start = Instant.now();
//				
//		Long sum = LongStream.rangeClosed(0L,100000000L)
//							.parallel()
//							.reduce(0L,Long::sum);
//		
//		Instant end = Instant.now();//46
//		System.out.println("�ķ�ʱ�䣺"+Duration.between(start, end).toMillis());
//	}
}
class ForkJoinSumCalc extends RecursiveTask<Long>{//Recursive���ݹ�
	private static final long serialVersionUID = 1L;

	private long start;
	private long end;
	private static final long THRESHOLD = 10000L;//�ٽ�ֵ
	
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
			left.fork();//���в�֣�ͬʱѹ���̶߳���
			ForkJoinSumCalc right = new ForkJoinSumCalc(mid+1, end);
			right.fork();
			
			return left.join()+right.join();
			
		}
	}
	
}