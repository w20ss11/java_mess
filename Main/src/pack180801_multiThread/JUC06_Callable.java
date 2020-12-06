package pack180801_multiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class JUC06_Callable {
//创建执行线程的方式三：实现callable接口,相较于实现Runnable接口的方式，方法可以有返回值，并且可以抛出异常
	public static void main(String[] args) {
		ThreadDemo1 td = new ThreadDemo1();
		//执行callable方式，因为要接受返回值，需要FutureTask实现类的支持，用于接收运算结果
		//FutureTask 是Future接口的实现类
		FutureTask<Integer> result = new FutureTask<Integer>(td);
		new Thread(result).start();
		//接收线程运算后的结果
		
		try {
			Integer sum = result.get();
			System.out.println(sum);
			System.out.println("--------------------");
			//FutureTask可用于闭锁的操作，下方改为Interger.MaxValue，这里主线程的打印并没有执行，而是在等待子线程执行完毕
			//但主线程的其他运算仍然在运算，所以效率高
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} 
	}

}

class ThreadDemo1 implements Callable<Integer>{
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i=0;i<=100;i++){//Integer.MAX_VALUE
			System.out.println(i);
			sum = sum+i;
		}
		return sum;
	}
	
}

//class ThreadDemo implements Runnable{
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//	}
//}